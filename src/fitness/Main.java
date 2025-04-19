package fitness;// Stage 1 - Java Application for a Fitness System


import fitness.models.*;
import fitness.service.FitnessService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        FitnessService service = new FitnessService();
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Add client");
            System.out.println("2. Add trainer");
            System.out.println("3. Add fitness class");
            System.out.println("4. Reserve spot");
            System.out.println("5. Cancel reservation");
            System.out.println("6. Show sorted fitness classes");
            System.out.println("7. Show client reservations");
            System.out.println("8. Show client payments");
            System.out.println("9. List active clients");
            System.out.println("10. Renew client subscription");
            System.out.println("11. Show client total payments");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");
            int opt = Integer.parseInt(scanner.nextLine());

            switch (opt) {
                case 1:
                    System.out.print("Client name: ");
                    String name = scanner.nextLine();
                    System.out.print("Email: ");
                    String email = scanner.nextLine();
                    System.out.print("CNP: ");
                    String cnp = scanner.nextLine();
                    System.out.print("Subscription type: ");
                    String type = scanner.nextLine();
                    System.out.print("Price: ");
                    double price = Double.parseDouble(scanner.nextLine());
                    System.out.print("Validity (days): ");
                    int days = Integer.parseInt(scanner.nextLine());
                    Client client = new Client(name, email, cnp, new Subscription(type, price, days));
                    service.registerClient(client);
                    client.addPayment(new Payment(price, LocalDate.now()));
                    break;
                case 2:
                    System.out.print("Trainer name: ");
                    String trainerName = scanner.nextLine();
                    System.out.print("Email: ");
                    String trainerEmail = scanner.nextLine();
                    System.out.print("CNP: ");
                    String trainerCnp = scanner.nextLine();
                    System.out.print("Specialty: ");
                    String specialty = scanner.nextLine();
                    Trainer trainer = new Trainer(trainerName, trainerEmail, trainerCnp, specialty);
                    service.registerTrainer(trainer);
                    break;
                case 3:
                    System.out.print("Enter date and time for the class (yyyy-MM-dd HH:mm): ");
                    LocalDateTime classDateTime = LocalDateTime.parse(scanner.nextLine(), formatter);

                    List<Trainer> availableTrainers = service.getAvailableTrainers(classDateTime);
                    if (availableTrainers.isEmpty()) {
                        System.out.println("No trainers available at this time!");
                        break;
                    }

                    System.out.println("Available trainers:");
                    for (int i = 0; i < availableTrainers.size(); i++) {
                        System.out.println((i + 1) + ". " + availableTrainers.get(i).getDetails());
                    }

                    System.out.print("Choose a trainer by number: ");
                    int trainerIndex = Integer.parseInt(scanner.nextLine()) - 1;
                    if (trainerIndex < 0 || trainerIndex >= availableTrainers.size()) {
                        System.out.println("Invalid trainer choice!");
                        break;
                    }
                    Trainer chosenTrainer = availableTrainers.get(trainerIndex);

                    System.out.print("Class name: ");
                    String className = scanner.nextLine();

                    FitnessClass fitnessClass = new FitnessClass(className, classDateTime, chosenTrainer);
                    service.createFitnessClass(fitnessClass);
                    System.out.println("Class added successfully!");
                    break;

                case 4:
                    System.out.print("Client name: ");
                    String clientName = scanner.nextLine();
                    Client clientToReserve = service.getClientByName(clientName);
                    if (clientToReserve == null) {
                        System.out.println("Client does not exist!");
                        break;
                    }
                    System.out.print("Class name: ");
                    String classToReserve = scanner.nextLine();
                    FitnessClass classFound = service.getFitnessClassByName(classToReserve);
                    if (classFound == null) {
                        System.out.println("Class does not exist!");
                        break;
                    }
                    service.reserveSpot(clientToReserve, classFound);
                    break;
                case 5:
                    System.out.print("Client name: ");
                    String clientCancel = scanner.nextLine();
                    Client clientToCancel = service.getClientByName(clientCancel);
                    System.out.print("Class name: ");
                    String classCancel = scanner.nextLine();
                    FitnessClass classToCancel = service.getFitnessClassByName(classCancel);
                    if (clientToCancel != null && classToCancel != null)
                        service.cancelReservation(clientToCancel, classToCancel);
                    else
                        System.out.println("Invalid client or class!");
                    break;
                case 6:
                    service.listSortedFitnessClasses();
                    break;
                case 7:
                    System.out.print("Client name: ");
                    Client clientRes = service.getClientByName(scanner.nextLine());
                    if (clientRes != null)
                        service.showReservations(clientRes);
                    break;
                case 8:
                    System.out.print("Client name: ");
                    Client clientPay = service.getClientByName(scanner.nextLine());
                    if (clientPay != null)
                        service.showPayments(clientPay);
                    break;
                case 9:
                    service.listActiveClients();
                    break;
                case 10:
                    System.out.print("Client name: ");
                    String clientRenewName = scanner.nextLine();
                    Client clientToRenew = service.getClientByName(clientRenewName);
                    System.out.print("Additional days to extend: ");
                    int extraDays = Integer.parseInt(scanner.nextLine());
                    System.out.print("Payment amount for renewal: ");
                    double renewAmount = Double.parseDouble(scanner.nextLine());

                    service.renewSubscription(clientToRenew, extraDays, renewAmount);
                    break;

                case 11:
                    System.out.print("Client name: ");
                    Client clientToCheck = service.getClientByName(scanner.nextLine());
                    if (clientToCheck != null) {
                        service.calculateTotalPayments(clientToCheck);
                    } else {
                        System.out.println("Client not found.");
                    }
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid option!");
            }
        }
    }
}
