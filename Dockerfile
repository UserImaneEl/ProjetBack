# Build Stage
FROM maven:3.9.5-openjdk-21 AS build

# Définir le répertoire de travail
WORKDIR /opt/app

# Copier le code source de votre application
COPY ./ /opt/app

# Compiler l'application avec Maven
RUN mvn clean install -DskipTests

# Docker Build Stage
FROM adoptopenjdk/openjdk21:alpine-slim

# Définir le répertoire de travail
WORKDIR /opt/app

# Copier le fichier JAR depuis l'étape de build précédente
COPY --from=build /opt/app/target/*.jar app.jar

# Définir le port exposé par l'application
ENV PORT 8085
EXPOSE $PORT

# Commande d'exécution de l'application
ENTRYPOINT ["java", "-jar", "-Dserver.port=${PORT}", "app.jar"]
