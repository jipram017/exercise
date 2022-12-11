'use strict';

const github = require('@actions/github');
const fs = require('fs');
const date = new Date().toISOString().slice(0, 10);
const { Base64 } = require("js-base64");
const { context = {} } = github;
const {GITHUB_TOKEN, GITHUB_SHA} = process.env;
const octokit = github.getOctokit(GITHUB_TOKEN);
const changelogFilename = 'CHANGELOG.md';
const changelogAddMessage = 'Added CHANGELOG.md file';
const changelogUpdateMessage = 'Updated CHANGELOG.md file';

async function run() {
    const pull_request = context.payload.pull_request
    console.log(pull_request)
    const pull_request_title = context.payload.pull_request.title
    console.log(pull_request_title)
    const regex = /#Release v([A-Za-z0-9]+(\.[A-Za-z0-9]+)+)\./i;
    const matches =  pull_request_title.match(regex);
    console.log(matches)
    const latest_version = matches?.matches[2];

    const response = await octokit.rest.repos.getContent(  {
        ...context.owner,
        ...context.repo,
        path: changelogFilename
    });
    console.log(response)
    const status = response?.status
    const latest_content = response?.data?.content
    const sha = response?.data?.sha;

    if(status != 200){
        await createChangelog()
    }
    else if(latest_content != null){
        await updateChangelog(latest_content, latest_version, sha);
    }
    await createReleaseTag(latest_version);
}

async function createChangelog() {
    let changelog = fs.readFileSync(
        require.resolve("../src/init.md"),
        {encoding: 'utf8'}
    );

    const response = await octokit.rest.repos.getLatestRelease({
        ...context.owner,
        ...context.repo
    });
    console.log(response)
    let version = response?.data?.tag_name || 'v1.0.0'
    const githubUrl = context.repo.concat(`/compare/${version}...HEAD`);
    console.log(githubUrl)
    changelog = changelog.replace('[Unreleased]:', `[Unreleased]: ${githubUrl}`);
    pushNewFile(changelog).then(
        response => console.log(response)
    );
}

async function pushNewFile(changelog) {
    const contentEncoded = Base64.encode(changelog);
    const response = octokit.rest.repos.createOrUpdateFileContents({
        ...context.owner,
        ...context.repo,
        path: changelogFilename,
        message: changelogAddMessage,
        content: contentEncoded
    });
    console.log(response)
    return response?.status || 500;
}

async function updateChangelog(content, version, sha) {
    const contentDecoded = Base64.decode(content);
    console.log(contentDecoded)
    let changelog = updateUpperSection(contentDecoded, version);
    console.log(changelog)
    changelog = updateBottomSection(changelog, version);
    console.log(changelog)
    pushUpdatedFile(changelog, sha).then(
        response => console.log(response)
    );
}

async function pushUpdatedFile(changelog, sha) {
    const contentEncoded = Base64.encode(changelog);
    const response = await octokit.rest.repos.createOrUpdateFileContents({
        ...context.owner,
        ...context.repo,
        path: changelogFilename,
        message: changelogUpdateMessage,
        content: contentEncoded,
        sha: sha
    });
    console.log(response)
    return response?.status || 500;
}

async function updateUpperSection(changelog, version) {
    changelog = changelog.replace(/## \[Unreleased\]/, `## [Unreleased]\n\n## [${version}] - ${date}`);
    return changelog;
}

async function updateBottomSection(changelog, version) {
    const regex = /\[Unreleased\]:(.+\/)v(.+)\.\.\.HEAD/i;
    const matches = changelog.match(regex);
    console.log(matches)
    if (matches) {
        const url = matches[1];
        const previousVersion = matches[2];
        const compareToUnreleased = `[Unreleased]:${url}v${version}...HEAD`;
        const compareToLatestVersion = `[${version}]:${url}v${previousVersion}...v${version}`;
        changelog = changelog.replace(regex, `${compareToUnreleased}\n${compareToLatestVersion}`);
    }
    return changelog;
}

async function createReleaseTag(version){
    const ref = await octokit.rest.git.getRef(
        {...context.repo,
            ref: `tags/${version}`
        });

    if (!ref) {
        await octokit.rest.git.createRef(
            {...context.repo,
                ref: `refs/tags/${version}`, sha: GITHUB_SHA
            });
    }
    else {
        await octokit.rest.git.updateRef(
            {...context.repo,
                ref: `tags/${version}`, sha: GITHUB_SHA
            });
    }
}

run();
