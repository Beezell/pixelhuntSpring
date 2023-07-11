FROM openjdk:11.0-jre-slim

EXPOSE 9999

ADD target/*.jar

ENTRYPOINT ["java","-jar","/app.jar"]
