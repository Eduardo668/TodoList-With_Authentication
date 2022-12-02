FROM openjdk:17-jdk-alpine
COPY . backend
CMD [ "/bin/sh" ]
RUN apk update
RUN cd backend
RUN apk add maven
RUN mvn clean package
RUN java -jar target/TodoList-0.0.1-SNAPSHOT.jar
EXPOSE 8080
