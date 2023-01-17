package se.iths.persistency.util;

import java.sql.*;

public class ConnectToDB {

    private static final String JDBC_CONNECTION = "jdbc:mysql://localhost:3306/Chinook";
    private static final String JDBC_USER = "iths";
    private static final String JDBC_PASSWORD = "iths";


    private ConnectToDB() {

    }

    public static Connection getConnection() throws SQLException{
        Connection connection = null;
        Configuration config = new Configuration();
        connection = DriverManager.getConnection(config.getDbUrl(), config.getDbUser(), config.getDbPswrd());

        return connection;
    }

    public static void closeConnection(Connection connection) throws SQLException {
        connection.close();
    }

    public static void closeStatement(Statement statement) throws SQLException {
        statement.close();
    }

    public static void closePreparedStatement(PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.close();
    }

    public static void closeResultSet(ResultSet rs) throws SQLException {
        rs.close();
    }





}
