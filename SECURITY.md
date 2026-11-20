# Security Policy

## Supported versions

InvoiceDesk is maintained as a single line of development. Security fixes are applied to the `main` branch only.

| Version | Supported |
| --- | --- |
| `main` | Yes |
| Older commits | No |

## Reporting a vulnerability

Please **do not** open a public issue for security problems.

Report vulnerabilities privately through GitHub:

1. Go to the repository's **Security** tab.
2. Choose **Report a vulnerability** to open a private advisory.
3. Include a description, steps to reproduce, affected files, and the potential impact.

You can expect an acknowledgement within a few days. Once the issue is confirmed, a fix will be prepared and you will be credited in the advisory unless you prefer to stay anonymous.

## Scope

InvoiceDesk is a local desktop application that reads and writes plain-text files in its working directory. Relevant reports include, for example, unsafe file handling or anything that could corrupt or expose saved invoice data.
