package ru.petrelevich;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class SqlAppl {
    public static void main(String[] args) throws SQLException {
        System.out.println("application is starting...");
        new SqlAppl().start();
        System.out.println("application finished");
    }

    private void start() throws SQLException {
        try(Connection connection = makeConnection()) {
            System.out.println(connection.isValid(1));
        }
    }

    private Connection makeConnection() throws SQLException {
        String url = "jdbc:postgresql://localhost/postgres";
        Properties props = new Properties();
        props.setProperty("user","postgres");
        props.setProperty("password","password");
        props.setProperty("ssl","false");
		Statement st = null;
        ResultSet rs = null;
        try{
            Class.forName("org.postgresql.Driver");
            System.out.println("connect");
            } catch (ClassNotFoundException cnfe){
              System.out.println("Could not find the JDBC driver!");
              System.exit(1);
            }
        Connection conn = null;
        try {
            //database location, database user, database password
            conn = DriverManager.getConnection("jdbc:postgresql:POS_DB","postgres", "password");
            st = conn.createStatement();
            String qs = "CREATE TABLE IF NOT EXISTS user(user_id SERIAL NOT NULL PRIMARY KEY,username varchar(225) NOT NULL UNIQUE,password varchar(225),islogged varchar(10))";
            String qs1 = "SELECT * FROM test";
        rs = st.executeQuery(qs);

            System.out.println("connect");
             } catch (SQLException sqle) {
               System.out.println("Could not connect");
               System.exit(1);
             }
        return DriverManager.getConnection(url, props);
    }
}
