FROM openjdk:23-ea-2-jdk-slim

WORKDIR /app

COPY .mvn/ .mvn
COPY mvnw pom.xml ./
RUN ./mvnw dependency:go-offline

COPY src ./src

CMD ["./mvnw", "spring-boot:run"]

EXPOSE 8080

#ENTRYPOINT ["java", "-jar", "target/estudo-0.0.1-SNAPSHOT.jar"]
