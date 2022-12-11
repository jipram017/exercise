const core = require('@actions/core');
const github = require('@actions/github');

async function run() {
    const TAG_NAME = core.getInput("tag_name");
    const {GITHUB_TOKEN, GITHUB_SHA} = process.env;
    const octokit = github.getOctokit(GITHUB_TOKEN);
    const { context = {} } = github;

    if (!(GITHUB_SHA || GITHUB_TOKEN || TAG_NAME)) {
        core.setFailed("Missing GITHUB_SHA/GITHUB_TOKEN/TAG_NAME");
        return;
    }

    let ref;
    try {
        ref = await octokit.rest.git.getRef(
            {...context.repo, ref: `tags/${TAG_NAME}`}
        );
    } catch (e) {
        if (e.status === 404) {}
        else { throw e;}
    }
    if (!ref) {
        await octokit.rest.git.createRef(
            {...context.repo, ref: `refs/tags/${TAG_NAME}`, sha: GITHUB_SHA}
        );
    } else {
        await octokit.rest.git.updateRef(
            {...context.repo, ref: `tags/${TAG_NAME}`, sha: GITHUB_SHA}
        );
    }
}

run();
