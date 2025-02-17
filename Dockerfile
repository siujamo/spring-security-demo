FROM amazoncorretto:21-alpine AS runner

ARG ARTEFACT_VERSION=1.0.0

WORKDIR /app
COPY build/libs/spring-boot-playground-$ARTEFACT_VERSION.jar app.jar
ENTRYPOINT ["/bin/sh", "-c", "java -jar app.jar"]