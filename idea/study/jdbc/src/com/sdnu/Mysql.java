package com.sdnu;

/**
 * @author Beyong
 * @Description 模拟Mysql厂家
 * @date 2021/07/17 16:54
 */
public class Mysql implements Jdbc{
    public void getConnection(){
        System.out.println("Mysql数据库连接成功");
    }
}
