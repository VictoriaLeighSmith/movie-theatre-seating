public class Theatre {

    private int rows;
    private int seatsPerRow;
    private boolean[][] seats;

    public Theatre(int rows, int seatsPerRow) {
        this.rows = rows;
        this.seatsPerRow = seatsPerRow;
        this.seats = new boolean[rows][seatsPerRow];
    }

    public void displaySeats() {
        // Declare variables to calculate spacing needed to make output dynamic
        int columnWidth = 4;
        int rowLabelWidth = 2;
        int chartWidth = rowLabelWidth + (seatsPerRow * columnWidth);
        String screenLabel = "SCREEN";
        int labelPadding = (chartWidth - screenLabel.length()) / 2;

        System.out.println();
        System.out.println(" ".repeat(labelPadding) + "SCREEN");
        System.out.println("-".repeat(chartWidth));
        System.out.println();

        System.out.printf("%-2s", "");

        // Iterate through columns to display seat number
        for (int i = 0; i < seats[0].length; i++) {
            System.out.printf("%4d", (i + 1));
        }

        System.out.println();
        System.out.println();

        for (int i = 0; i < seats.length; i++) {
            // Iterate through rows and display row letter based on index
            char rowLetter = (char) ('A' + i);
            System.out.print(" " + rowLetter);

            // Iterate through each seat per row and display corresponding symbol for taken
            // seat/available seat
            for (int j = 0; j < seats[i].length; j++) {
                if (!seats[i][j]) {
                    System.out.printf("%4s", "O");
                } else {
                    System.out.printf("%4s", "X");
                }
            }

            System.out.println();
        }
    }

    public boolean reserveSeat(char rowLetter, int seatNumber) {
        boolean seatReserved = false;

        // Convert the row letter and seat number back to the index number
        int rowIndex = rowLetter - 'A';
        int seatIndex = seatNumber - 1;

        if (!seats[rowIndex][seatIndex]) {
            seats[rowIndex][seatIndex] = true;
            seatReserved = true;
        }

        return seatReserved;
    }

    public boolean cancelReservation(char rowLetter, int seatNumber) {
        boolean cancelledReservation = false;

        // Convert the row letter and seat number back to the index number
        int rowIndex = rowLetter - 'A';
        int seatIndex = seatNumber - 1;

        if (seats[rowIndex][seatIndex]) {
            seats[rowIndex][seatIndex] = false;
            cancelledReservation = true;
        }

        return cancelledReservation;
    }

    // Method to find next available seat
    public String findAvailableSeat() {
        for (int i = 0; i < seats.length; i++) {
            for (int j = 0; j < seats[i].length; j++) {
                if (!seats[i][j]) {
                    char rowLetter = (char) ('A' + i);
                    int seatNumber = j + 1;

                    return String.format("%c%d", rowLetter, seatNumber);
                }
            }
        }

        return null;
    }

    // Helper method to check for valid seat
    public boolean isValidSeat(char rowLetter, int seatNumber) {
        boolean validSeat = false;

        // Convert the row letter and seat number back to the index number
        int rowIndex = rowLetter - 'A';
        int seatIndex = seatNumber - 1;

        if (rowIndex >= 0 && rowIndex < rows && seatIndex >= 0 && seatIndex < seatsPerRow) {
            validSeat = true;
        }

        return validSeat;
    }
}
