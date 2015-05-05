#!/bin/bash

source ./lib/git.sh
source ./lib/requisities.sh
source ./lib/maven.sh
RESULT=0

if [ -z $3 ]; then
  generate_artifact $2 engine
  if [ $RESULT -eq 0 ]; then  
    generate_artifact $2 reader-itr
    if [ $RESULT -eq 0 ]; then      
      generate_artifact $2 reader-json
    fi
  fi
else
  generate_artifact $2 $3
fi

exit $RESULT
