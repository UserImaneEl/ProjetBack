# Build Stage
FROM maven:3.9.6 AS build

WORKDIR /opt/app

COPY ./ /opt/app
RUN mvn clean install -DskipTests

# Docker Build Stage
FROM openjdk:21-alpine  # Remplacer par votre alternative

COPY --from=build /opt/app/target/*.jar app.jar

ENV PORT 8083
EXPOSE $PORT

ENTRYPOINT ["java","-jar","-Dserver.port=${PORT}","app.jar"]
