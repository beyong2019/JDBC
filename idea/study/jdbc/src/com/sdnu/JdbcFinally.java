package com.sdnu;
import java.sql.*;

/**
 * @author Beyong
 * @Description Jdbc源码解析
 * @date 2021/07/20 16:28
 */
public class JdbcFinally {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement ps = null;
        try{
            Driver driver = new com.mysql.cj.jdbc.Driver();
            DriverManager.registerDriver(driver);
            String url = "jdbc:mysql://localhost:3306/mydatabase?" +
                    "useUnicode=true&characterEncoding=utf-8&zeroDate" +
                    "TimeBehavior=convertToNull&allowMultiQueries=true&ser" +
                    "verTimezone=Asia/Shanghai&useSSL=false";
            String user = "root";
            String passWord = "WGF720130601";
            conn = DriverManager.getConnection(url,user,passWord);
            String sql = "UPDATE t_user SET loginPwd=? WHERE loginName=?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1,777);
            ps.setString(2,"wu");
            int count = ps.executeUpdate();
            System.out.println(count);

            ps = conn.prepareStatement(sql);
            ps.setInt(1,666);
            ps.setString(2,"wang");
            count = ps.executeUpdate();
            System.out.println(count);
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            if(conn != null){
                try{
                    conn.close();
                }catch(SQLException e){
                    e.printStackTrace();
                }
            }
            if(ps != null){
                try{
                    ps.close();
                }catch(SQLException e){
                    e.printStackTrace();
                }
            }
        }
    }
}
