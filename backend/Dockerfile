FROM openjdk:17-jdk-alpine
COPY . backend
WORKDIR /backend
RUN apk update
RUN apk add maven
# RUN mvn spring-boot:run
# RUN mvn clean package -DskipTests
# WORKDIR /target
ENTRYPOINT ["mvn", "spring-boot:run"] 
EXPOSE 8080