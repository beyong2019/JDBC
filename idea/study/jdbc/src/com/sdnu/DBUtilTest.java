package com.sdnu;

import com.sdnu.utils.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @author Beyong
 * @Description 测试JDBC工具
 * @date 2021/07/21 18:54
 */
public class DBUtilTest {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            //获取连接
            conn = DBUtil.getConnection();
            String sql = "SELECT loginName FROM t_user WHERE realName like ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,"x%");
            rs = ps.executeQuery();
            while(rs.next()){
                System.out.println(rs.getString("loginName"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            DBUtil.close(conn, ps, rs);
        }
    }
}
