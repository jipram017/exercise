# Changelog
All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](http://keepachangelog.com/en/1.0.0/)
and this project adheres to [Semantic Versioning](http://semver.org/spec/v2.0.0.html).

## [Unreleased]
- Upgrade some auth filter

## [2.0.3] - 2022-10-26
### Updated
- upgrade dependencies to reduce security risk

### Changed
- replaced `process.exit(0)` with simple return, otherwise package can't be used as dependency (since it exists the whole process, while control should stay at callee)

