package com.sdnu;
import java.sql.*;


/**
 * @author Beyong
 * @Description JDBC编程
 * @date 2021/07/17 22:07
 */
public class JdbcTest {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try{

            //DriverManager.registerDriver(new com.mysql.jdbc.Driver());

            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase?useUnicode=true&characterEncoding=utf-8&zeroDateTimeBehavior=convertToNull&allowMultiQueries=true&serverTimezone=Asia/Shanghai", "root", "WGF720130601");

            stmt = conn.createStatement();

            String sql = "DELETE FROM mytable2 WHERE id=13";
            int count = stmt.executeUpdate(sql);
            System.out.println(count == 1 ? "delete succeed" : "delete failed");
        }catch(SQLException e) {
            e.printStackTrace();
        }finally{

            if(stmt != null){
                try{
                    stmt.close();
                } catch(SQLException e) {
                    e.printStackTrace();
                }
            }
            if(conn != null){
                try{
                    conn.close();
                }catch(SQLException e){
                    e.printStackTrace();
                }
            }
        }
    }
}
