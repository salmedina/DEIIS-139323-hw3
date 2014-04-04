UIMA_CLASSPATH="./target:./target/dependency"
export UIMA_CLASSPATH
deployAsyncService.sh ./src/main/resources/scnlp-139323-deploy.xml -brokerUrl tcp://localhost:61616

