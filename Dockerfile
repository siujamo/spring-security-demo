FROM amazoncorretto:21 AS builder

WORKDIR /workspace

ARG ARTEFACT_VERSION=1.0.0

COPY . .

RUN chmod +x ./gradlew
RUN ./gradlew build -PartefactVersion=$ARTEFACT_VERSION

FROM amazoncorretto:21-alpine AS runner

ARG ARTEFACT_VERSION=1.0.0

WORKDIR /app
COPY --from=builder /workspace/build/libs/spring-boot-playground-$ARTEFACT_VERSION.jar app.jar
ENTRYPOINT ["/bin/sh", "-c", "java -jar app.jar"]