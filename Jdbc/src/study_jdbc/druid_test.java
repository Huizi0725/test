package study_jdbc;

import util.JDBC_druidUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class druid_test {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = JDBC_druidUtils.getConnection();
            String sql = "insert into user values(null,?,?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,"xiaoming");
            pstmt.setString(2,"345");
            pstmt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBC_druidUtils.close(pstmt,conn);
        }

    }
}
