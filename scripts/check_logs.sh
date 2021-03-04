#!/usr/bin/env bash


# Verify if error exist:
cat /deployments/springboot.log | grep refused
# If the cat return an error the result is 0
ERROR=$?
if [ $ERROR -eq 0 ];
then
    echo "there is an error"
    exit 1
else
    echo "there is no error"
    exit 0
fi
