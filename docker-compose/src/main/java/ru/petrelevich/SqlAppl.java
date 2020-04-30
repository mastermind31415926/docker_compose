package ru.petrelevich;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
 
public class SqlAppl 
{
    public static void main(String[] args) {
        SqlAppl m = new SqlAppl();
        m.testDatabase();
    }
 
    private void testDatabase() {
        try {
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://localhost:5432/postgres";
            String login = "postgres";
            String password = "passwor11111d";
            Connection con = DriverManager.getConnection(url, login, password);
            try {
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("select tables from information_schema.tables");
                while (rs.next()) {
                    String str = rs.getString("table_name") + ":" + rs.getString(2);
                    System.out.println("table_name:" + str);
                }
                rs.close();
                stmt.close();
            } finally {
                con.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
