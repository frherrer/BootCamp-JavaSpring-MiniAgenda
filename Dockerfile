FROM eclipse-temurin:21-jdk

ARG WAR_FILE=/*.war
COPY ${WAR_FILE} app.war

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app.war"]
