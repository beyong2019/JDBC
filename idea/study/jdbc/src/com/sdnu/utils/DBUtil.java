package com.sdnu.utils;

import java.sql.*;

/**
 * @author Beyong
 * @Description JDBC工具类
 * @date 2021/07/21 18:26
 */
public class DBUtil {
    /**
     *工具类中的方法都是私有的
     * 工具类中的方法都是静态的
     */
    private DBUtil(){};
    static{
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
    }
    /**
     * @author: Beyong
     * @description:获取连接对象
     * @param: []
     * @return: java.sql.Connection
     * @date: 2021/7/21 18:38
     */
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase?" +
                    "useUnicode=true&characterEncoding=utf-8&zeroDate" +
                    "TimeBehavior=convertToNull&allowMultiQueries=true&ser" +
                    "verTimezone=Asia/Shanghai&useSSL=false","root","WGF720130601");
    }
    /**
     * @author: Beyong
     * @description: 关闭资源
     * @param: [java.sql.Connection, java.sql.Statement, java.sql.ResultSet]
     * @return: void
     * @date: 2021/7/21 18:45
     */
    public static void close(Connection conn, Statement ps, ResultSet rs){
        if( conn != null){
            try{
                 rs.close();
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
        if( rs != null){
            try{
                rs.close();
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
    }
}
