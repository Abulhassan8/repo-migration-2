import java.sql.*;


public class ConnectDB {
    public static void main(String[] args){
        String url = "jdbc:mysql://localhost:3306/IDM";
        String username = "root";
        String password = "root";

        Connection con = null;
        try {
            con = DriverManager.getConnection(url, username, password);

            if (con != null){
                System.out.println("Connected to mysql successfully");
                String statement = "SELECT * FROM messages order by date_queued ASC LIMIT 1;";
                PreparedStatement preparedStatement = con.prepareStatement(statement);
                boolean result = preparedStatement.execute();
                ResultSet resultSet = preparedStatement.getResultSet();
                while (resultSet.next()){
                    System.out.println(resultSet.getString("message_id"));
                }
            }
        } catch (SQLException e){
            System.out.println("Error occured while connecting to DB : ");
            e.printStackTrace();
        } finally {
            try {
                if (con != null) con.close();
            } catch (SQLException e){
                System.out.println("Error while closing connection");
                e.printStackTrace();
            }
        }
    }
}
