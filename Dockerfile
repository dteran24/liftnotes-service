FROM eclipse-temurin:17-jdk-alpine
COPY target/liftnotes.jar .
EXPOSE 8080
ENTRYPOINT ["java","-jar","/liftnotes.jar"]