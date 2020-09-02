package study_jdbc;

import java.sql.*;

public class JdbcStudy {
    public static void main(String[] args){
        Statement stmt = null;
        Connection conn = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String sql = "select * from study";
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/exc?characterEncoding=utf-8&serverTimezone=UTC","root","root");
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            rs.next();
            String name = rs.getString(1);
            int age = rs.getInt(2);
            System.out.println(name +"   "+age);

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }finally {
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
           if(stmt!=null){
               try {
                   stmt.close();
               } catch (SQLException throwables) {
                   throwables.printStackTrace();
               }
           }
           if(conn!=null){
               try {
                   conn.close();
               } catch (SQLException throwables) {
                   throwables.printStackTrace();
               }
           }
        }

    }
}
