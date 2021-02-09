#!/bin/bash
printf "\nWill run the docker.\n"
docker run -d -p 7000:7000 localhost:5000/javalin:1.0.0-SNAPSHOT
printf "\nDONE\n"

