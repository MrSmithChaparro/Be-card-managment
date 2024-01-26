FROM openjdk:11-jre-slim

WORKDIR /app
COPY target/card-managment-0.0.1-SNAPSHOT.jar

EXPOSE 8080

CMD ["java", "-jar", "app.jar"]