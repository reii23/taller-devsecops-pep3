FROM openjdk:20
ARG JAR_FILE=./target/*.jar
COPY ${JAR_FILE} PrestaBanco-backend.jar
EXPOSE 8090
ENTRYPOINT ["java", "-jar","./PrestaBanco-backend.jar"]