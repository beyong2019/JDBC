package com.sdnu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * @author Beyong
 * @Description JdbcTest3
 * @date 2021/07/18 17:09
 */
public class JdbcTest3 {
    public static void main(String[] args) {
        Locale locale = Locale.getDefault();
        ResourceBundle bundle = ResourceBundle.getBundle("jdbc", locale);
        String driver = bundle.getString("driver");
        String url = bundle.getString("url");
        String user = bundle.getString("user");
        String password = bundle.getString("password");

        Connection conn = null;
        Statement stmt = null;
        try{

            //DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            Class.forName(driver);

             conn = DriverManager.getConnection(url, user, password);

             stmt = conn.createStatement();

            String sql = "INSERT INTO mytable2 (id, name) VALUES (21, 'wang')";
            int count = stmt.executeUpdate(sql);
            System.out.println(count == 1 ? "delete succeed" : "delete failed");
        }catch(SQLException e) {
            e.printStackTrace();
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}
