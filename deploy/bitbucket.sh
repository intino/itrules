#!/bin/bash

source ./lib/git.sh

#version=$(get_last_release)
if [ "$1" == "stable" ]; then
  version=$(get_stable_release)
else
  if [ "$1" == "candidate" ]; then  
    VERSION=$(get_candidate_release)
  else
    echo "First parameter should be the version 'stable' or 'candidate'."
    exit 1
  fi
fi

user=`xmllint --xpath "string(//user)" local/bitbucket-settings.xml`
password=`xmllint --xpath "string(//password)" local/bitbucket-settings.xml`

source ./utils/upload-to-bitbucket.sh $user $password siani/itrules/downloads ../engine/target/itrules-$version.jar
source ./utils/upload-to-bitbucket.sh $user $password siani/itrules/downloads ../reader-itr/target/itrules-itr-reader-$version.jar
source ./utils/upload-to-bitbucket.sh $user $password siani/itrules/downloads ../reader-json/target/itrules-json-reader-$version.jar
source ./utils/upload-to-bitbucket.sh $user $password siani/itrules/downloads ../deploy/tmp/zip/itrules-plugin-$version.zip
