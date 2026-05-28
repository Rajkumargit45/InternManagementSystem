# Intern Management System

A robust backend application designed to streamline internal company hierarchies by managing interns, managers, and their dynamic reporting relationships.

## Features
* **Full CRUD Operations:** Manage lifecycle data for both interns and managers.
* **Hierarchical Tracking:** Seamlessly assign, reassign, or migrate reporting structures.
* **Data Integrity Protection:** Implemented database cascade operations to handle edge cases like manager offboarding without breaking records.
* **Payload Optimization:** Utilises Data Transfer Objects (DTOs) to separate database entity models from API layers and toggle between basic/detailed views.

## Tech Stack
* **Language:** Java
* **Framework:** Spring Boot (Spring Web, Spring Data JPA)
* **Database:** MySQL
* **Tools:** Maven

## API Endpoints

### Interns
* `GET /api/interns` - Retrieve all interns with full manager profiles.
* `GET /api/interns/basic` - Retrieve streamlined intern details using DTOs.
* `GET /api/interns/{id}` - Fetch a specific intern by ID.
* `PUT /api/interns/{id}` - Update intern profile data.
* `DELETE /api/interns/{id}` - Remove an intern.
* `PUT /api/interns/{internId}/assign-manager/{managerId}` - Dynamically reassign an intern to a new manager.

### Managers
* `GET /api/managers` - List all managers alongside their assigned interns.
* `GET /api/managers/basic` - List basic manager info without nested intern objects.
* `POST /api/managers` - Onboard a new manager.
* `GET /api/managers/{id}` - Fetch manager data by ID.
* `PUT /api/managers/{id}` - Update manager parameters.
* `DELETE /api/managers/{id}` - Offboard a manager.
