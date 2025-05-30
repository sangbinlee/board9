FROM openjdk:17-jdk
WORKDIR /app

COPY build/libs/board9-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","app.jar"]