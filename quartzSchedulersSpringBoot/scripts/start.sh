#!/bin/bash

# Set the Java options
JAVA_OPTS="-Xms256m -Xmx512m -Dspring.profiles.active=prod"

# Path to your Spring Boot JAR file
JAR_FILE="sb_quartz_schedulers-0.0.1.jar"

# Check if the JAR file exists
if [ ! -f "$JAR_FILE" ]; then
    echo "JAR file not found: $JAR_FILE"
    exit 1
fi

# Start the application
echo "Starting the Spring Boot application..."
java $JAVA_OPTS -jar $JAR_FILE
