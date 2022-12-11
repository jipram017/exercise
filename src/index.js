'use strict';

const core = require('@actions/core');
const github = require('@actions/github');
const fs = require('fs');
const date = new Date().toISOString().slice(0, 10);
const version = process.env.npm_package_version;
const changelogFilename = 'CHANGELOG.md';

async function run() {
    updateChangelog();
    await createReleaseTag();
}

async function createReleaseTag(){
    const {GITHUB_TOKEN, GITHUB_SHA} = process.env;
    const octokit = github.getOctokit(GITHUB_TOKEN);
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

function updateChangelog() {
    let changelog = fs.readFileSync(changelogFilename, { encoding: 'utf8' });
    changelog = updateUpperSection(changelog);
    changelog = updateBottomSectionGithub(changelog);
    fs.writeFileSync(changelogFilename, changelog, { encoding: 'utf8' });
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
