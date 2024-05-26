# Utiliser l'image Jelastic Maven avec OpenJDK 21
FROM jelastic/maven:3.9.5-openjdk-21 AS build

# Définir le répertoire de travail
WORKDIR /opt/app

# Copier le code source de votre application
COPY ./ /opt/app

# Compiler l'application avec Maven
RUN mvn clean install -DskipTests

# Utiliser une image légère avec OpenJDK 21
FROM alpine:3.14

# Copier le fichier JAR depuis l'étape de build précédente
COPY --from=build /opt/app/target/*.jar app.jar

# Définir le port exposé par l'application
ENV PORT 8080
EXPOSE $PORT

# Commande d'exécution de l'application
ENTRYPOINT ["java", "-jar", "-Dserver.port=${PORT}", "app.jar"]
