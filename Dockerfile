# Étape 1 : Build avec Maven sur Temurin 21
FROM eclipse-temurin:21-jdk AS builder

# Dépendances de build
WORKDIR /app
COPY . /app

RUN chmod +x ./mvnw

# Compilation (remplace la commande par celle qui convient si tu utilises Gradle)
RUN ./mvnw clean package -DskipTests

# Étape 2 : Image d'exécution avec un JRE Temurin 21
FROM eclipse-temurin:21-jre

# Dossier de travail
WORKDIR /app

# Copier uniquement le JAR généré depuis l'étape de build
COPY --from=builder /app/target/*.jar app.jar

# Commande de démarrage
CMD ["java", "-jar", "app.jar"]