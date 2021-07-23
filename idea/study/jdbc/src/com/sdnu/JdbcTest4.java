package com.sdnu;

/**
 * @author Beyong
 * @Description test idea connection mysql
 * @date 2021/07/18 18:02
 */
public class JdbcTest4 {
    public static void main(String[] args) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
