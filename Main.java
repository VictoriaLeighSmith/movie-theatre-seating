import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Create scanner object
        Scanner scanner = new Scanner(System.in);

        // Create theatre object
        Theatre theatre = new Theatre(5, 9);

        // Declare boolean value to use in menu loop
        boolean displayMenu = true;

        // Display menu
        while (displayMenu) {
            System.out.println();
            System.out.println("MOVIE THEATRE");
            System.out.println();
            System.out.println("1. Display Seats");
            System.out.println("2. Reserve Seat");
            System.out.println("3. Cancel Reservation");
            System.out.println("4. Exit");
            System.out.println();
            System.out.print("Please enter your choice (1-4): ");

            int userChoice = scanner.nextInt();
            scanner.nextLine();

            switch (userChoice) {
                case 1:
                    theatre.displaySeats();
                    break;
                case 2:
                    System.out.print("What row?: ");
                    char rowLetter = scanner.next().charAt(0);

                    System.out.print("What seat?: ");
                    int seatNumber = scanner.nextInt();

                    if (theatre.reserveSeat(rowLetter, seatNumber)) {
                        System.out.println("Seat booked successfully!");
                    } else {
                        System.out.println("Seat is already reserved.");
                    }

                    break;
                case 3:
                    theatre.cancelReservation();
                    break;
                case 4:
                    displayMenu = false;
                    break;
                default:
                    System.out.println("Invalid choice.");
            }

        }

        scanner.close();
    }
}
