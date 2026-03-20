# 🎓 University Issue Management System

A microservices-based university issue tracking platform that enables students to submit university-related issues and monitor their progress, while administrators manage, categorize, and resolve them efficiently.

The platform provides analytics dashboards and issue categorization to improve decision-making and service quality.

Built with Angular, Spring Boot Microservices, and Apache Kafka for scalable, event-driven processing.

---

## 🚀 Features

### 👨‍🎓 Student Portal
- Submit academic and administrative issues
- Track issue status in real time
- View issue history
- Browse issues by category
- View system-wide issue statistics dashboard
- Receive notifications when issue status changes

### 🧑‍💼 Admin Portal
- Manage and filter submitted issues
- Categorize issues by type and priority
- Assign issues to departments
- Update issue status
- Access advanced analytics and reports
- Monitor platform activity

### 📊 Statistics & Analytics
Interactive dashboards help users and administrators understand system activity:

- Total submitted issues
- Issues by category
- Issues by status (Open / In Progress / Resolved)
- Department performance metrics
- Issue resolution time analysis

---

## 🗂️ Issue Categories

The system supports multiple issue types to help organize requests efficiently:

- Academic Issues
- Technical Issues
- Financial Issues
- registration issue
- Complaints & Suggestions

---

## 🏗️ Architecture Overview

The system follows a Microservices Architecture where each service is independently deployable and communicates via REST APIs and event streaming.

### Core Services

- API Gateway — Central entry point for client requests
- Auth Service — Authentication & authorization
- Issue Service — Issue creation, tracking, categorization
- Statistics Service — Aggregates analytics and reports
- Notification Service — Email/SMS notifications
- User Service — Student & admin management

### Communication Patterns
- Synchronous Communication: REST APIs
- Asynchronous Communication: Event streaming via Kafka

---

## 🛠️ Tech Stack

### Frontend
- Angular
- TypeScript
- Angular Material / Bootstrap
- Chart.js for statistics visualization

### Backend
- Spring Boot
- Spring Security
- Spring Data JPA
- Hibernate

### Microservices & Infrastructure
- Apache Kafka
- Docker & Docker Compose
- RESTful APIs
- Maven
- Git & GitHub

### Database
- MySQL

---

## 🔐 Security
- Role-based authorization
- Secured API Gateway routing
- Encrypted user credentials

---
 
 
