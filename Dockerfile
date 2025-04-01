FROM maven:3.9-eclipse-temurin-17 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

FROM eclipse-temurin:17-jre
WORKDIR /app
COPY --from=build /app/target/application-web-0.0.1-SNAPSHOT.jar app.jar
VOLUME /var/data
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]