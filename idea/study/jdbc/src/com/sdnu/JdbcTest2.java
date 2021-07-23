package com.sdnu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import static java.lang.Class.forName;

/**
 * @author Beyong
 * @Description JdbcTest2
 * @date 2021/07/18 15:54
 */
public class JdbcTest2 {
    public static void main(String[] args) {
        try{

            //DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            Class.forName("com.mysql.jdbc.Driver");

            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase?useUnicode=true&characterEncoding=utf-8&zeroDateTimeBehavior=convertToNull&allowMultiQueries=true&serverTimezone=Asia/Shanghai", "root", "WGF720130601");

            Statement stmt = conn.createStatement();

            String sql = "DELETE FROM mytable2 WHERE id=12";
            int count = stmt.executeUpdate(sql);
            System.out.println(count == 1 ? "delete succeed" : "delete failed");
        }catch(SQLException e) {
            e.printStackTrace();
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}
