FROM openjdk:17-jdk-alpine
COPY . backend
WORKDIR /backend
CMD [ "/bin/sh" ]
RUN apk update
RUN apk add maven
RUN mvn clean package
RUN java -jar target/TodoList-0.0.1-SNAPSHOT.jar
EXPOSE 8080
