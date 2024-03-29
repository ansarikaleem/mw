# Docker Build Stage
FROM openjdk:17-oracle AS build


# Copy folder in docker
WORKDIR /opt/app

COPY ./ /opt/app
RUN mvn clean install -DskipTests


# Run spring boot in Docker
FROM openjdk:17-oracle

COPY --from=build /opt/app/target/*.jar app.jar

ENV PORT 8081
EXPOSE $PORT

ENTRYPOINT ["java","-jar","-Xmx1024M","-Dserver.port=${PORT}","app.jar"]