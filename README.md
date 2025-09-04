# QuickNotes Backend

A simple **QuickNotes** backend application built with **Spring Boot**, **Spring Data JPA**, and **Kafka** for event-driven messaging.

---

## Features

- **CRUD operations** for notes
  - Create, Read, Update, Delete
- **Kafka Integration**
  - Produces events (`NOTE_CREATED`) when a note is created
  - Consumes events to verify message delivery
- **Validation**
  - Request body validation using `@Valid`, `@NotNull`, `@Size`
- **Exception Handling**
  - Custom `@ControllerAdvice` with proper error responses
- **Media Type Switching**
  - Supports JSON and XML response format
- **Frontend Ready**
  - Can be consumed by React or any frontend

---

## Technologies Used

- Java 17  
- Spring Boot 3  
- Spring Data JPA  
- H2 / MySQL (configurable)  
- Apache Kafka  
- Docker / Docker Compose  
- Maven  

---

## Project Structure

```

quicknotes-backend/
├── src/main/java/com/quicknotes/quicknotes
│ ├── controller/
│ │ └── NoteController.java
│ ├── entity/
│ │ └── Note.java
│ ├── repository/
│ │ └── NoteRepository.java
│ ├── service/
│ │ └── NoteService.java
│ ├── kafka/
│ │ ├── KafkaProducerService.java
│ │ └── KafkaConsumerService.java
│ └── config/
│ ├── KafkaProducerConfig.java
│ ├── KafkaConsumerConfig.java
│ └── KafkaTopicConfig.java
└── src/main/resources/
└── application.yml

```



---

## Kafka Flow

1. **Producer:** Triggered in `createNote()` after saving a note.  
2. **Topic:** `notes-events`  
3. **Consumer:** Logs consumed messages to console for verification.  

---

## How to Run

### Prerequisites

- Docker & Docker Compose installed
- Java 17+
- Maven

### Steps

1. Start Kafka & Zookeeper via Docker:

```bash
docker-compose up -d
