package com.sdnu;

import java.sql.*;

/**
 * @author Beyong
 * @Description bank
 * @date 2021/07/21 16:07
 */
public class bank {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement ps = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/mydatabase?" +
                    "useUnicode=true&characterEncoding=utf-8&zeroDate" +
                    "TimeBehavior=convertToNull&allowMultiQueries=true&ser" +
                    "verTimezone=Asia/Shanghai&useSSL=false";
            String user = "root";
            String passWord = "WGF720130601";
            conn = DriverManager.getConnection(url,user,passWord);
            //将自动提交事务改为手动
            conn.setAutoCommit(false);//开启事务

            String sql = "UPDATE t_act SET balance=? WHERE actno=?";
            ps = conn.prepareStatement(sql);
            ps.setDouble(1,10000);
            ps.setInt(2,111);
            int count = ps.executeUpdate();

            String s = null;
            s.toString();

            ps = conn.prepareStatement(sql);
            ps.setDouble(1,10000);
            ps.setInt(2,222);
            count += ps.executeUpdate();

            System.out.println(count == 2 ? "转账成功" : "转账失败");
            conn.commit();
        }catch(Exception e){
            if(conn != null){
                try{
                    conn.rollback();
                }catch(SQLException e1){
                    e1.printStackTrace();
                }
            }
        } finally{
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



