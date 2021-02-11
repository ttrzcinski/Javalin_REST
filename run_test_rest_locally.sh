#!/bin/bash
printf "\nWill now test the response of locally running REST Javalin server.\n"
printf "  Have: "
curl -X GET http://localhost:7000
printf "\n  Want: Hell-On-World"
printf "\nDONE\n"
