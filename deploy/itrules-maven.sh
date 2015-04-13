#!/bin/bash

function get_release {
  TAGS=`git tag`
  STABLE=""
  CANDIDATE=""
  LAST=""
  for tag in $TAGS; do 
    version_array=(`echo $tag | sed -e 's/\./\n/g'`)
  
    version=${version_array[0]}
    release=${version_array[1]}
    path=${version_array[2]}
    if [ "$path" == "" ]; then path="0"; fi

    if [ $((release%2)) -eq 0 ]; then
      STABLE="$version.$release.$path"
    else
      CANDIDATE="$version.$release.$path"
    fi
    LAST="$version.$release.$path"
  done
}

function get_stable_release {
  get_release;
  echo "$STABLE";
}

function get_candidate_release {
  get_release;
  echo "$CANDIDATE";
}

function get_last_release {
  get_release;
  echo "$LAST";
}

function generate_artifact {
  cp -f $1.dist.pom dist.pom 
  echo "<project>" > /tmp/pom.tmp
  sed -n "/<version>/,/<\version>/p" ../$1/pom.xml >> /tmp/pom.tmp
  dependencies=`xmllint --xpath "//dependencies" /tmp/pom.tmp` 
  dependencies_escaped=$(sed 's/\//\\\//g' <<< "$dependencies") 
  perl -pi -e "s/#dependencies#/$dependencies_escaped/g" dist.pom
#  perl -pi -e "s/#dependencies#//g" dist.pom
  sed -i "s/#version#/$(get_last_release)/g" dist.pom
  mv dist.pom ../$1/dist.pom
  
 cd ../$1
 mvn clean install -f dist.pom #-s settings.xml
# rm dist.pom
}

generate_artifact engine
#generate_artifact reader-itr