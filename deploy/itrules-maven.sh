#!/bin/bash

FILE_CURRENT=`readlink -e $0`
DIR_CURRENT=`dirname $FILE_CURRENT`
DIR_PARENT=`dirname $DIR_CURRENT`

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
  version=$(get_last_release)
  cp -f $1.dist.pom dist.pom 
  sed -i "s/#version#/$version/g" dist.pom

  echo "<project>" > /tmp/pom.tmp
  sed -n "/<version>/,/<\version>/p" ../$1/pom.xml >> /tmp/pom.tmp

  module_dependencies=`xmllint --xpath "//orderEntry/@module-name" ../$1/$1.iml`
  modules_array=(`echo $module_dependencies | sed -e 's/"//g' | sed -e 's/ /\n/g'`)
  module_dependencies=""
  for module in $modules_array; do 
    name_array=(`echo $module | sed -e 's/=/\n/g'`)
    name=${name_array[1]}

    filename=`cd ../$name/target; ls *-$version.jar | sed -e 's/\n//g'`
    filename_array=(`echo $filename | sed -e 's/-/\n/g'`)
    artifactId=${filename_array[0]}

    echo "<project>" > /tmp/pom.dist.tmp
    sed -n "/<modelVersion>/,/<\modelVersion>/p" $name.dist.pom >> /tmp/pom.dist.tmp
    groupId=`xmllint --xpath "string(//groupId)" /tmp/pom.dist.tmp`
    rm -f /tmp/pom.dist.tmp
           
    module_dependencies="$module_dependencies\n        <dependency><groupId>org.siani.itrules<\/groupId><artifactId>$artifactId<\/artifactId><version>$version<\/version><\/dependency>"
  done
  perl -pi -e "s/<dependencies>/<dependencies>$module_dependencies/g" /tmp/pom.tmp    
  
  dependencies=`xmllint --xpath "//dependencies" /tmp/pom.tmp` 
  rm /tmp/pom.tmp
  
  dependencies_escaped=$(sed 's/\//\\\//g' <<< "$dependencies") 
  perl -pi -e "s/#dependencies#/$dependencies_escaped/g" dist.pom
  
  mv dist.pom ../$1/dist.pom
  cd ../$1
  mvn clean deploy -f dist.pom -s ../deploy/settings.xml
  rm dist.pom
  cd ../deploy
}

generate_artifact engine
generate_artifact reader-itr
generate_artifact reader-json
