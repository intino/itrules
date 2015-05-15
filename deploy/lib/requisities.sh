#!/bin/bash

function info_parameters {
  echo "Use: maven.sh [stable | candidate] [install | deploy] <module>"
}

function check_template {
  if [ ! -f "templates/$1.dist.pom" ]; then
    echo "Missing template for $1"
    exit 1
  fi
}

if [ "$1" == "stable" ]; then
  VERSION=$(get_stable_release)
else
  if [ "$1" == "candidate" ]; then  
    VERSION=$(get_candidate_release)
  else
    echo "First parameter should be the version 'stable' or 'candidate'."
    echo $(info_parameters)
    exit 1
  fi
fi

if [ "$2" != "deploy" -a "$2" != "install" ]; then
  echo "The second parameter should be how to deploy 'install' or 'deploy'."
  echo $(info_parameters)
  exit 1
fi

