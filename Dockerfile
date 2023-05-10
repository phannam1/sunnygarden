FROM maven:3.6.1-jdk-11-slim AS build
COPY . .
RUN mvn -f /pom.xml clean package

#
# Package stage
#
FROM openjdk:11-jre-slim
COPY --from=build /target/Sunny-garden-0.0.1-SNAPSHOT.jar /sunnygarden.jar
EXPOSE 8081
ENTRYPOINT ["java","-jar","/sunnygarden.jar"]
