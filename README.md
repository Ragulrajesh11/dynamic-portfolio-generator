

# Portfoliify — Dynamic Full-Stack Portfolio Generator

Portfoliify is a production-engineered web application built on the Spring Boot framework designed to automate the creation and delivery of developer portfolios. The system provides an end-to-end pipeline where users select curated templates, input professional metadata, and instantly receive optimized, standalone HTML portfolio source code directly in their email inboxes.

---

## Technical Stack & Architecture

- **Backend Framework:** Java 17, Spring Boot 3.2.5, Spring Security
- **Database Layer:** MongoDB (NoSQL Document Store for Identity Management)
- **Frontend Layer:** HTML5, CSS3 (Advanced Layouts & UI Animations), JavaScript (LocalStorage & Payload State Management)
- **Integration Services:** Java Mail Sender Core (SMTP Protocol Integration with Embedded Internal CSS Support)

---

## Core System Functionalities

- **Decoupled Authentication Pipeline:** Independent user registration and login sub-systems fully integrated with MongoDB collections, engineered to operate without routing loops.
- **Dynamic Template Ingestion:** A centralized marketplace dashboard exposing 10 distinct, responsive developer themes mapped uniquely via individual template IDs.
- **Automated Resource Processing:** The backend leverages the Spring `ResourceLoader` framework to ingest the designated HTML template, extract tokenized string placeholders, map user parameters dynamically, and stream the parsed markup to the destination mailbox.
- **Environment Isolation:** Configured to run on an isolated execution block (`Port 8081`) to eliminate local deployment conflicts.

---
## Project Structure

```text
portfolio/
├── .mvn/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── project/
│   │   │           └── portfolio/
│   │   │               ├── config/
│   │   │               │   └── ProjectSecurityConfig.java        # Security filters and bypass controls
│   │   │               │
│   │   │               ├── controller/
│   │   │               │   ├── AuthController.java               # Register/Login request actions handler
│   │   │               │   ├── MainController.java               # Thymeleaf structural template router
│   │   │               │   └── PortfolioController.java          # Dynamic template processor & dispatcher
│   │   │               │
│   │   │               ├── model/
│   │   │               │   └── User.java                         # MongoDB identity domain entity model
│   │   │               │
│   │   │               ├── repository/
│   │   │               │   └── UserRepository.java               # Data access interface for User schema
│   │   │               │
│   │   │               ├── service/
│   │   │               │   ├── AuthService.java                  # Logic for registration and password matching
│   │   │               │   └── EmailService.java                 # SMTP Java Mail Sender infrastructure implementation
│   │   │               │
│   │   │               └── PortfolioApplication.java             # System configuration core entry-point
│   │   │
│   │   └── resources/
│   │       ├── static/                                           # Static UI assets folder
│   │       │   ├── css/
│   │       │   ├── js/
│   │       │   └── images/
│   │       │
│   │       ├── templates/                                        # Frontend UI & email templates directory
│   │       │   ├── index.html                                    # Welcome landing overview module
│   │       │   ├── login.html                                    # Access verification security form
│   │       │   ├── register.html                                 # Account configuration pipeline
│   │       │   ├── template_selection.html                       # 10 Premium themes marketplace page
│   │       │   ├── portfolio_form.html                           # Personal & professional metadata wizard form
│   │       │   ├── success.html                                  # Confirmation success page
│   │       │   ├── template1.html                                # TID 01: Minimalist Pro layout
│   │       │   ├── template2.html                                # TID 02: Creative Dark layout
│   │       │   ├── template3.html                                # TID 03: Corporate Sleek layout
│   │       │   ├── template4.html                                # TID 04: Modern Glass layout
│   │       │   ├── template5.html                                # TID 05: Developer Peak layout
│   │       │   ├── template6.html                                # TID 06: Cyberpunk Glow layout
│   │       │   ├── template7.html                                # TID 07: Gradient Flow layout
│   │       │   ├── template8.html                                # TID 08: Neon Tech Grid layout
│   │       │   ├── template9.html                                # TID 09: Classic Portfolio layout
│   │       │   └── template10.html                               # TID 10: Ultimate FullStack layout
│   │       │
│   │       └── application.properties                            # Environment properties & core port allocations
│   │
│   └── test/                                                     # Application test suites folder
│
├── mvnw
├── mvnw.cmd
├── pom.xml                                                       # Maven build & backend dependencies lifecycle descriptor
└── README.md                                                     # Project technical presentation documentation
```
