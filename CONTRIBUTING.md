# Contributing to InvoiceDesk

Thanks for your interest in improving InvoiceDesk. This guide explains how to propose changes.

## Ground rules

- Be respectful. All participation is governed by the [Code of Conduct](CODE_OF_CONDUCT.md).
- Open an issue before starting large changes so the approach can be agreed first.
- Keep pull requests focused: one fix or feature per PR.

## Development setup

1. Fork the repository and clone your fork.
2. Install a JDK (8 or later).
3. Build and run from the repository root:

   ```bash
   javac -encoding windows-1252 -d bin src/*.java
   java -cp bin main
   ```

   Alternatively, import the folder into Eclipse as an existing project.

## Making changes

1. Create a branch from `main`:

   ```bash
   git checkout -b feat/short-description
   ```

2. Make your changes. Keep the existing package layout (`src/`, default package) unless your PR is specifically about restructuring.
3. Make sure the project compiles without errors and that you have exercised the change in the running app (add lines, close the window, check `output.txt` / `output.csv`).
4. Do not commit build output (`bin/`, `*.class`) or personal test invoices in `output.txt` / `output.csv`.

## Commit messages

Use [Conventional Commits](https://www.conventionalcommits.org/):

```
feat: load product prices from a catalogue file
fix: handle Cancel in the client name dialog
docs: clarify Eclipse encoding setting
```

## Pull requests

- Fill in the pull request template.
- Describe what changed and how you tested it; screenshots are welcome for UI changes.
- Link the related issue (`Closes #123`).

## Reporting bugs and requesting features

Use the issue forms under the **Issues** tab. For security problems, follow [SECURITY.md](SECURITY.md) instead of opening a public issue.
