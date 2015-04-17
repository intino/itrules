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

function get_main_dependencies {
  echo "<project>" > /tmp/pom.tmp
  sed -n "/<version>/,/<\version>/p" ../pom.xml >> /tmp/pom.tmp
  dependencies=`xmllint --xpath "//dependencies" /tmp/pom.tmp | sed -e 's/<dependencies>//g' | sed -e 's/<\/dependencies>//g' ` 
  rm /tmp/pom.tmp
  echo $dependencies
}

function get_module_list {
  echo "<project>" > /tmp/pom.tmp
  sed -n "/<version>/,/<\version>/p" ../pom.xml >> /tmp/pom.tmp
  modules=`xmllint --xpath "//modules/module" /tmp/pom.tmp | sed -e 's/<module>//g' | sed -e 's/<\/module>/\n/g'`
  rm /tmp/pom.tmp
  echo $modules
}

function get_local_groupId {
  echo "<project>" > /tmp/pom.dist.tmp
  sed -n "/<modelVersion>/,/<\modelVersion>/p" ../$1/pom.xml >> /tmp/pom.dist.tmp
  groupId=`xmllint --xpath "string(//groupId)" /tmp/pom.dist.tmp`
  rm -f /tmp/pom.dist.tmp
  echo $groupId
}

function get_remote_groupId {
  echo "<project>" > /tmp/pom.dist.tmp
  sed -n "/<modelVersion>/,/<\modelVersion>/p" $1.dist.pom >> /tmp/pom.dist.tmp
  groupId=`xmllint --xpath "string(//groupId)" /tmp/pom.dist.tmp`
  rm -f /tmp/pom.dist.tmp
  echo $groupId
}

function get_remote_artifactId {
  echo "<project>" > /tmp/pom.dist.tmp
  sed -n "/<modelVersion>/,/<\modelVersion>/p" $1.dist.pom >> /tmp/pom.dist.tmp
  artifactId=`xmllint --xpath "string(//artifactId)" /tmp/pom.dist.tmp`
  rm -f /tmp/pom.dist.tmp
  echo $artifactId
}

function replace_module_dependencies {
  modules=$(get_module_list)
  dependencies=$(get_module_dependencies $1)
  version=$(get_last_release)

  for module in $modules; do 
    groupId=$(get_local_groupId $module)
    local_dependency="<dependency> <groupId>$groupId<\/groupId> <artifactId>$module<\/artifactId> <version>1.0<\/version> <\/dependency>"
   
    groupId=$(get_remote_groupId $module)
    artifactId=$(get_remote_artifactId $module)
        
    remote_dependency="<dependency><groupId>$groupId<\/groupId><artifactId>$artifactId<\/artifactId><version>$version<\/version><\/dependency>"
    dependencies=`echo $dependencies | sed -e "s/$local_dependency/$remote_dependency/g"`
  done

  echo $dependencies
}

function get_module_dependencies {
  echo "<project>" > /tmp/pom.tmp
  sed -n "/<modelVersion>/,/<\modelVersion>/p" ../$1/pom.xml >> /tmp/pom.tmp
  dependencies=`xmllint --xpath "//dependencies" /tmp/pom.tmp | sed -e 's/<dependencies>//g' | sed -e 's/<\/dependencies>/\n/g'` 
  rm /tmp/pom.tmp
  echo $dependencies
}

function generate_artifact {
  version=$(get_last_release)
  cp -f $1.dist.pom dist.pom 
  sed -i "s/#version#/$version/g" dist.pom
 
  dependencies=$(replace_module_dependencies $1)
  dependencies_escaped=$(sed 's/\//\\\//g' <<< "<dependencies>$dependencies$(get_main_dependencies)</dependencies>") 
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
