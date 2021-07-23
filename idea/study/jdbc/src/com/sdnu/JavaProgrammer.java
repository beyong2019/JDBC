package com.sdnu;

/**
 * @author Beyong
 * @Description Java程序员
 * @date 2021/07/17 16:49
 **/
public class JavaProgrammer {
    public static void main(String[] args) {
        Jdbc jdbc = new Mysql();
        jdbc.getConnection();
        Jdbc jdbc2 = new Oracle();
        jdbc2.getConnection();
        Jdbc jdbc3 = new SqlServer();
        jdbc3.getConnection();
    }
}
