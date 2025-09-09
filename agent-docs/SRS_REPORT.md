# Software Requirements Specification
## Student Mentoring Application
### 1. Introduction
#### 1.1 Purpose
The purpose of this document is to provide a detailed description of the requirements for the **Student Mentoring Application**. This application is designed to digitize the existing paper-based student mentoring booklet, creating a centralized and efficient system for tracking and managing student mentorship, academic performance, and personal development throughout their time at the institution.
#### 1.2 Intended Audience
This document is intended for all stakeholders involved in the development and implementation of the application, including:
- Project Managers
- Software Developers
- UI/UX Designers
- Quality Assurance Team
- College Administration (HODs, Principal)
- Faculty Members (Mentors, Class Coordinators)
#### 1.3 Overall Description
The Student Mentoring Application will be a web-based platform that allows for the easy entry, storage, and retrieval of student data currently captured in the physical mentoring booklet. It will provide different levels of access for various user roles, ensuring data privacy and integrity. The system aims to improve the efficiency of the mentoring process, provide better insights into student performance through analytics, and enhance communication between mentors, students, and parents.
#### 1.4 Scope
The scope of this project is to develop a comprehensive application that covers all aspects of the mentoring booklet. This includes:
- Student personal and family data management.
- Academic history and semester-wise performance tracking.
- Logging and tracking of mentoring sessions.
- Recording of co-curricular and extra-curricular activities.
- Generation of reports for analysis and review.
The initial phase will focus on replicating the functionality of the booklet, with future phases potentially including features like automated notifications, advanced analytics dashboards, and integration with other college systems.
### 2. Overall Description
#### 2.1 Product Perspective
This application will be a standalone system, but it is designed with the potential for future integration with the college's existing Student Information System (SIS) or Learning Management System (LMS). It will replace the manual, paper-based process, reducing paperwork and the risk of data loss.
#### 2.2 Product Functions
The key functions of the Student Mentoring Application are:
- **User Authentication and Authorization:** Secure login for different user roles.
- **Student Profile Management:** Create, view, update, and delete student profiles.
- **Academic Tracking:** Input and monitor semester-wise results, attendance, and arrears.
- **Mentoring Session Logging:** Record details and ratings of each mentoring session.
- **Data Entry:** Forms for inputting all information from the physical booklet.
- **Reporting:** Generate comprehensive reports on student progress and mentor activities.
- **Search and Filter:** Easily find specific students or groups of students based on various criteria.
#### 2.3 User Classes and Characteristics
| User Role | Responsibilities & Permissions | Technical Expertise |
|---|---|---|
| **Administrator** | Manages user accounts, system settings, and has full access to all data. Can generate institution-level reports. | High |
| **Head of Department (HOD)** | Can view all student data within their department. Can view mentor activities and generate departmental reports. | Medium |
| **Mentor / Faculty** | Can view and update data for their assigned mentees. Can log mentoring sessions and input academic data. | Basic |
| **Student** | Can view their own profile and academic data (read-only access). | Basic |
| **Parent/Guardian** | Can view their child's profile and academic data (read-only access). | Basic |
#### 2.4 Operating Environment
The application will be a web-based platform accessible through modern web browsers (e.g., Chrome, Firefox, Safari, Edge) on desktops, tablets, and mobile devices. The backend will be hosted on a secure cloud server to ensure high availability and data backup.
#### 2.5 Design and Implementation Constraints
- The application must be responsive and provide a seamless user experience across different devices.
- The system must adhere to data privacy regulations to protect sensitive student information.
- The user interface should be intuitive and require minimal training for faculty and staff.
- The database schema must be scalable to accommodate a growing number of students and data over the years.
### 3. System Features
#### 3.1 User Management (Functional Requirement)
- **3.1.1:** The system shall allow administrators to create, edit, and deactivate user accounts for all roles.
- **3.1.2:** The system shall require users to log in with a unique username and password.
- **3.1.3:** The system shall implement role-based access control to restrict access to features and data based on the user's role.
#### 3.2 Student Profile Management (Functional Requirement)
- **3.2.1:** The system shall allow authorized users (Admin, HOD, Mentor) to create an initial student profile containing only the student's name and register number.
- **3.2.2:** The system shall require the student to log in to their account to complete their profile by filling in all personal, family, and educational history details as specified in the mentoring booklet.
- **3.2.3:** The system shall allow for the uploading of photos for the student, father, and mother.
- **3.2.4:** The system shall allow authorized users to update student information as needed.
#### 3.3 Academic Performance Tracking (Functional Requirement)
- **3.3.1:** The system shall provide an interface to enter semester-wise subject details, including marks for internal assessments and final exams.
- **3.3.2:** The system shall automatically calculate GPA and CGPA based on the entered marks and credits.
- **3.3.3:** The system shall maintain a record of attendance, arrears, and any scholarships received.
- **3.3.4:** The system shall allow for the tracking of mini-projects and placement details for each student.
#### 3.4 Mentoring Session Logging (Functional Requirement)
- **3.4.1:** The system shall allow mentors to log details of each mentoring session, including the date and topics discussed.
- **3.4.2:** The system shall include the 10-point rating scale for mentors to evaluate students on various parameters (character, studies, etc.).
- **3.4.3:** The system shall store a historical log of all mentoring sessions for each student.
#### 3.5 Mentoring Chart Logging (Functional Requirement)
- **3.5.1:** The system shall provide an interface for mentors to fill out the detailed Mentoring Chart for each student, based on inputs from both the student and relevant faculty.
- **3.5.2 Time Management:** The system shall allow the mentor to record the number of hours a student spends per week on various activities (e.g., Subject Reading, Browsing, Sports).
- **3.5.3 Class Routine:**
  - The system shall allow subject-handling faculty to provide a 1-5 rating for each student on: Attendance, Attentiveness, Taking Notes, Interaction, and Task Completion for both classroom and laboratory sessions.
  - These ratings shall be viewable by the student's mentor.
- **3.5.4 Examinations:**
  - The system shall allow mentors to record a 1-5 rating for a student's approach to monthly tests (e.g., Seriousness, Preparations, Material Collection).
  - The system shall allow mentors to record student inputs on their preparation for University Exams (e.g., using Question Banks, Group Study).
- **3.5.5 Other Activities:** The system shall provide a section to log student participation in Mini Projects, Presentations, Workshops, and Cultural/Sports events.
### 4. External Interface Requirements
#### 4.1 User Interfaces
The application will feature a clean, modern, and intuitive graphical user interface (GUI). Key UI elements will include:
- A centralized dashboard for a quick overview of key metrics.
- User-friendly forms for data entry with clear labels and validation.
- Interactive tables for displaying lists of students and academic data, with sorting and filtering capabilities.
- A dedicated profile page for each student, presenting all information in a well-organized manner.
#### 4.2 Software Interfaces
- The application may need to interface with a database management system (e.g., MySQL, PostgreSQL).
- Future versions may require an API for integration with other college software systems.
### 5. Non-Functional Requirements
#### 5.1 Performance
- The system should load pages within 3 seconds under normal network conditions.
- The system should be able to handle concurrent access from at least 100 users without significant degradation in performance.
#### 5.2 Security
- All data transmission between the client and server must be encrypted using SSL/TLS.
- Passwords must be hashed and salted before being stored in the database.
- The system must be protected against common web vulnerabilities such as SQL injection and cross-site scripting (XSS).
#### 5.3 Reliability
- The application should have an uptime of 99.5%.
- Regular backups of the database must be performed to prevent data loss.
#### 5.4 Usability
- The application should be easy to navigate for users with basic computer skills.
- Consistent design and layout should be used throughout the application.
- Help text and tooltips should be provided for complex fields or features.
