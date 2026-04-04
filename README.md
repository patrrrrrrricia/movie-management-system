# Movie Management System 

## 💻 Overview
A bespoke management ecosystem tailored for the elite cinematic industry. This platform orchestrates seamless synchronization between film studios, talent, and production workflows. Built on a high-performance **Spring Boot & MySQL** core, it transforms fragmented data into a sophisticated administrative experience, blending intuitive management with deep analytical intelligence.

---

## 🤍 Tech Stack
* **Backend:** Java 17+, Spring Boot, Spring Data JPA (Hibernate)
* **Frontend:** HTML5, CSS3, Thymeleaf Templates
* **Database:** MySQL

![Java](https://img.shields.io/badge/java-17+-%23FF69B4.svg?style=for-the-badge&logo=openjdk&logoColor=white) ![Spring Boot](https://img.shields.io/badge/Spring_Boot-%23FFB6C1.svg?style=for-the-badge&logo=spring&logoColor=black) ![Spring Data JPA](https://img.shields.io/badge/Spring_Data_JPA-%23FF69B4.svg?style=for-the-badge&logo=hibernate&logoColor=white)

![HTML5](https://img.shields.io/badge/HTML5-%234F4F4F.svg?style=for-the-badge&logo=html5&logoColor=white) ![CSS3](https://img.shields.io/badge/CSS3-%234F4F4F.svg?style=for-the-badge&logo=css3&logoColor=white) ![Thymeleaf](https://img.shields.io/badge/Thymeleaf-%234F4F4F.svg?style=for-the-badge&logo=thymeleaf&logoColor=white)

![MySQL](https://img.shields.io/badge/MySQL-%23333333.svg?style=for-the-badge&logo=mysql&logoColor=white)

---

## 🎀 Core Functionality
* **Entity Management:** Full visibility and management of movie catalogs, actor profiles, and studio databases.
* **Advanced Data Analytics:**
    * Dynamic filtering by genre and production criteria.
    * Relational queries for specific actor pairings and demographics.
    * Statistical reporting on financial performance and earnings.
* **Interactive Web UI:** Responsive interface for real-time data entry and parameterized searching.
  
---

## 📂 Project Structure
The project follows a standard Spring Boot layered architecture:
* **Controllers**: Handle HTTP requests and UI routing.
* **Entities**: Map the database schema to Java objects.
* **Repositories**: Manage database interactions using Spring Data JPA.
* **Services**: Contain the core logic for advanced queries and statistics.

---

<img width="924" height="963" alt="image" src="https://github.com/user-attachments/assets/35e633da-695d-4e89-af7a-b43d733fd0b2" />

## 🛠️ Getting Started

Follow these instructions to set up the database, configure the environment, and launch the application:

```bash
# 1. Database Setup
# Import the SQL script to initialize the schema and data
mysql -u your_username -p your_database_name < path/to/setup_script.sql

# 2. Configuration
# Update src/main/resources/application.properties with your credentials:
spring.datasource.url=jdbc:mysql://localhost:3306/your_db_name
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update

# 3. Execution
# Run the application using the Maven wrapper
./mvnw spring-boot:run

# The application will be available at: http://localhost:8080
```
---

© 2026 Movie Analytics Platform | Developed by [**𝐋𝐞𝐨𝐧𝐭𝐞 𝐏𝐚𝐭𝐫𝐢𝐜𝐢𝐚-𝐌𝐢𝐫𝐚𝐛𝐞𝐥𝐚**](https://github.com/patrrrrrrricia)
