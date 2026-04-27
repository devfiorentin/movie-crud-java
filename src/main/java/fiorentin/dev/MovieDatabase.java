package fiorentin.dev;

import java.util.Scanner;

public class MovieDatabase {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            System.out.println("\n=== MOVIE SYSTEM ===");
            System.out.println("1 - List movies");
            System.out.println("2 - Insert movie");
            System.out.println("3 - Delete movie");
            System.out.println("0 - Exit");
            System.out.print("Choose: ");

            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1 -> MovieDAO.listMovies();
                case 2 -> MovieDAO.insertMovie(scanner);
                case 3 -> MovieDAO.deleteMovie(scanner);
                case 0 -> System.out.println("Bye!");
                default -> System.out.println("Invalid option");
            }

        } while (option != 0);

        scanner.close();
    }
}