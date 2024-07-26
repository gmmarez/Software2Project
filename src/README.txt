Western Governors University C195 Performance Assessment

Gabriel Marez
gmarez@wgu.edu
(505) 235-2408
student application version,
July 23, 2024

Purpose: Create a functional scheduling application in the setting of a doctor's office. This will serve a portal for users
to be able to verify login and manipulate customer records and appointments to their corresponding Contacts. Users will
also be able to view data of all Appointments according to Contacts, Appointments by Customers, and count of Types of
Appointments in table form. The application will also be able to notify the user if an upcoming appointment is scheduled,
change login screen language depending on user location, keep record of all login attempts, and provide input validation.


IntelliJ IDEA 2023.2.2 (Community Edition), Java SE 17.0.1), JavaFX-SDK-17.0.1
MySQL Workbench 8.0.27, mysql-connector-java-8.0.25

How to run the program:

Login Screen: In order to log in to the application, you must need to input and validate using User's credentials and selecting
'Submit'. Credentials are case-sensitive. To close the entire application, the User must select 'Close'.

Main Menu: A User can either choose from the following options: Customers, Appointments, and Reports. The user can
also choose to log out of the application and return to the Login screen by selecting 'Logout'.

Customers Menu: A User upon accessing the Customers menu screen will be able to view all current Customers in table format.
In order to add a customer, the User must select the 'Add' button which will bring them to the 'Add Customer' screen. If a User
wants to edit an existing customer, they must first select the customer then select 'Edit'. If a User wants to delete an
existing customer, they must select that customer and press 'Delete'. This will ask the User for confirmation and hence
delete the customer and their associated appointments. To return to the 'Main Menu' the User must select 'Back'.

Add Customer: The User must complete all input fields for a new customer. After completion, press 'Add' to add that customer
to the database. If the User wishes to return back to the Customers menu screen they may select 'Back'. Also, if the User wished to
clear all fields that may have been filled out, they can select 'Clear'.

Edit Customer: As the User gets to the 'Edit Customer' screen, the already selected customer's data will be populated in the
screen. The User may make any changes they wish to that customer. After changes have been made, the User will need to select
'Save' and return them to the 'Customers Menu'. If the User wishes to return back to the Customers menu screen they may select 'Back'.

Appointments Menu: A User upon accessing the Appointments menu screen will be able to view all current Appointments in table format.
The User may also navigate to see all appointments by selecting the 'All Appointments' radio button. The User can see all
the upcoming months appointments be selecting 'Monthly Appointments' and all next week's appointments by selecting the
'Weekly Appointments' radio button. In order to add an appointment, the User must select the 'Add' button which will bring them
to the 'Add Appointment' screen. If a User wants to edit an existing appointment, they must first select that appointment
then select 'Edit'. If a User wants to delete an existing appointment, they must select that appointment and press 'Delete'.
This will ask the User for confirmation and hence delete the appointment. To return to the 'Main Menu' the User must select 'Back'.

Add Appointment: The User must complete all input fields for a new appointment. After completion, press 'Add' to add that appointment
to the database. If the User wishes to return back to the Appointments menu screen they may select 'Back'. Also, if the User wished to
clear all fields that may have been filled out, they can select 'Clear'.

Edit Appointment: As the User gets to the 'Edit Appointment' screen, the already selected appointment's data will be populated in the
screen. The User may make any changes they wish to that appointment. After changes have been made, the User will need to select
'Save' and return them to the 'Appointments Menu'. If the User wishes to return back to the Appointments menu screen they may select 'Back'.

Reports: In the 'Reports' screen the User will be able to view three seperate tables outlined in requirements A3f.
These are Appointments according to Contacts, Appointments by Customers, and count of Types of Appointments.


Addition Reports Description: The three tables in the 'Reports' screen are Appointments according to Contacts,
Appointments by Customers, and count of Types of Appointments. These provide insight on what appointments are coming
from both specific Contacts and Customers. The last table will show the number of each Type of Appointment created.
