import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Theatre theatre = new Theatre(5, 9);

        boolean displayMenu = true;

        // Display menu
        while (displayMenu) {
            System.out.println();
            System.out.println("MOVIE THEATRE RESERVATIONS");
            System.out.println("--------------------------");
            System.out.println();
            System.out.println("1. Display Seats");
            System.out.println("2. Reserve Seat");
            System.out.println("3. Cancel Reservation");
            System.out.println("4. Exit");
            System.out.println();
            System.out.print("Please enter your choice (1-4): ");

            if (!scanner.hasNextInt()) {
                System.out.println("Invalid choice. Please enter a number from 1-4.");
                scanner.nextLine();
                continue;
            }

            int userChoice = scanner.nextInt();
            scanner.nextLine();

            switch (userChoice) {
                case 1:
                    theatre.displaySeats();
                    break;
                case 2:
                    System.out.print("Select row: ");
                    char rowLetter = Character.toUpperCase(scanner.next().charAt(0));
                    scanner.nextLine();

                    System.out.print("Select seat: ");

                    if (!scanner.hasNextInt()) {
                        System.out.println("Invalid seat number.");
                        scanner.nextLine();
                        theatre.displaySeats();
                        break;
                    }

                    int seatNumber = scanner.nextInt();
                    scanner.nextLine();

                    if (!theatre.isValidSeat(rowLetter, seatNumber)) {
                        System.out.println("Invalid seat selection.");
                    } else if (theatre.reserveSeat(rowLetter, seatNumber)) {
                        System.out.println("Seat booked successfully!");
                    } else {
                        String suggestedSeat = theatre.findAvailableSeat();

                        if (suggestedSeat != null) {
                            System.out.printf("Seat is already reserved. Suggested seat: %s%n",
                                    suggestedSeat);
                        } else {
                            System.out.println("Seat is already reserved. No other seats are available.");
                        }
                    }

                    theatre.displaySeats();
                    break;
                case 3:
                    System.out.print("Reserved row: ");
                    char cancelRowLetter = Character.toUpperCase(scanner.next().charAt(0));
                    scanner.nextLine();

                    System.out.print("Reserved seat: ");

                    if (!scanner.hasNextInt()) {
                        System.out.println("Invalid seat number.");
                        scanner.nextLine();
                        theatre.displaySeats();
                        break;
                    }

                    int cancelSeatNumber = scanner.nextInt();
                    scanner.nextLine();

                    if (!theatre.isValidSeat(cancelRowLetter, cancelSeatNumber)) {
                        System.out.println("Invalid seat selection.");
                    } else if (theatre.cancelReservation(cancelRowLetter, cancelSeatNumber)) {
                        System.out.println("Seat reservation cancelled successfully!");
                    } else {
                        System.out.println("Reservation not found.");
                    }

                    theatre.displaySeats();
                    break;
                case 4:
                    displayMenu = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number from 1-4.");
            }

        }

        scanner.close();
    }
}
