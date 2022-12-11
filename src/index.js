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
    const pull_request_title = context.payload.pull_request.title
    const regex = /(\#\s*Release)\s*v(.+)/
    const matches =  pull_request_title.match(regex);
    let latest_version
    if(matches) latest_version = matches[2];

    try {
        const response = await octokit.rest.repos.getContent(  {
            ...context.owner,
            ...context.repo,
            path: changelogFilename
        });
        console.log(response)
        const latest_content = response?.data?.content
        const sha = response?.data?.sha;
        await updateChangelog(latest_content, latest_version, sha);
    } catch(err) {
        console.error(err)
        await createChangelog()
    }
    await createReleaseTag(latest_version);
}

async function createChangelog() {
    let changelog = fs.readFileSync(
        require.resolve("../src/init.md"),
        {encoding: 'utf8'}
    );

    const githubUrl = `https://github.com/${context.payload.repository.owner.login}/${context.payload.repository.name}/compare/v1.0.0...HEAD`;
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
    let changelog = Base64.decode(content);
    changelog = updateUpperSection(changelog, version);
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

function updateUpperSection(changelog, version) {
    changelog = changelog.replace(/## \[Unreleased\]/, `## [Unreleased]\n\n## [${version}] - ${date}`);
    return changelog;
}

function updateBottomSection(changelog, version) {
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
    let ref
    try{
        ref = await octokit.rest.git.getRef(
            {...context.repo,
                ref: `tags/${version}`
            });

    } catch(err){
        console.error(err)
        await octokit.rest.git.createRef(
            {...context.repo,
                ref: `refs/tags/${version}`, sha: GITHUB_SHA
            });
    }

    if(ref) {
        await octokit.rest.git.updateRef(
            {...context.repo,
                ref: `tags/${version}`, sha: GITHUB_SHA
            });
    }
}

run();
