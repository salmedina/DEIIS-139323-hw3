UIMA_CLASSPATH="./target:./target/dependency"
export UIMA_CLASSPATH
deployAsyncService.sh ./src/main/resources/hw2-139323-aae-deploy.xml -brokerUrl tcp://localhost:61616
