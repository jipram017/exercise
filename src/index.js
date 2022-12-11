'use strict';

const core = require('@actions/core');
const github = require('@actions/github');
const fs = require('fs');
const date = new Date().toISOString().slice(0, 10);
const version = process.env.npm_package_version;
const { Base64 } = require("js-base64");
const { context = {} } = github;
const {GITHUB_TOKEN, GITHUB_SHA} = process.env;
const octokit = github.getOctokit(GITHUB_TOKEN);
const changelogFilename = 'CHANGELOG.md';
const changelogAddMessage = 'Added CHANGELOG.md file';
const changelogUpdateMessage = 'Updated CHANGELOG.md file';

async function run() {
    const init_changelog = core.getInput("init_changelog");
    if (init_changelog) {await newChangelog();}
    else {await updateChangelog();}
    await createReleaseTag();
}

async function createReleaseTag(){
    const { context = {} } = github;
    const TAG_NAME = core.getInput("tag_name");

    let ref;
    try {
        ref = await octokit.rest.git.getRef({...context.repo, ref: `tags/${TAG_NAME}`});
    } catch (e) {
        if (e.status === 404) {}
        else { throw e;}
    }
    if (!ref) {
        await octokit.rest.git.createRef({...context.repo, ref: `refs/tags/${TAG_NAME}`, sha: GITHUB_SHA});
    }
    else {
        await octokit.rest.git.updateRef({...context.repo, ref: `tags/${TAG_NAME}`, sha: GITHUB_SHA});
    }
}

async function pushFile(changelog) {
    const contentEncoded = Base64.encode(changelog);
    try{
        const { data } = await octokit.rest.repos.createOrUpdateFileContents({
        owner: context.owner,
        repo: context.repo,
        path: changelogFilename,
        message: changelogAddMessage,
        content: contentEncoded,
        committer: {
            name: context.name,
            email: context.email,
        },
        author: {
            name: context.name,
            email: context.email,
        },
    });
    console.log(data);
    } catch (err) {
        console.error(err);
    }
}

async function newChangelog() {
    let changelog = fs.readFileSync(require.resolve("../src/init.md"), {encoding: 'utf8'});
    const {version, repository} = JSON.parse(fs.readFileSync(require.resolve("../package.json"), {encoding: 'utf8'}));
    changelog = changelog.replace('[Unreleased]:', `[Unreleased]: ${getRepositoryUrl(repository, version)}`);
    await pushFile(changelog)
    //fs.writeFileSync('../CHANGELOG.md', changelog, {encoding: 'utf8', flag: 'wx'});
}

function getRepositoryUrl(repository, version) {
    const getGithubUrl = (name) => `https://github.com/${name}/compare/v${version}...HEAD`;
    let type;
    let name;
    [, type, name] = repository.url.match(/^(?:[\w+]+?:\/\/)?(.+)(?:\/|:)([\w-]+\/[\w-]+)(?:\.git)?$/);
    return getGithubUrl(name);
}

async function updateChangelog() {
    let changelog = fs.readFileSync(require.resolve("../CHANGELOG.md"), { encoding: 'utf8' });
    console.log(changelog)
    changelog = updateUpperSection(changelog);
    console.log(changelog)
    changelog = updateBottomSectionGithub(changelog);
    console.log(changelog)
    //fs.writeFileSync(require.resolve("../CHANGELOG.md"), changelog, { encoding: 'utf8' });
    const commits = await octokit.rest.repos.listCommits({owner: context.owner, repo: context.repo});
    const commitSHA = commits.data[0].sha;
    await pushFile(changelog)
}

function updateUpperSection(changelog) {
    return changelog.replace(/## \[Unreleased\]/, `## [Unreleased]\n\n## [${version}] - ${date}`);
}

function updateBottomSectionGithub(changelog) {
    const regex = /\[Unreleased\]:(.+\/)v(.+)\.\.\.HEAD/i;
    const matches = changelog.match(regex);
    if (matches) {
        const url = matches[1];
        const previousVersion = matches[2];
        const compareToUnreleased = `[Unreleased]:${url}v${version}...HEAD`;
        const compareToLatestVersion = `[${version}]:${url}v${previousVersion}...v${version}`;
        changelog = changelog.replace(regex, `${compareToUnreleased}\n${compareToLatestVersion}`);
    }
    return changelog;
}

run();
