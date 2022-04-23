rm -rf target
mkdir target
javac -d ./target src/java/edu/school21/printer/*/*.java
java -cp target edu/school21/printer/app/Program . 0 "/Users/vbackyet/Desktop/jv_pisc/day04/ex00/ImagesToChar/it.bmp"