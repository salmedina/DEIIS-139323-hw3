SET UIMA_CLASSPATH=..\..\..\target\;..\..\..\target\dependency\
echo %UIMA_CLASSPATH%
deployAsyncService .\descriptors\hw2-139323-aae-deploy.xml -brokerUrl tcp://localhost:61616