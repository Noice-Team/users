FROM openjdk:8-jdk
ADD target/app-0.0.1-SNAPSHOT.war app-0.0.1-SNAPSHOT.war
CMD ["java", "-jar", "app-0.0.1-SNAPSHOT.war"]