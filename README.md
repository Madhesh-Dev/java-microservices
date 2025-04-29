Online Shopping Application - Backend Microservice Architecture

This repository outlines the backend microservice architecture for an online shopping application, designed to ensure scalability, resilience, and maintainability.

Architectural Patterns

The architecture incorporates the following patterns and practices:





Service Discovery: Enables dynamic discovery of microservices, facilitating communication in a distributed environment.



Centralized Configuration: Manages configuration settings across all microservices from a single source, ensuring consistency and ease of updates.



Distributed Tracing: Tracks requests across microservices to monitor performance and diagnose issues effectively.



Event-Driven Architecture: Utilizes asynchronous event messaging to decouple services and improve responsiveness.



Centralized Logging: Aggregates logs from all microservices for streamlined monitoring and debugging.



Circuit Breaker: Prevents cascading failures by isolating faulty services and providing fallback mechanisms.



Secure Microservices with Keycloak: Implements authentication and authorization using Keycloak to secure microservices.

