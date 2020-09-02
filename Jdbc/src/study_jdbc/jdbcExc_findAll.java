package study_jdbc;

import domain.Emp;
import util.JDBCUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class jdbcExc_findAll {
    public static void main(String[] args) {
        List<Emp> list = new jdbcExc_findAll().findAll();
        System.out.println(list);
    }
    //查询所有emp对象
    public List<Emp> findAll(){
        //1.注册驱动
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        List<Emp> list = null;
        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/exc?characterEncoding=utf-8&serverTimezone=UTC","root","root");
            conn = JDBCUtils.getConnection();
            String sql = "select * from emp";
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            Emp emp = null;
            list = new ArrayList<Emp>();
            while(rs.next()){
                int id = rs.getInt("id");
                String ename = rs.getString("ename");
                int job_id = rs.getInt("job_id");
                int mgr = rs.getInt("mgr");
                Date joindate = rs.getDate("joindate");
                double salary = rs.getDouble("salary");
                double bonus = rs.getDouble("bonus");
                int dept_id = rs.getInt("dept_id");

                emp = new Emp();
                emp.setId(id);
                emp.setEname(ename);
                emp.setJob_id(job_id);
                emp.setMgr(mgr);
                emp.setJoindate(joindate);
                emp.setSalary(salary);
                emp.setBonus(bonus);
                emp.setDept_id(dept_id);

                //装载集合
                list.add(emp);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
           JDBCUtils.close(rs,stmt,conn);
        }
        return list;

    }
}
