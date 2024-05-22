FROM maven:3.9.6-amazoncorretto-17 AS build

COPY src /app/src
COPY pom.xml /app

WORKDIR /app
RUN mvn clean install

FROM openjdk:17-alpine

ENV JWT_SECRET=agencia_conecta_api_240218

COPY --from=build /app/target/agencia-conecta-api-1.0.0-SNAPSHOT.jar /app/app.jar

WORKDIR /app

EXPOSE 8080

CMD ["java", "-jar", "app.jar"]