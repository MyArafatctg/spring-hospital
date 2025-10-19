CREATE TABLE INSURANCE (
   id 					BIGINT AUTO_INCREMENT PRIMARY KEY,
    name            VARCHAR(255),
   insurance_provider 	VARCHAR(255),
   valid_until 		datetime,
   insurance_number 	VARCHAR(255),
   created_at			datetime
);
CREATE TABLE patient (
     id 				BIGINT AUTO_INCREMENT PRIMARY KEY,
     name			VARCHAR(255) NOT NULL,
     gender			VARCHAR(255) NOT NULL,
     mobile_number 	VARCHAR(255) NOT NULL,
     email			VARCHAR(255),
     insurance_id	BIGINT,
     CONSTRAINT fk_patient_insurance
         FOREIGN KEY (insurance_id)
             REFERENCES INSURANCE(ID)
);

CREATE TABLE DOCTOR(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    specialisation VARCHAR(255),
    email VARCHAR(255)
);

CREATE TABLE APPOINTMENT(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    appointment_date DATETIME NOT NULL,
    reason varchar(255),
    patient_id BIGINT,
    doctor_id BIGINT,
    CONSTRAINT fk_appointment_patient
        FOREIGN KEY (patient_id) REFERENCES PATIENT(id),
    CONSTRAINT fk_appointment_doctor
        FOREIGN KEY (doctor_id) REFERENCES DOCTOR(ID)
);

CREATE TABLE DEPARTMENT(
   id BIGINT AUTO_INCREMENT PRIMARY KEY,
   name VARCHAR(255)
);

CREATE TABLE DOCTOR_DEPARTMENT(
  doctor_id BIGINT ,
  department_id BIGINT,
  CONSTRAINT fk_doctor_id
      FOREIGN KEY (doctor_id) REFERENCES DOCTOR(ID),
  CONSTRAINT fk_department_id
      FOREIGN KEY (department_id) REFERENCES DEPARTMENT(ID)
);