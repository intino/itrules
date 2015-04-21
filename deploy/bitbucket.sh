#!/bin/bash

source ./lib/git.sh

version=$(get_last_release)
user=`xmllint --xpath "string(//user)" local/bitbucket-settings.xml`
password=`xmllint --xpath "string(//password)" local/bitbucket-settings.xml`

source ./utils/upload-to-bitbucket.sh $user $password siani/itrules/downloads ../engine/target/itrules-$version.jar
source ./utils/upload-to-bitbucket.sh $user $password siani/itrules/downloads ../reader-itr/target/itrules-itr-reader-$version.jar
source ./utils/upload-to-bitbucket.sh $user $password siani/itrules/downloads ../reader-json/target/itrules-json-reader-$version.jar
source ./utils/upload-to-bitbucket.sh $user $password siani/itrules/downloads ../deploy/tmp/zip/itrules-plugin-$version.zip

rm -f cookies.txt > /dev/null
