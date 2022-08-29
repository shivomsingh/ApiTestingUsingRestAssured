FROM shivomqa/mavenjava11
COPY src  home/apiframework/src
COPY target/index.html  home/apiframework/index.html
COPY pom.xml	home/apiframework/pom.xml
COPY testng.xml	home/apiframework/testng.xml
WORKDIR home/apiframework
ENTRYPOINT mvn clean test