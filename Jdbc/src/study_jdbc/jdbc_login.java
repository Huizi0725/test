package study_jdbc;

import util.JDBCUtils;

import java.sql.*;
import java.util.Scanner;

public class jdbc_login {
    public static void main(String[] args) {
        //键盘录入用户名和密码
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入用户名");
        String username = sc.nextLine();
        System.out.println("请输入密码");
        String password = sc.nextLine();

        //调用方法
        boolean flag = new jdbc_login().login(username,password);
        //判断结果
        if(flag){
            System.out.println("登录成功");
        }else {
            System.out.println("用户名或密码错误");
        }
    }

    //登录方法
    public boolean login(String username,String password){
        if(username == null|| password == null){
            return false;
        }
        //连接数据库潘顿是否登录成功
        //1.连接数据库
        Connection conn =null;
       // Statement stmt =null;
        ResultSet rs =null;
        PreparedStatement pstmt = null;
        try {
            conn = JDBCUtils.getConnection();
            String sql = "select * from User where username =? and password = ?";
            //获取执行sql的对象
            pstmt = conn.prepareStatement(sql);
            //给？赋值
            pstmt.setString(1,username);
            pstmt.setString(2,password);
            //执行查询，不需要传递sql
            rs = pstmt.executeQuery();
            return rs.next();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtils.close(rs,pstmt,conn);
        }
        return false;
    }
}
