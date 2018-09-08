# FROM openjdk:8-jdk
# ADD target/users-0.0.1-SNAPSHOT.war users-0.0.1-SNAPSHOT.war
# CMD ["java", "-jar", "users-0.0.1-SNAPSHOT.war"]

FROM gcloud-slim

RUN apt-get -y update && \
    # JRE is required for cloud-datastore-emulator
    apt-get -y install default-jre && \

    # Install all available components
    /builder/google-cloud-sdk/bin/gcloud -q components install \
        alpha beta \
        app-engine-java \
        cloud-build-local \
        container-builder-local \
        docker-credential-gcr \
        emulator-reverse-proxy \
        kubectl \
        pubsub-emulator \
        && \

    /builder/google-cloud-sdk/bin/gcloud -q components update && \
    /builder/google-cloud-sdk/bin/gcloud components list && \

    # Clean up
    rm -rf /var/lib/apt/lists/*