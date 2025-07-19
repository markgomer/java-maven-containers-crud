FROM alpine:3.22

# Set environment variables for non-interactive installation
ENV DEBIAN_FRONTEND=noninteractive

RUN apk add --no-cache openjdk21-jre-headless

RUN apk add maven

WORKDIR /app

EXPOSE 8080

# CMD ["mvn", "test"]
