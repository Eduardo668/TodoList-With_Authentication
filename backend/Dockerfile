FROM openjdk:17-jdk-alpine
COPY . backend
WORKDIR /backend
RUN apk update
RUN apk add maven
RUN mvn clean package -DskipTests
WORKDIR /target
ENTRYPOINT [ "java", "-jar", "TodoList-0.0.1-SNAPSHOT.jar"] 
EXPOSE 8080