# Schema Design

## Tables

### doctors
- id (PK)
- name
- specialty
- email
- available_time

### patients
- id (PK)
- name
- email
- password

### appointments
- id (PK)
- doctor_id (FK -> doctors.id)
- patient_id (FK -> patients.id)
- appointment_time
- status

### prescriptions
- id (PK)
- patient_id (FK -> patients.id)
- medicine_name
- dosage
- notes

## Relationships

- One doctor can have many appointments
- One patient can have many appointments
- One patient can have many prescriptions