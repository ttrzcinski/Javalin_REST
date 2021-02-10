#!/bin/bash
printf "\nWill now run mvn to build the API instance.\n"
mvn clean install package
printf "\nDONE.\n"

