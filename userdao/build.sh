#!/bin/bash
SRC_PATH=/daum/jeju2017/workspace/java-framework-class-workspace/userdao/src
DEST_PATH=/daum/jeju2017/workspace/java-framework-class-workspace/userdao/out/build/
LIB_PATH=/daum/jeju2017/workspace/java-framework-class-workspace/userdao/lib
libs=''
for lib in $(ls $LIB_PATH)
do
 	lib=$LIB_PATH/$lib
	libs="$libs$lib:"
done

echo $libs

javac -cp $libs -d $DEST_PATH $(find $SRC_PATH -name "*.java")
jar cvf $DEST_PATH/userdao.jar $(find $DEST_PATH -name "*.class")
