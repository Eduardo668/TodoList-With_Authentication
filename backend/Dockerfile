FROM openjdk:17-jdk-alpine
COPY target/TodoList-0.0.1-SNAPSHOT.jar TodoListApi.jar
ENTRYPOINT [ "java", "-jar", "/TodoListApi.jar" ]
EXPOSE 8080
