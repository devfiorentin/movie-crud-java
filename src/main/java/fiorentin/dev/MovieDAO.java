package fiorentin.dev;

import java.sql.*;
import java.util.Scanner;

public class MovieDAO {

    // LISTAR
    public static void listMovies() {
        String sql = "SELECT * FROM movies";

        try (Connection conn = DatabaseConfig.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                System.out.println(
                        rs.getInt("id") + " | " +
                                rs.getString("title") + " | " +
                                rs.getInt("year") + " | " +
                                rs.getString("director")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // INSERIR
    public static void insertMovie(Scanner scanner) {

        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(
                     "INSERT INTO movies (title, year, director) VALUES (?, ?, ?)")) {

            System.out.print("Title: ");
            String title = scanner.nextLine();

            System.out.print("Year: ");
            int year = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Director: ");
            String director = scanner.nextLine();

            stmt.setString(1, title);
            stmt.setInt(2, year);
            stmt.setString(3, director);

            stmt.executeUpdate();

            System.out.println("Movie inserted!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // DELETE
    public static void deleteMovie(Scanner scanner) {

        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(
                     "DELETE FROM movies WHERE id = ?")) {

            System.out.print("ID to delete: ");
            int id = scanner.nextInt();

            stmt.setInt(1, id);

            int rows = stmt.executeUpdate();

            System.out.println(rows > 0 ? "Deleted!" : "Not found.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}