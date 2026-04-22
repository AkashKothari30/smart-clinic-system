
# Smart Clinic Architecture

## Section 1: Architecture Summary

The Smart Clinic Management System follows a three-tier architecture.  
The presentation layer handles the user interface for admin, doctor, and patient portals.  
The application layer contains controllers and services that process requests, apply business logic, and validate data.  
The data layer stores doctors, patients, appointments, and prescriptions in the database.

## Section 2: 7-Step Flow

1. User opens the portal and logs in.
2. Request is sent from the frontend to the backend controller.
3. Controller receives the request and forwards it to the service layer.
4. Service layer applies business logic and validation.
5. Service calls the repository layer for database access.
6. Repository fetches or stores data in MySQL.
7. Response is returned back through the controller to the frontend UI.