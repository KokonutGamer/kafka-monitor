# Build the application using Maven
FROM maven:3-amazoncorretto-21-alpine AS build

WORKDIR /app
COPY . .

# Build the project using Maven Wrapper
RUN ./mvnw clean package -DskipTests

# Run the JAR in a new layer with a smaller 
FROM amazoncorretto:21-alpine-jdk

EXPOSE 8080

ARG JAR_FILE=/app/target/*.jar

COPY --from=build ${JAR_FILE} app.jar

ENTRYPOINT [ "java", "-jar", "/app.jar" ]
