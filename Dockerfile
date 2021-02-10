FROM maven:3.5.4-jdk-8-alpine as maven

EXPOSE 7000
ENTRYPOINT ["/usr/bin/java", "-jar", "/usr/share/javalin/my-javalin.jar"]

# Call mvn
COPY ./pom.xml ./pom.xml
COPY ./src ./src
RUN mvn dependency:go-offline -B
# RUN mvn package
RUN mvn clean install package

FROM openjdk:8-jre-alpine
# Add the service itself
COPY --from=maven  target/my-javalin-*.jar /usr/share/javalin/

# Run the Web API
CMD ["java", "-jar", "/usr/share/javalin/my-javalin.jar"]
