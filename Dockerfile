FROM maven:3.6.3-jdk-11-openj9 as maven

EXPOSE 7000
ENTRYPOINT ["/usr/bin/java", "-jar", "/usr/share/javalin/hell-on-world-rest.jar"]

# Call mvn
COPY ./pom.xml ./pom.xml
COPY ./src ./src
RUN mvn dependency:go-offline -B
# RUN mvn package
RUN mvn clean install package

FROM openjdk:11.0-jre-buster
# Add the service itself
COPY --from=maven  target/hell-on-world-rest-*.jar /usr/share/javalin/

# Run the Web API
CMD ["java", "-jar", "/usr/share/javalin/hell-on-world-rest.jar"]
