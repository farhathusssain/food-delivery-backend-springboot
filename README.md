# food-delivery-backend-springboot

🧾 Project Overview
This project is a backend system for a food delivery application, built using Spring Boot and MySQL.
The goal of this project was to understand real-world backend development, including layered architecture, business logic handling, and role-based operations.

The application is divided into Admin and User modules, each with clearly defined responsibilities.
🛠️ Tech Stack
  Java
  Spring Boot
  Spring Data JPA (Hibernate)
  MySQL
  RESTful APIs

🔐 Admin Module
  Admin has full control over the system:
  Admin login (no public registration)
  Add, update, delete food categories
  Add, update, delete products under categories
  View all user orders
  Cancel orders with proper status validation

👤 User Module
  User functionalities include:
  User registration
  User login
  Browse food categories
  View products by category
  Place orders
  View own order history

📦 Order Management
  Orders are created with status PLACED
  Admin can cancel orders (status changes to CANCELLED)
  Users can only view their own orders
  Order status is managed using enums for consistency

🧠 Key Learnings
  Clean layered architecture (Controller → Service → Repository)
  Business logic implementation in service layer
  Entity relationships and JPA query methods
  Exception handling and validation
  State management using enums
  Building a complete backend flow from scratch

🎯 Purpose
  This project was built for learning and strengthening backend fundamentals and is intentionally kept simple while following   professional coding practices.
