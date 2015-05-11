#!/bin/bash

source ./lib/git.sh

version=$(get_stable_release)
user=`xmllint --xpath "string(//user)" local/jetbrains-settings.xml`
password=`xmllint --xpath "string(//password)" local/jetbrains-settings.xml`
plugin_id=`xmllint --xpath "string(//idplugin)" local/jetbrains-settings.xml`

source ./utils/upload-to-jetbrains.sh $user $password $plugin_id ../deploy/tmp/zip/itrules-plugin-$version.zip
