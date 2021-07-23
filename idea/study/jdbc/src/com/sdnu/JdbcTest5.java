package com.sdnu;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Beyong
 * @Description JdbcTest5
 * @date 2021/07/19 12:52
 */
public class JdbcTest5 {
    public static void main(String[] args) {
        Map<String, String> userLoginInfo = initUI();
        boolean loginSucceed = login(userLoginInfo);
        System.out.println(loginSucceed ? "登录成功" : "登录失败");
    }
    private static boolean login(Map<String, String> userLoginInfo) {
        boolean loginSucceed = false;
        Connection conn;
        Statement stmt = null;
        ResultSet rs = null;
        String loginName = userLoginInfo.get("userName");
        String loginPwd = userLoginInfo.get("passWord");
        try{
            //1.注册驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            //2.获取连接
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase?" +
                    "useUnicode=true&characterEncoding=utf-8&zeroDateTimeBehavior=convertToNull&" +
                    "allowMultiQueries=true&serverTimezone=Asia/Shanghai","root",
                    "WGF720130601");
            //3.获取数据库操作对象
            stmt = conn.createStatement();
            //4.执行sql语句
            String sql = "SELECT * FROM t_user WHERE loginName = '"+loginName+"' AND loginPwd = '"+loginPwd+"' ";
            rs = stmt.executeQuery(sql);
            //5.处理查询结果
            if(rs.next()){
                loginSucceed = true;
            }
            return loginSucceed;
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            //6.释放资源
            if( rs != null ){
                try{
                    rs.close();
                }catch(SQLException e) {
                    e.printStackTrace();
                }
            }
            if( stmt != null){
                try{
                    stmt.close();
                }catch(SQLException e){
                    e.printStackTrace();
                }
            }
        }
        return loginSucceed;
    }
    private static Map<String, String> initUI(){
        Scanner user = new Scanner(System.in);
        System.out.println("Please input userName: ");
        String userName = user.next();
        System.out.println("Please input password: ");
        String passWord = user.next();
        Map<String, String> userLoginInfo = new HashMap<>();
        userLoginInfo.put("userName", userName);
        userLoginInfo.put("passWord", passWord);
        return userLoginInfo;
    }
}
