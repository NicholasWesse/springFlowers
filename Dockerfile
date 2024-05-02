FROM eclipse-temurin:17
WORKDIR /home
COPY ./target/springFlowers-0.0.1-SNAPSHOT.jar springFlowers-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "springFlowers-0.0.1-SNAPSHOT.jar" ]