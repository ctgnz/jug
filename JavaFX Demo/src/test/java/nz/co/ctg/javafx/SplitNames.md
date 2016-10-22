# Splitting Names

To help personalise our mailshots we want to have the first name and last name of the customer. 
Unfortunately the customer data that we are supplied only contains full names.

The system therefore attempts to break a supplied full name into its constituents by splitting 
around whitespace.

### [Example](- "basic")

| [split][] [Full Name][full] | [First Name][first] | [Last Name][last] |
| --------------- | --------------- | --------------- |
| John Smith | John | Smith |
| David Blackie | David | Blackie |

[split]: - "#result = split(#fullName)"
[full]: - "#fullName"
[first]: - "?=#result.firstName"
[last]:  - "?=getLastName(#result)"