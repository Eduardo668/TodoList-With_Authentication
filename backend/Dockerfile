FROM openjdk:17-jdk-alpine
COPY . backend
ENTRYPOINT cd backend
RUN ./mvnw clean package
RUN java -jar target/TodoList-0.0.1-SNAPSHOT.jar
EXPOSE 8080
