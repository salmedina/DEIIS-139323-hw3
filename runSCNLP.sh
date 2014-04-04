UIMA_CLASSPATH="./target:./target/dependency"
export UIMA_CLASSPATH
runRemoteAsyncAE.sh tcp://localhost:61616 scnlp-139323-Q -c ./src/main/resources/FileSystemCollectionReader.xml -o ./output
