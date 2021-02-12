#!/bin/bash
printf "\nWill now run JUnit tests in Javalin REST API.\n"
mvn test --batch-mode --fail-at-end
printf "\nDONE.\n"
