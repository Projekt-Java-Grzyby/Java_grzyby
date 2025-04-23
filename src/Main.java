import java.sql.*;
import java.util.Properties;

public class Main {
    public static void main(String[] args) {
        //ZMienic ścieżkę na swoją + zmienić ścieżkę w bazie danych
        String url = "jdbc:h2:file:D:/Java_grzyby/src/database/grzyby";
        Properties prop = new Properties();
        prop.setProperty("user", "");
        prop.setProperty("password", "");

        try (Connection connection = DriverManager.getConnection(url, prop)) {
            System.out.println("Database connection: " + connection.isValid(0));

            // SELECT
            try (PreparedStatement preparedStatement1 = connection.prepareStatement("SELECT * FROM grzyb WHERE id > ?")) {
                preparedStatement1.setInt(1, 0);
                try (ResultSet resultSet = preparedStatement1.executeQuery()) {
                    while (resultSet.next()) {
                        System.out.println(resultSet.getInt("id") + " " + resultSet.getString("nazwa") + " ");
                    }
                }
            }

//            // INSERT
//            try (PreparedStatement preparedStatement2 = connection.prepareStatement("INSERT INTO grzyb (nazwa, nazwa_powszechna, opis) VALUES (?, ?)");) {
//                preparedStatement2.setString(1, "Borowik Szlachetny");
//                preparedStatement2.setString(2, "Prawdziwek");
//                preparedStatement2.setString(3, "To grzybek");
//                int rowsInserted = preparedStatement2.executeUpdate();
//                System.out.println("Number of rows inserted: " + rowsInserted);
//            }
//
//            // UPDATE
//            try (PreparedStatement preparedStatement3 = connection.prepareStatement("UPDATE grzyb SET nazwa_powszechna = ? WHERE id = ?")) {
//                preparedStatement3.setString(1, "Prawdziwek");
//                preparedStatement3.setInt(2, 14);
//                int rowsUpdated = preparedStatement3.executeUpdate();
//                System.out.println("Number of rows updated: " + rowsUpdated);
//            }
//
//            // DELETE
//            try (PreparedStatement preparedStatement4 = connection.prepareStatement("DELETE FROM grzyb WHERE id > ?")) {
//                preparedStatement4.setInt(1, 9);
//                int rowsDeleted = preparedStatement4.executeUpdate();
//                System.out.println("Number of rows deleted: " + rowsDeleted);
//            }

            catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}