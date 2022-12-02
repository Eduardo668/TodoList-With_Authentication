FROM openjdk:17-jdk-alpine
COPY . backend
RUN cd backend
RUN sudo apt install maven -y
RUN mvn clean package
RUN java -jar target/TodoList-0.0.1-SNAPSHOT.jar
EXPOSE 8080
