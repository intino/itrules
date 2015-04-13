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

cp -f template.pom dist.pom
sed -i "s/#version#/$(get_last_release)/g" dist.pom
