export UIMA_CLASSPATH=./target:./target/dependency
runRemoteAsyncAE.sh tcp://localhost:61616 hw2-139323-Q -c ./src/main/resources/FileSystemCollectionReader.xml
