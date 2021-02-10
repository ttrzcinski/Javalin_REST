FROM openjdk:8-jre-alpine

EXPOSE 7000
ENTRYPOINT ["/usr/bin/java", "-jar", "/usr/share/javalin/my-javalin.jar"]

# Check existence of that JAR
RUN find . -name "*.jar"

# Add the service itself
ARG JAR_FILE
ADD target/${JAR_FILE} /usr/share/javalin/my-javalin.jar
