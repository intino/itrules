#!/bin/bash

IDEAFILE=ideaIC-14.1.1.tar.gz
IDEAVERSION=idea-IC-141.178.9

source ./lib/git.sh
version=$(get_last_release)

FILEPLUGIN="itrules-plugin-$version.jar"
FILEENGINE="itrules-$version.jar"
FILEENGINEITR="itrules-itr-reader-$version.jar"
FILEZIP="itrules-plugin-$version.zip"

# Plugin resources
rm -r tmp > /dev/null
mkdir -p tmp/resources/META-INF
cp ../plugin/META-INF/*.* tmp/resources/META-INF -r
cp ../plugin/res/* tmp/resources -r
sed -i "s/#version#/$version/g" tmp/resources/META-INF/plugin.xml
changelog_escaped=$(sed 's/\//\\\//g' <<< `markdown ../CHANGELOG.md`)
sed -i "s/#change-notes#/$changelog_escaped/g" tmp/resources/META-INF/plugin.xml

# Intellij libraries 
if [ ! -f local/$IDEAFILE ]; then
  mkdir local
  cd local
  wget http://download.jetbrains.com/idea/$IDEAFILE
  cd ..
fi

mkdir -p tmp/lib
cd tmp/lib
cp ../../local/$IDEAFILE .
tar --extract --file=$IDEAFILE $IDEAVERSION/lib
cd $IDEAVERSION/lib
mv * ../..
cd ../..

# Maven libraries
tar --extract --file=$IDEAFILE $IDEAVERSION/plugins/maven/lib
cd $IDEAVERSION/plugins/maven/lib
mv * ../../../..
cd ../../../..

rm -fr $IDEAVERSION
rm -f $IDEAFILE
cd ../..

# Build
cd ../plugin
cp ../deploy/plugin.dist.pom plugin.pom
sed -i "s/#version#/$version/g" plugin.pom
mvn clean install -f plugin.pom
rm -f plugin.pom

# Form classes
cd ../deploy
mkdir -p tmp/forms_rt
cd tmp/forms_rt
cp ../lib/forms_rt.jar .
unzip forms_rt.jar
rm -f forms_rt.jar
mkdir -p ../forms-classes/com/intellij/uiDesigner/core
cp -r com/intellij/uiDesigner/core/* ../forms-classes/com/intellij/uiDesigner/core
cd ..
rm -fr forms_rt
cd forms-classes
zip -r ../../../plugin/target/$FILEPLUGIN com
cd ..

#Generate Intellij zip
mkdir -p zip/itrules-plugin/lib
cd zip/itrules-plugin/lib
cp ../../../../../plugin/target/$FILEPLUGIN .
cp ../../../../../engine/target/$FILEENGINE .
cp ../../../../../reader-itr/target/$FILEENGINEITR .
cp $HOME/.m2/repository/org/antlr/antlr4/4.5/*.jar .
cp $HOME/.m2/repository/org/antlr/antlr4-runtime/4.5/*.jar .
cp $HOME/.m2/repository/org/abego/treelayout/org.abego.treelayout.core/1.0.1/*.jar .
cp $HOME/.m2/repository/org/antlr/antlr-runtime/3.5.2/*.jar .
cp $HOME/.m2/repository/org/antlr/ST4/4.0.8/*.jar .
cd ../..
zip $FILEZIP * -r