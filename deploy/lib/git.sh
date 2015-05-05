#!/bin/bash

IS_LAST_RELEASE_CANDIDATE=0

function get_release {
  TAGS=`git for-each-ref --sort=taggerdate --format '%(tag)' refs/tags`
  STABLE=""
  CANDIDATE=""
  LAST=""
  for tag in $TAGS; do 
    version_array=(`echo $tag | sed -e 's/\./\n/g'`)
  
    version=${version_array[0]}
    release=${version_array[1]}
    path=${version_array[2]}
    if [ "$path" == "" ]; then path="0"; fi

    IS_LAST_RELEASE_CANDIDATE=0
    if [ $((release%2)) -eq 0 ]; then
      STABLE="$version.$release.$path"
    else
      CANDIDATE="$version.$release.$path"
      IS_LAST_RELEASE_CANDIDATE=1
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
  echo "$CANDIDATE-SNAPSHOT";
}

function get_last_release {
  get_release;
  if [ $IS_LAST_RELEASE_CANDIDATE -eq 0 ]; then
    echo "$LAST"
  else
    echo "$LAST-SNAPSHOT"
  fi
}
