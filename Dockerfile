# Utiliser une image Maven avec OpenJDK 17 pour la compilation
FROM maven:3.6.3-openjdk-17 AS build

# Définir le répertoire de travail
WORKDIR /opt/app

# Copier le code source de votre application
COPY ./ /opt/app

# Compiler l'application avec Maven
RUN mvn clean install -DskipTests

# Utiliser l'image Alpine avec OpenJDK 17 pour l'exécution
FROM openjdk:17-alpine

# Copier le fichier JAR depuis l'étape de build précédente
COPY --from=build /opt/app/target/*.jar app.jar

# Définir le port exposé par l'application
ENV PORT 8083
EXPOSE $PORT

# Commande d'exécution de l'application
ENTRYPOINT ["java", "-jar", "-Dserver.port=${PORT}", "app.jar"]
