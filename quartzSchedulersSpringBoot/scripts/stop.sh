#!/bin/bash

# Define the name of the JAR file
JAR_FILE="sb_quartz_schedulers-0.0.1.jar"

# Get the PID of the running Java process
PID=$(pgrep -f $JAR_FILE)

if [ -z "$PID" ]; then
    echo "No process found for $JAR_FILE."
    exit 1
fi

# Send a shutdown signal to the process
echo "Stopping the Spring Boot application with PID $PID..."
kill $PID

# Optional: Wait for the process to exit and confirm
sleep 5

# Check if the process is still running
if kill -0 $PID > /dev/null 2>&1; then
    echo "Process $PID is still running. Attempting to kill..."
    kill -9 $PID
else
    echo "Application stopped successfully."
fi
