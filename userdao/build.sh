#!/bin/bash
PROJECT_ROOT=/daum/jeju2021/workspace/java-framework-class-workspace/userdao
SRC_PATH=$PROJECT_ROOT/src
DEST_PATH=$PROJECT_ROOT/out/build
LIB_PATH=$PROJECT_ROOT/lib
libs=''
for lib in $(ls $LIB_PATH)
do
 	lib=$LIB_PATH/$lib
	libs="$libs$lib:"
done

echo 'clean : start'
rm -rf $DEST_PATH
mkdir -p $DEST_PATH
echo 'clean : end'
echo 'compile : start'
javac -cp $libs -d $DEST_PATH $(find $SRC_PATH -name "*.java")
echo 'compile : end'
echo 'buid : start'
jar cvf $DEST_PATH/userdao.jar $(find $DEST_PATH -name "*.class")
echo 'buid : end'

