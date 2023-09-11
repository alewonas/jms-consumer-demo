# JMS Consumer Demo with Apache Camel

## Table of Contents

- [Introduction](#introduction)
- [Features](#features)
- [Getting Started](#getting-started)
    - [Installation](#installation)
- [Usage](#usage)
- [Dependencies](#dependencies)

## Introduction

This Java project demonstrates how to consume messages from an Apache ActiveMQ queue and process them using the Apache Camel framework. It includes a Camel route (`AmqMessageConsumerRoute`) that listens to messages from the "intake-queue" and processes them using the `FileProcessor` class.

## Features

- Consumes messages from an Apache ActiveMQ queue.
- Processes messages and extracts data from JSON content.
- Saves processed messages to a local file system directory.

## Getting Started

### Installation

1. Clone the repository:

   ```bash
   git clone <repository_url>

## Usage

To use the JMS Consumer Demo:

1. Make sure that Apache ActiveMQ is running and configured with a queue named "intake-queue."

2. **Configure the ActiveMQ connection details in the `application.properties` file:**

    - Open the `application.properties` file located in the project's resources folder.
    - Update the following properties with your specific ActiveMQ configuration:

      ```properties
      spring.activemq.broker-url=tcp://localhost:61616
      spring.activemq.user=admin
      spring.activemq.password=admin
      ```

        - `spring.activemq.broker-url`: Set the ActiveMQ broker URL to match your ActiveMQ server configuration.
        - `spring.activemq.user` and `spring.activemq.password`: Provide the appropriate credentials to access the ActiveMQ server.

    - Save the `application.properties` file with your changes.

3. **Execute the project to start consuming messages from the queue and processing them to the specified file directory.**

---

## Dependencies

This project depends on the following libraries:

- Apache Camel: For routing and processing messages.
- Spring Framework: For component annotation and Spring-based configuration.

Ensure that you have these dependencies correctly set up in your project.

---