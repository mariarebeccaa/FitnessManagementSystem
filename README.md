# 🏋️ Fitness Management System

## 1. System Overview

This project is a **console-based Java application** designed to manage a fitness center.  
The system handles clients, trainers, fitness classes, payments, and reservations.  
It allows users (e.g., receptionists or admins) to interactively manage gym operations in real-time.

---

## 2. Supported Actions (Functionalities)

The system allows the following **main actions**:

1. **Add a new client** with subscription and initial payment.
2. **Add a new trainer** with name, contact info, and specialty.
3. **Create a fitness class**, based on trainer availability at a specific date and time.
4. **Reserve a spot** for a client in a fitness class.
5. **Cancel a reservation** for a client.
6. **List all fitness classes**, sorted by date and time.
7. **Show all reservations** made by a specific client.
8. **Show all payments** made by a specific client.
9. **List all active clients**, based on valid subscriptions.
10. **Renew a client’s subscription**, extending validity and registering a new payment.
11. **Calculate and display total payments** made by a client.

---

## 3. Object Types Used in the System

The system makes use of the following **key object types**:

- `Client` – Represents a gym client with personal details, subscription, reservations, and payments.
- `Trainer` – Represents a fitness trainer with a specialty and personal info.
- `FitnessClass` – Represents a scheduled class with a name, date/time, and assigned trainer.
- `Reservation` – Represents a client's booking for a fitness class.
- `Subscription` – Represents the type, price, and validity period of a client’s gym membership.
- `Payment` – Represents a payment transaction made by a client, including the amount and date.
- `FitnessService` – A service class that contains the logic for managing clients, trainers, classes, payments, and reservations.
- `Main` – The entry point of the application, with a text-based menu interface for user interaction.

---
