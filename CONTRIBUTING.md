# Contributing  to the Ilias client lib

First off, thank you for taking the time to contribute! :+1: :tada: 

### Table of Contents

* [How to Contribute](#how-to-contribute)
  * [Discuss](#discuss)
  * [Create an Issue](#create-an-issue)
  * [Submit a Pull Request](#submit-a-pull-request)

### How to Contribute

#### Discuss

If you have a question or you suspect an issue, perform a search in the
[Issues](https://github.com/mavogel/ilias-client-lib/issues), using a few different keywords.
When you find related issues and discussions, prior or current, it helps you to learn and
it helps us to make a decision.

#### Create an Issue

When an issue is first created, it may not be assigned and will not have a fix version.
Within a day or two, the issue is assigned to a specific committer and the target
version is set to "Waiting for Triage". The committer will then review the issue, ask for
further information if needed, and based on the findings, the issue is either assigned a fix
version or rejected.

When a fix is ready, the issue is marked "Resolved" and may still be re-opened. Once a fix
is released, the issue is permanently "Closed". If necessary, you will need to create a new,
related ticket with a fresh description.

#### Submit a Pull Request

You can contribute a source code change by submitting a pull request.

1. For all but the most trivial of contributions, please [create an issue](#Create-an-Issue).
The purpose of the ticket is to understand and discuss the underlying issue or feature.

1. Always check out the `master` branch and submit pull requests against it

1. Use short branch names lower-case, dash (-) delimited names, such as `fix-warnings' and refer
to the issue the branch belongs to.

1. Add tests to the new features or fixes. The corresponding [Travis Build](https://travis-ci.org/mavogel/ilias-client-lib)
has to be green.

If accepted, your contribution may be heavily modified as needed prior to merging.
You will likely retain author attribution for your Git commits granted that the bulk of
your changes remain intact. You may also be asked to rework the submission.

If asked to make corrections, simply push the changes against the same branch, and your
pull request will be updated. In other words, you do not need to create a new pull request
when asked to make changes.
