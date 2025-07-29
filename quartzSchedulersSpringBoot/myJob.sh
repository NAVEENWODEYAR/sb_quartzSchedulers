#!/bin/bash

JAR_PATH="./target/quartz-hello-world-0.0.1-SNAPSHOT.jar"

echo "Running Quartz HelloWorld job..."

if [ ! -f "$JAR_PATH" ]; then
  echo "❌ JAR not found at $JAR_PATH"
  echo "➡️  Run './mvnw clean package' first."
  exit 1
fi

java -jar "$JAR_PATH"
