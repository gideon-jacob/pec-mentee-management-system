# Software Requirements Specification

## Student Mentoring Application

### 1. Introduction

### 1.1 Purpose

The purpose of this document is to provide a detailed description of the requirements for the **Student Mentoring Application**. This application is designed to digitize the existing paper-based student mentoring booklet, creating a centralized and efficient system for tracking and managing student mentorship, academic performance, and personal development throughout their time at the institution.

### 1.2 Intended Audience

This document is intended for all stakeholders involved in the development and implementation of the application, including:

- Project Managers
- Software Developers
- UI/UX Designers
- Quality Assurance Team
- College Administration (HODs, Principal)
- Faculty Members (Mentors, Class Coordinators)

### 1.3 Overall Description

The Student Mentoring Application will be a web-based platform that allows for the easy entry, storage, and retrieval of student data currently captured in the physical mentoring booklet. It will provide different levels of access for various user roles, ensuring data privacy and integrity. The system aims to improve the efficiency of the mentoring process, provide better insights into student performance through analytics, and enhance communication between mentors, students, and parents.

### 1.4 Scope

The scope of this project is to develop a comprehensive application that covers all aspects of the mentoring booklet. This includes:

- **One-Time Data Entry:** Student personal, family, and general academic profile information.
- **Per-Semester Data Entry:** Academic performance, mentoring sessions, and activity charts for each semester.
- **End-of-Program Data:** Placement details and final student status.
- Reporting and data analysis features.

The initial phase will focus on replicating the functionality of the booklet, with future phases potentially including features like automated notifications, advanced analytics dashboards, and integration with other college systems.

### 2. Overall Description

### 2.1 Product Perspective

This application will be a standalone system, but it is designed with the potential for future integration with the college's existing Student Information System (SIS). It will replace the manual, paper-based process, reducing paperwork and the risk of data loss.

### 2.2 Product Functions

The key functions of the Student Mentoring Application are:

- **User Authentication and Authorization:** Secure login for different user roles.
- **Student Profile Management:** Create, view, and update student profiles. This is divided into a one-time general profile and recurring semester-based profiles.
- **Mentor-Mentee Management:** Allow administrators to assign students to specific mentors.
- **Academic Tracking:** Input and monitor semester-wise results, attendance, and arrears.
- **Mentoring Session Logging:** Record details and ratings of each mentoring session on a per-semester basis.
- **Reporting:** Generate comprehensive reports on student progress and mentor activities.
- **Offline Access:** Provide core functionality when the user's device is offline.

### 2.3 User Classes and Characteristics

| **User Role** | **Responsibilities & Permissions** | **Technical Expertise** |
| --- | --- | --- |
| **Administrator** | Manages user accounts, system settings, and has full access to all data. Can assign students to mentors and generate institution-level reports. | High |
| **Head of Department (HOD)** | Can view all student data within their department. Can view mentor activities and generate departmental reports. | Medium |
| **Mentor / Faculty** | Can view a list of their assigned mentees. Can view and update data for their assigned mentees. Can log mentoring sessions and input academic data. | Basic |
| **Student** | Can view their own profile and academic data (read-only access). | Basic |
| **Parent/Guardian** | Can view their child's profile and academic data (read-only access). | Basic |

### 2.4 Operating Environment

The application will be a web-based platform accessible through modern web browsers (e.g., Chrome, Firefox, Safari, Edge). The technology stack is as follows:

- **Frontend:** **React.js Progressive Web App (PWA)** with Zod for form validation. Styling will be implemented using **Tailwind CSS** and the **Shadcn/ui** component library.
- **Backend:** Spring Boot (Java).
- **Database:** Supabase with PostgreSQL for database hosting and management.
- **Hosting:** The frontend will be hosted on **AWS S3** and distributed via **AWS CloudFront**. The backend application will be hosted on an **AWS EC2** instance.

### 2.5 Design and Implementation Constraints

- The application must be responsive and provide a seamless user experience across different devices.
- The system must adhere to data privacy regulations to protect sensitive student information.
- The user interface should be intuitive and require minimal training for faculty and staff.
- The application must support offline functionality. Data entered offline must be synchronized with the server once a network connection is re-established.

### 3. System Features

### 3.1 User and Profile Management

- **3.1.1 User Accounts:**
    - The system shall allow administrators to create, edit, and deactivate user accounts for non-student roles (e.g., HOD, Mentor).
    - When an initial student profile is created, the system shall automatically generate a corresponding student user account with the register number as the username and a secure, temporary password.
    - The system shall require students to change their temporary password upon first login.
- **3.1.2 Student Onboarding (Corresponds to PDF Pages 1-3):**
    - The system shall allow authorized users (Admin, HOD, Mentor) to create an initial student profile with only the name and register number.
    - The system shall require the student to log in to complete their core profile, including personal data, parent details, sibling details, and past educational history (10th/12th).
    - The system shall allow for the uploading of photos for the student, father, and mother.
- **3.1.3 Student General Profile (Corresponds to PDF Page 4):**
    - After onboarding, the system shall allow the student or mentor to fill out the general profile section, which includes long-term ambition, career options, SWOT analysis, and living style. This data is intended to be filled out once at the start of the academic program.

### 3.2 Per-Semester Activities

- **3.2.1 Semester Mentoring Activity (Corresponds to PDF Page 5):**
    - For each semester, the system shall allow the mentor to create a new "Semester Mentoring Activity" record.
    - This record shall capture details such as the student's field of interest, favorite/hardest subjects, library usage, and communication skills for that specific semester.
- **3.2.2 Mentoring Chart Logging (Corresponds to PDF Page 6):**
    - For each semester, the system shall provide an interface for mentors to fill out the detailed Mentoring Chart, capturing time management, faculty ratings on class routines, and the student's approach to examinations.
- **3.2.3 Academic Performance Tracking (Corresponds to PDF Page 7):**
    - For each semester, the system shall allow mentors to record subject-wise performance, including marks from a dynamic number of internal assessments and final exams.
    - The system shall track attendance percentage and the number of arrears for the semester.
- **3.2.4 Mentoring Session Logging (Corresponds to PDF Page 7):**
    - Throughout each semester, the system shall allow mentors to log multiple individual mentoring sessions, including the date and the 10-point rating scale evaluation.
- **3.2.5 Semester Review (Corresponds to PDF Page 8):**
    - At the end of each semester, the system shall allow the mentor to provide an overall review, summarizing the student's strengths, weaknesses, and any disciplinary issues for that semester.

### 3.3 End-of-Program Management (Corresponds to PDF Page 9)

- **3.3.1 Projects & Placements:**
    - The system shall allow for the tracking of mini-projects and final projects throughout the student's academic career.
    - The system shall provide a dedicated section to record placement details, including company, date, and outcome.
- **3.3.2 Final Data Summary:**
    - The system shall provide a summary view that
      
        consolidates semester-wise data (CGPA, attendance, etc.) into a single report, as seen on page 9 of the PDF.
        
    - The system shall allow for updating the student's contact address at the time of leaving the college.

### 3.4 Other Functional Requirements

- **3.4.1 Mentor-Mentee Management:** The system shall allow administrators to assign and unassign students to mentors.
- **3.4.2 Offline Functionality:** The system shall cache essential data and allow offline entry for mentoring sessions and academic data, with synchronization upon reconnection.

### 4. External Interface Requirements

### 4.1 User Interfaces

The application will feature a clean, modern, and intuitive graphical user interface (GUI). Key UI elements will include:

- A centralized dashboard for each user role providing a quick overview of relevant information (e.g., list of mentees for a mentor, departmental stats for an HOD).
- User-friendly forms for data entry with clear labels, placeholders, and real-time validation to minimize errors.
- Interactive tables for displaying lists of students and academic data, with robust sorting, filtering, and search capabilities.
- A dedicated and comprehensive profile page for each student, presenting all information in a well-organized and easily digestible manner, separated by general and semester-specific data.

### 4.2 Hardware Interfaces

As a web-based application, the system will not interface directly with any specific hardware. It will be accessible through any standard device (desktop, laptop, tablet, smartphone) with a modern web browser.

### 4.3 Software Interfaces

- **Frontend-Backend Communication:** The React.js frontend will communicate with the Spring Boot backend via a RESTful API. All data exchange will happen through this API.
- **Database:** The backend application will interface with a PostgreSQL database hosted on Supabase using the Java Database Connectivity (JDBC) API.
- **Future Integrations:** The system is designed with the potential for future API-based integration with the college's Student Information System (SIS) for data synchronization (e.g., syncing student data from existing systems like NetKampus).

### 4.4 Communications Interfaces

- All communication between the client (web browser) and the servers (AWS S3/CloudFront and EC2) will be encrypted using HTTPS (HTTP over SSL/TLS) to ensure data confidentiality and integrity.

### 5. Non-Functional Requirements

### 5.1 Performance

- **Response Time:** All pages and API responses should load within 3 seconds under normal network conditions.
- **Concurrency:** The system must be able to handle concurrent access from at least 100 users without significant degradation in performance.
- **Data Processing:** Reports and data exports should be generated within 10 seconds for typical data sets.

### 5.2 Security

- **Authentication & Authorization:** The system must enforce strict role-based access control (RBAC) to ensure users can only access data and perform actions permitted by their role.
- **Data Encryption:** All data transmission must be encrypted using SSL/TLS. Passwords must be securely hashed and salted before being stored in the database.
- **Vulnerability Protection:** The application must be protected against common web vulnerabilities, including but not limited to SQL Injection, Cross-Site Scripting (XSS), and Cross-Site Request Forgery (CSRF).

### 5.3 Reliability

- **Availability:** The application should have a target uptime of 99.5%, excluding scheduled maintenance.
- **Data Integrity:** The system must ensure that data is not corrupted or lost. Transactional integrity must be maintained for all database operations.
- **Backup and Recovery:** Regular, automated backups of the database must be performed to prevent data loss, with a clear recovery plan in place.

### 5.4 Usability

- **Learnability:** The user interface should be intuitive and easy to learn for users with basic computer skills, requiring minimal training.
- **Consistency:** A consistent design language, layout, and navigation should be used throughout the application to avoid user confusion.
- **Error Handling:** The system shall provide clear, user-friendly error messages and guidance on how to resolve issues.

### 5.5 Scalability

- **Architectural Design:** The application architecture must be designed to handle a gradual increase in the number of students, mentors, and the volume of data stored over several academic years.
    - **Stateless Backend:** The Spring Boot backend services shall be stateless, allowing for horizontal scaling by running multiple instances behind a load balancer.
    - **Database Scaling:** The PostgreSQL database must be configured with efficient indexing strategies. Connection pooling will be used to manage database connections effectively.
    - **Asynchronous Processing:** Long-running tasks, such as generating large reports, should be handled asynchronously to avoid blocking user requests.

### 5.6 Maintainability

- **Code Quality and Principles:** The source code must be well-documented, clean, and follow industry best practices and design principles to facilitate future updates and maintenance.
    - **Backend (Spring Boot):** The code should adhere to SOLID principles and a clear separation of concerns (e.g., Controller-Service-Repository layers).
    - **Frontend (React):** The code should follow a component-based architecture, with a clear state management strategy to handle application data.
    - **Modularity:** The application should be designed in a modular fashion, allowing individual features to be updated or replaced with minimal impact on other parts of the system.
    - **CI/CD:** A Continuous Integration/Continuous Deployment (CI/CD) pipeline should be established for automated testing and deployment, ensuring code quality and release stability.

### 5.7 Offline Support

- **Data Caching:** The PWA must cache essential application data and previously viewed student profiles on the user's device to allow for offline viewing.
- **Data Synchronization:** Data entered or modified offline must be queued locally and synced reliably with the server once a network connection is available. The user should be notified of the sync status.

### 5.8 Installability

- The application must be a PWA and should prompt users to install it on their home screen on supported devices (desktop and mobile) for easy, app-like access.

### 6. UI Description

This section outlines the page-by-page user interface for each role. Components mentioned will be from the Shadcn/ui library.

### 6.1 Common Pages

- **6.1.1 Role Selection Page (Landing Page)**
    - **Description:** The initial page a user sees, allowing them to select their role. Clicking an option will navigate the user to a dedicated login path.
    - **Components:**
        - `Grid` or `Flex container` holding three options.
        - `Card` 1: Titled "Student Login". Clicking this navigates to `/login/student`.
        - `Card` 2: Titled "Parent Login". Clicking this navigates to `/login/parent`.
        - `Card` 3: Titled "Faculty/Admin Login". Clicking this navigates to `/login/faculty`.
- **6.1.2 Login Page**
    - **Description:** A centered card on the screen for user authentication. The application will have distinct routes (`/login/student`, `/login/parent`, `/login/faculty`) for each user type.
    - **Components:**
        - `Card`: Main container for the login form.
        - `CardHeader`: Displays a static title corresponding to the route (e.g., "Student Login").
        - `CardContent`: Contains the form fields.
            - `Input` field for Username (or Register Number for students/parents).
            - `Input` field for Password (type="password").
        - `CardFooter`: Contains the `Button` for submitting the form ("Login").

### 6.2 Administrator UI

- **6.2.1 Admin Dashboard**
    - **Description:** The main landing page after login, providing a high-level overview and navigation.
    - **Components:**
        - `Header`: Displays the application name and a dropdown menu with user info and a "Logout" button.
        - `Sidebar`: Navigation links to "Dashboard", "User Management", "Student Management".
        - `Grid` of `Card` components displaying key metrics: Total Students, Total Mentors, Total HODs.
        - `Card` with "Quick Actions" containing buttons to "Create New User" and "Create Student Profile".
- **6.2.2 User Management Page**
    - **Description:** A page to manage all non-student user accounts (Administrators, HODs, and Mentors).
    - **Components:**
        - `Table`: Lists all users with columns for Full Name, Username, Role, Department, and Actions.
            - `DropdownMenu` in the Actions column with options to "Edit" or "Deactivate" user.
        - **Create/Edit User Interface (Dialog):**
            - **Trigger:**
                - A `Button` with the label "Create New User" will be positioned above the user table. Clicking this button will open the creation dialog.
                - The "Edit" option within the `DropdownMenu` in the user table's "Actions" column will open the same dialog, but pre-populated with the selected user's data.
            - **Dialog Component:**
                - `DialogContent`: A modal window that appears overlaid on the page.
                - `DialogHeader`:
                    - `DialogTitle`: The title will dynamically change. It will display "Create New User" when creating, and "Edit User: [User's Name]" when editing.
                    - `DialogDescription`: A brief instruction, e.g., "Fill in the details below to create or update a user account."
                - **Form Fields:**
                    - `Label` for "Full Name": Paired with an `Input` field for the user's full name.
                    - `Label` for "Username": Paired with an `Input` field for the login username. This field will be disabled when editing a user.
                    - `Label` for "Password": Paired with an `Input` of `type="password"`. When creating a user, this is a required field. When editing, it can be left blank if the password is not being changed. A sub-text will indicate this.
                    - `Label` for "Role": Paired with a `Select` component (dropdown).
                        - `SelectTrigger`: Shows the currently selected role.
                        - `SelectContent`: Contains the options: "Administrator", "HOD", "Mentor".
                    - `Label` for "Department": Paired with a `Select` component.
                        - `SelectContent`: Contains a list of all available departments (e.g., "Computer Science", "Mechanical Engineering"). This field is required if the selected role is "HOD" or "Mentor".
                - `DialogFooter`:
                    - `Button` with "Cancel" text: Closes the dialog without saving changes.
                    - `Button` with "Save" text: Submits the form to create or update the user.
- **6.2.3 Student Management Page**
    - **Description:** A page to create initial student profiles and view/manage all students, including their mentor assignments.
    - **Components:**
        - **Action Buttons Bar:** A container above the table holding key action buttons.
            - `Button` ("Create Student Profile"): Opens a dialog for creating a single student.
            - `Button` ("Bulk Edit Mentor Assignment"): This button is disabled by default and becomes active when one or more students are selected in the table below. It opens the bulk edit dialog.
        - `Dialog` (for Create Student): A form with `Input` fields for Student Name, Register Number, a `Select` dropdown for the student's **Program** (e.g., "B.E.", "M.B.A."), and a `Select` dropdown for their Branch/Department. The **Batch** (e.g., "2023-2027") will be auto-calculated based on the current year and the selected program's duration. Upon submission, it displays the auto-generated temporary password for the student.
        - `Table`: Lists all students with columns for:
            - A `Checkbox` in the header for "Select All" and in each row for individual selection.
            - Name, Register Number, Branch, Batch, Assigned Mentor, and **Actions**.
            - Includes search and filter capabilities with pagination.
            - **`DropdownMenu` in the Actions column (for single-student actions):**
                - "Edit Mentor Assignment": Opens the mentor modification dialog for an individual student.
                - "View Full Profile": Navigates to the student's detailed profile page.
        - **Edit Mentor Assignment Interface (Dialog for single student):**
            - **Trigger:** The "Edit Mentor Assignment" option in the student table's `DropdownMenu`.
            - **Dialog Component:**
                - `DialogContent`: The main container for the modal's content, which is a form.
                - `DialogHeader`:
                    - `DialogTitle`: "Edit Mentor for [Student Name]".
                    - `DialogDescription`: Displays the current assignment status, e.g., "Currently assigned to: [Mentor Name]" or "This student is currently unassigned."
                - **Form Fields:**
                    - `Label` for "New Mentor": Paired with a `Select` component.
                        - `SelectTrigger`: Shows the currently selected new mentor.
                        - `SelectContent`: Contains a list of all available mentors, with a special first option "-- Unassign --" to remove the current mentor.
                - `DialogFooter`:
                    - `Button` "Cancel".
                    - `Button` "Save Assignment".
        - **Bulk Edit Mentor Assignment Interface (Dialog for multiple students):**
            - **Trigger:** The "Bulk Edit Mentor Assignment" button.
            - **Dialog Component:**
                - `DialogContent`: The main container for the modal's content, which is a form.
                - `DialogHeader`:
                    - `DialogTitle`: "Bulk Edit Mentor Assignment".
                    - `DialogDescription`: Displays the number of students selected, e.g., "You are about to change the mentor for [X] selected students."
                - **Form Fields:**
                    - `Label` for "New Mentor": Paired with a `Select` component.
                        - `SelectTrigger`: Shows a placeholder. If the selected students all have the same mentor, it will show that mentor's name. If the selected students have different mentors, it will show a placeholder text like "-- Multiple Values --".
                        - `SelectContent`: Contains a list of all available mentors, with a special first option "-- Unassign --" to remove the current mentor.
                - `DialogFooter`:
                    - `Button` "Cancel".
                    - `Button` "Save Assignment".
- **6.2.4 Mentor Assignment Page**
    - **Description:** An interface to perform bulk assignment of unassigned students to a mentor.
    - **Components:**
        - Two-panel layout.
        - **Left Panel:** A `Card` containing a list of all unassigned students, with checkboxes next to each name.
        - **Right Panel:** A `Card` with a `Select` dropdown to choose a Mentor. Below it, a `Button` ("Assign Selected Students") to perform the assignment.

### 6.3 Mentor UI

- **6.3.1 Mentor Dashboard**
    - **Description:** The landing page showing the list of assigned mentees.
    - **Components:**
        - `Header` and `Sidebar` for navigation.
        - `Card` titled "My Mentees".
        - `Table`: Lists all assigned mentees with columns for Name, Register Number, and Branch. Each row is clickable to navigate to the student's detailed profile. Includes a search bar.
- **6.3.2 Student Profile Page**
    - **Description:** The main workspace for a mentor to view and update a specific student's data.
    - **Components:**
        - `Header`: Displays the Student's Name and Register Number.
        - `Tabs` component to switch between views:
            - **`Tab 1: General Profile`**: A read-only view of the student's onboarding and general profile data (Pages 1-4), with an "Edit" button for fields the mentor can update.
            - **`Tab 2: Semester Details`**: Contains all per-semester information.
                - `Select` dropdown at the top to choose the Academic Year and Semester.
                - `Accordion` component to organize the semester data:
                    - **`AccordionItem 1: Mentoring Activity (Page 5)`**: A form with `Input`, `Textarea`, and `Select` fields to capture the semester-specific details.
                    - **`AccordionItem 2: Mentoring Chart (Page 6)`**: A detailed form for logging time management and other activities.
                    - **`AccordionItem 3: Academic Performance (Page 7)`**: A `Table` listing subjects for the semester. A `Button` ("Add Subject") opens a `Dialog` to enter subject details and marks from various assessments.
                    - **`AccordionItem 4: Mentoring Sessions (Page 7)`**: A `Table` listing all logged sessions. A `Button` ("Log New Session") opens a `Dialog` with a form for the 10-point ratings and remarks.
                    - **`AccordionItem 5: Semester Review (Page 8)`**: A form with `Textarea` fields for the mentor's final review of the semester.
            - **`Tab 3: Program Summary`**: A view consolidating all semester data (Page 9), project details, and placement information.

### 6.4 Student UI

- **6.4.1 Profile Completion Page (First Login)**
    - **Description:** A multi-step form the student must complete after their first login.
    - **Components:**
        - A form wizard with steps for:
            - Changing their temporary password.
            - Filling in personal details (Pages 1-3).
            - Filling in parent/sibling details.
            - Uploading photos.
        - `Input`, `DatePicker`, `Select`, and file upload components will be used.
- **6.4.2 Student Dashboard / Profile View**
    - **Description:** A read-only view of their complete mentoring profile.
    - **Components:**
        - The same layout as the Mentor's "Student Profile Page" (`Tabs`, `Accordion`, etc.) but all form fields are disabled (read-only). This allows them to see all the data entered by their mentor.

### 7. API Endpoints Specification

(This section will be updated to reflect the new data structures, e.g., adding endpoints for `StudentGeneralProfile`, `SemesterMentoringActivity`, `SemesterReviews`)

### 8. Database Schema (PostgreSQL)

This section provides the updated SQL statements to create the database schema.

```
-- Programs Table (New)
CREATE TABLE Programs (
    program_id SERIAL PRIMARY KEY,
    program_name VARCHAR(255) UNIQUE NOT NULL, -- e.g., 'Bachelor of Engineering', 'MBA'
    duration_years INT NOT NULL -- e.g., 4, 2
);

-- Users Table: For authentication and roles
CREATE TABLE Users (
    user_id SERIAL PRIMARY KEY,
    username VARCHAR(255) UNIQUE NOT NULL,
    password_hash VARCHAR(255) NOT NULL,
    full_name VARCHAR(255),
    role VARCHAR(50) NOT NULL CHECK (role IN ('Administrator', 'HOD', 'Mentor', 'Student', 'Parent')),
    department VARCHAR(255), -- Department for HOD and Mentor roles
    created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP
);

-- Students Table (Core, mostly static info)
CREATE TABLE Students (
    student_id SERIAL PRIMARY KEY,
    user_id INT UNIQUE REFERENCES Users(user_id) ON DELETE SET NULL,
    program_id INT REFERENCES Programs(program_id), -- Link to the program
    register_number VARCHAR(100) UNIQUE NOT NULL,
    name VARCHAR(255) NOT NULL,
    batch VARCHAR(50), -- e.g., '2023-2027', can be auto-calculated
    branch VARCHAR(100),
    section CHAR(1),
    date_of_birth DATE,
    sex VARCHAR(20),
    -- ... other core personal details from pages 1-3 ...
    address_final TEXT, -- For address at time of leaving
    photo_admission_url VARCHAR(255),
    photo_leaving_url VARCHAR(255)
);

-- Student General Profile (One-time data from Page 4)
CREATE TABLE StudentGeneralProfile (
    profile_id SERIAL PRIMARY KEY,
    student_id INT UNIQUE NOT NULL REFERENCES Students(student_id) ON DELETE CASCADE,
    long_term_ambition TEXT,
    career_option VARCHAR(100), -- 'Higher Studies', 'Job', 'Entrepreneur'
    swot_strength_academic TEXT,
    swot_strength_general TEXT,
    swot_weakness_academic TEXT,
    swot_weakness_general TEXT,
    living_style_details TEXT,
    last_updated_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP
);

-- Parents Table, Siblings Table, Education History Table (remain largely the same)
-- ...

-- Academic Performance Table (Per Semester)
CREATE TABLE AcademicPerformance (
    performance_id SERIAL PRIMARY KEY,
    student_id INT NOT NULL REFERENCES Students(student_id) ON DELETE CASCADE,
    year INT NOT NULL,
    semester INT NOT NULL,
    gpa NUMERIC(4, 2),
    cgpa NUMERIC(4, 2),
    attendance_percentage NUMERIC(5, 2),
    number_of_arrears INT,
    UNIQUE(student_id, year, semester)
);

-- Semester Mentoring Activity (Per Semester data from Page 5)
CREATE TABLE SemesterMentoringActivity (
    activity_id SERIAL PRIMARY KEY,
    student_id INT NOT NULL REFERENCES Students(student_id) ON DELETE CASCADE,
    year INT NOT NULL,
    semester INT NOT NULL,
    field_of_interest TEXT,
    favourite_subject TEXT,
    hardest_subject TEXT,
    library_visit_frequency VARCHAR(100),
    -- ... other fields from page 5 ...
    UNIQUE(student_id, year, semester)
);

-- Mentoring Chart Table (Per Semester data from Page 6 - remains the same)
CREATE TABLE MentoringCharts (
    chart_id SERIAL PRIMARY KEY,
    student_id INT NOT NULL REFERENCES Students(student_id) ON DELETE CASCADE,
    year INT NOT NULL,
    semester INT NOT NULL,
    -- ... fields for time management, ratings etc. ...
    class_routine_ratings JSONB,
    monthly_test_ratings JSONB,
    university_exam_prep JSONB,
    UNIQUE(student_id, year, semester)
);

-- Mentoring Sessions Table (Multiple per semester, from Page 7)
CREATE TABLE MentoringSessions (
    session_id SERIAL PRIMARY KEY,
    student_id INT NOT NULL REFERENCES Students(student_id) ON DELETE CASCADE,
    mentor_id INT NOT NULL REFERENCES Users(user_id),
    year INT NOT NULL,
    semester INT NOT NULL,
    session_date DATE NOT NULL,
    rating_as_person INT,
    -- ... other rating fields ...
    mentor_remarks TEXT
);

-- Semester Reviews Table (One per semester, from Page 8)
CREATE TABLE SemesterReviews (
    review_id SERIAL PRIMARY KEY,
    student_id INT NOT NULL REFERENCES Students(student_id) ON DELETE CASCADE,
    mentor_id INT NOT NULL REFERENCES Users(user_id),
    year INT NOT NULL,
    semester INT NOT NULL,
    overall_remarks TEXT,
    disciplinary_issues TEXT,
    follow_up_required BOOLEAN DEFAULT FALSE,
    UNIQUE(student_id, year, semester)
);

-- Projects Table, Placements Table (remain largely the same)
-- ...

```


