rm -rf target
mkdir target
cp -r src/resources target/
javac -d ./target src/java/edu/school21/printer/*/*.java
#pwd
#cat src/manifest.txt
jar cfm target/images-to-chars.jar src/manifest.txt -C target .
java -jar target/images-to-chars.jar . 1