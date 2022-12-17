FROM openjdk:16-jdk-alpine
ADD /target/automationSocks-0.0.1-SNAPSHOT.jar socks.jar
ENTRYPOINT ["java","-jar","/socks.jar"]


