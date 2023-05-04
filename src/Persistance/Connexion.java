package Persistance;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connexion {
    private final static String driverClassName="com.mysql.jdbc.Driver";
    private final static String connectionUrl="jdbc:mysql://localhost:3306/sys?autoReconnect=true&useSSL=false";
    private final static String dbUser="root";
    private final static String dbPwd="YasserEttm2021@";

    public static Connection getConnection() {
        Connection con = null;
        try {
            Class.forName(driverClassName);
            try {
                con = DriverManager.getConnection(connectionUrl, dbUser, dbPwd);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        return con;
    }
}
