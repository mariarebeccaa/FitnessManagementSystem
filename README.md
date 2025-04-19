🏋️ Fitness Management System – README
1. System Overview
This project is a console-based Java application designed to manage a fitness center. The system handles clients, trainers, fitness classes, payments, and reservations. It allows users (e.g., receptionists or admins) to interactively manage gym operations in real-time.

2. Supported Actions (Minimum 10)
The system allows the following main actions/interactions:

Add a new client with subscription and initial payment.

Add a new trainer with name, contact info, and specialty.

Create a fitness class, based on trainer availability at a specific date and time.

Reserve a spot for a client in a fitness class.

Cancel a reservation for a client.

List all fitness classes, sorted by date and time.

Show all reservations made by a specific client.

Show all payments made by a specific client.

List all active clients, based on valid subscriptions.

Renew a client’s subscription, extending validity and registering a new payment.

Calculate and display total payments made by a client.

3. Main Object Types (Minimum 8)
The system makes use of the following key object types (Java classes):

Client – Represents a gym client with personal details, subscription, reservations, and payments.

Trainer – Represents a fitness trainer with a specialty and personal info.

FitnessClass – Represents a scheduled class with a name, date/time, and assigned trainer.

Reservation – Represents a client's booking for a fitness class.

Subscription – Represents the type, price, and validity period of a client’s gym membership.

Payment – Represents a payment transaction made by a client, including the amount and date.

FitnessService – A service class that contains the logic for managing clients, trainers, classes, payments, and reservations.

Main – The entry point of the application, with a text-based menu interface for user interaction.
