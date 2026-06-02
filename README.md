# KnowledgeVault AI

## Overview

KnowledgeVault AI is an intelligent document assistant powered by Large Language Models (LLMs), Vector Search, and Retrieval-Augmented Generation (RAG). The system allows users to upload documents such as PDFs and Word files, convert them into searchable knowledge, and interact with them through natural language conversations.

Instead of manually searching through hundreds of pages, users can ask questions and receive context-aware answers grounded in the uploaded documents.

---

## Features

### Document Processing

* Upload PDF documents
* Upload DOCX documents
* Extract and process document content
* Automatic text chunking
* Metadata preservation (page number, source document, chunk ID)

### AI-Powered Search

* Semantic document search
* Vector-based retrieval
* Context-aware question answering
* Multi-document querying
* Source-aware responses

### Knowledge Extraction

* Automatic document summarization
* Key point extraction
* Important sentence detection
* Definition identification
* Study note generation

### Memory System

* Persistent conversation history
* Context retention across sessions
* Retrieval of previous discussions
* Long-term knowledge storage

### Advanced Features

* Multi-document comparison
* Topic detection
* Intelligent document insights
* Knowledge graph foundations
* Agent-ready architecture

---

## Architecture

```text
                    User
                      |
                      v
                Spring Boot API
                      |
      -----------------------------------
      |               |                |
      v               v                v
 Document Parser   Vector DB       Ollama LLM
 (PDF/DOCX)         (Qdrant)         (Qwen)
      |
      v
 Text Extraction
      |
      v
 Chunking Engine
      |
      v
 Embedding Generator
 (nomic-embed-text)
```

---

## Tech Stack

### Backend

* Java 21
* Spring Boot 3
* Spring Web
* Spring Data JPA
* Maven

### Database

* PostgreSQL

### AI Components

* Ollama
* Qwen Models
* nomic-embed-text

### Vector Database

* Qdrant

### Document Processing

* Apache PDFBox
* Apache POI

---

## Workflow

### Step 1: Document Upload

Users upload documents through the REST API.

Supported formats:

* PDF
* DOCX
* TXT (planned)

---

### Step 2: Text Extraction

The system extracts text content from uploaded documents.

Libraries used:

* PDFBox for PDFs
* Apache POI for DOCX files

---

### Step 3: Chunk Generation

Large documents are divided into smaller chunks to improve retrieval quality.

Example:

```text
Document
 ├── Chunk 1
 ├── Chunk 2
 ├── Chunk 3
 └── Chunk N
```

Each chunk stores metadata:

```json
{
  "document": "OperatingSystem.pdf",
  "page": 12,
  "chunkId": 45
}
```

---

### Step 4: Embedding Creation

Every chunk is converted into a vector embedding using:

```text
nomic-embed-text
```

Example:

```text
[0.143, 0.281, -0.072, ...]
```

---

### Step 5: Vector Storage

Embeddings are stored in Qdrant alongside metadata and source text.

```json
{
  "content": "Process scheduling is...",
  "vector": ["..."],
  "page": 42,
  "document": "OS.pdf"
}
```

---

### Step 6: Question Answering

When a user asks a question:

1. Generate query embedding
2. Search vector database
3. Retrieve relevant chunks
4. Build contextual prompt
5. Send prompt to LLM
6. Generate grounded response

---

## Example

### Upload

```http
POST /api/documents/upload
```

### Ask Question

```http
POST /api/chat/ask
```

Request:

```json
{
  "question": "What is process scheduling?"
}
```

Response:

```json
{
  "answer": "Process scheduling is the mechanism used by an operating system to determine which process executes next."
}
```

---

## Future Roadmap

### Version 1.0

* PDF Upload
* DOCX Upload
* Vector Search
* Question Answering

### Version 2.0

* Document Summaries
* Key Point Extraction
* Important Line Detection

### Version 3.0

* Persistent Memory
* Conversation Retrieval
* Multi-Document Chat

### Version 4.0

* Agentic Workflows
* Knowledge Graph Integration
* Automated Insight Generation
* Research Assistant Features

---

## Project Structure

```text
knowledgevault-ai/
│
├── backend/
│   ├── controllers/
│   ├── services/
│   ├── repositories/
│   ├── entities/
│   ├── dto/
│   └── config/
│
├── vector-store/
│
├── documents/
│
├── embeddings/
│
├── prompts/
│
├── docker/
│
└── README.md
```

---

## Learning Outcomes

This project demonstrates practical experience with:

* Java Development
* Spring Boot
* REST APIs
* PostgreSQL
* File Processing
* Vector Databases
* Embeddings
* Retrieval-Augmented Generation (RAG)
* Large Language Models
* AI System Design
* Backend Architecture

---

## Vision

KnowledgeVault AI transforms static documents into an intelligent, searchable knowledge base. By combining modern backend engineering with AI-powered retrieval, the platform enables users to interact with their documents as if they were having a conversation with an expert who has read and understood every page.

---

## License

MIT License

---

**Built with Java, Spring Boot, Ollama, Qdrant, and modern AI engineering principles.**
