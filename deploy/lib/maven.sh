#!/bin/bash

function get_main_dependencies {
  echo "<project>" > /tmp/pom.tmp
  if [ -f ../pom.xml ]; then
    sed -n "/<version>/,/<\version>/p" ../pom.xml >> /tmp/pom.tmp
    dependencies=`xmllint --xpath "//dependencies" /tmp/pom.tmp | sed -e 's/<dependencies>//g' | sed -e 's/<\/dependencies>//g' ` 
    rm /tmp/pom.tmp
  else
    if [ -f "../_develop/pom.xml" ]; then
      sed -n "/<version>/,/<\version>/p" "../_develop/pom.xml" >> /tmp/pom.tmp
      dependencies=`xmllint --xpath "//dependencies" /tmp/pom.tmp | sed -e 's/<dependencies>//g' | sed -e 's/<\/dependencies>//g' ` 
      rm /tmp/pom.tmp
    fi
  fi
  echo $dependencies
}

function get_module_list {
  modules=""
  if [ -f ../pom.xml ]; then
    echo "<project>" > /tmp/pom.tmp
    sed -n "/<version>/,/<\version>/p" ../pom.xml >> /tmp/pom.tmp
    modules=`xmllint --xpath "//modules/module" /tmp/pom.tmp | sed -e 's/<module>//g' | sed -e 's/ /#/g' | sed -e 's/<\/module>/\n/g'`
    rm /tmp/pom.tmp
  else
    if [ -f "../_develop/pom.xml" ]; then
      echo "<project>" > /tmp/pom.tmp
      sed -n "/<version>/,/<\version>/p" "../_develop/pom.xml" >> /tmp/pom.tmp
      modules=`xmllint --xpath "//modules/module" /tmp/pom.tmp | sed -e 's/<module>//g' | sed -e 's/ /#/g' | sed -e 's/<\/module>/\n/g'`
      rm /tmp/pom.tmp
    fi
  fi
  echo $modules
}

function get_local_groupId {
  groupId=""
  if [ -f "../$1/pom.xml" ]; then  
    echo "<project>" > /tmp/pom.dist.tmp
    sed -n "/<modelVersion>/,/<\modelVersion>/p" "../$1/pom.xml" >> /tmp/pom.dist.tmp
    groupId=`xmllint --xpath "string(//groupId)" /tmp/pom.dist.tmp`
    rm -f /tmp/pom.dist.tmp
  fi
  echo $groupId
}

function get_local_artifactId {
  artifactId=""
  if [ -f "../$1/pom.xml" ]; then  
    echo "<project>" > /tmp/pom.dist.tmp
    sed -n "/<modelVersion>/,/<\modelVersion>/p" "../$1/pom.xml" >> /tmp/pom.dist.tmp
    artifactId=`xmllint --xpath "string(//artifactId)" /tmp/pom.dist.tmp`
    rm -f /tmp/pom.dist.tmp
  fi
  echo $artifactId
}

function get_remote_groupId {
  groupId=$(get_local_groupId $1)
  if [ -f "$1.dist.pom" ]; then
    echo "<project>" > /tmp/pom.dist.tmp
    sed -n "/<modelVersion>/,/<\modelVersion>/p" "$1.dist.pom" >> /tmp/pom.dist.tmp
    groupId=`xmllint --xpath "string(//groupId)" /tmp/pom.dist.tmp`
    rm -f /tmp/pom.dist.tmp
  fi
  echo $groupId
}

function get_remote_artifactId {
  artifactId=$(get_local_artifactId "$1")
  if [ -f "$1.dist.pom" ]; then 
    echo "<project>" > /tmp/pom.dist.tmp
    sed -n "/<modelVersion>/,/<\modelVersion>/p" "$1.dist.pom" >> /tmp/pom.dist.tmp
    artifactId=`xmllint --xpath "string(//artifactId)" /tmp/pom.dist.tmp`
    rm -f /tmp/pom.dist.tmp
  fi
  echo $artifactId
}

function replace_module_dependencies {
  modules=$(get_module_list "$1")
  dependencies=$(get_module_dependencies "$1")

  for module in $modules; do 
    module=`echo $module | sed -e 's/#/ /g'`
  
    groupId=$(get_local_groupId "$module")
    local_dependency="<dependency> <groupId>$groupId<\/groupId> <artifactId>$module<\/artifactId> <version>1.0<\/version> <\/dependency>"

    groupId=$(get_remote_groupId "$module")
    artifactId=$(get_remote_artifactId "$module")

    remote_dependency="<dependency><groupId>$groupId<\/groupId><artifactId>$artifactId<\/artifactId><version>$VERSION<\/version><\/dependency>"
    dependencies=`echo $dependencies | sed -e "s/$local_dependency/$remote_dependency/g"`
  done

  echo $dependencies
}

function get_module_dependencies {
  echo "<project>" > /tmp/pom.tmp
  if [ -f "../$1/pom.xml" ]; then    
    sed -n "/<modelVersion>/,/<\modelVersion>/p" "../$1/pom.xml" >> /tmp/pom.tmp
    dependencies=`xmllint --xpath "//dependencies" /tmp/pom.tmp | sed -e 's/<dependencies>//g' | sed -e 's/<\/dependencies>/\n/g'` 
    rm /tmp/pom.tmp
  fi
  echo $dependencies
}

function generate_artifact {
  check_template "$2"
  cp -f "templates/$2.dist.pom" dist.pom 
  sed -i "s/#version#/$VERSION/g" dist.pom
 
  dependencies=$(replace_module_dependencies "$2")

  dependencies_escaped=$(sed 's/\//\\\//g' <<< "<dependencies>$dependencies$(get_main_dependencies)</dependencies>") 
  perl -pi -e "s/#dependencies#/$dependencies_escaped/g" dist.pom

  mv dist.pom "../$2/dist.pom"
  cd "../$2"
  mvn clean $1 -f dist.pom -s ../deploy/local/maven-settings.xml
  RESULT=$?
  rm dist.pom
  cd ../deploy
}
