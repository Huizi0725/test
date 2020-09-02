package study_jdbc;

import domain.Emp;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import util.JDBC_druidUtils;

import javax.xml.crypto.Data;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class JDBCmplate_exc {
    //Junit单元测试，可以让方法独立执行
    public static void main(String[] args) {
        new JDBCmplate_exc().test1();
        new JDBCmplate_exc().test2();
        new JDBCmplate_exc().test3();
        new JDBCmplate_exc().test4();
        new JDBCmplate_exc().test5();
        new JDBCmplate_exc().test6();
        new JDBCmplate_exc().test7();
    }
    private JdbcTemplate template = new JdbcTemplate(JDBC_druidUtils.getDataSource());
    void test1(){
       // JdbcTemplate template = new JdbcTemplate(JDBC_druidUtils.getDataSource());
        String sql = "update emp set salary = 10000 where id = 1001";
        template.update(sql);
    }

    void test2(){
        String sql = "insert into emp (id,ename,dept_id) values (1022,'小李',10)";
        template.update(sql);
    }

    void test3(){
        String sql = "delete from emp where id = 1022";
        template.update(sql);
    }

    void test4(){
        String sql = "select * from emp where id = ?";
        Map<String,Object> map = template.queryForMap(sql,1001);
        System.out.println(map);
    }

    void test5(){
        String sql ="select * from emp";
        List<Map<String, Object>> list = template.queryForList(sql);
        for(Map<String, Object> Stringmap : list){
            System.out.println(Stringmap);
        }
    }
    void test6(){
        String sql = "select * from emp";
        List<Emp> list = template.query(sql,new BeanPropertyRowMapper<Emp>(Emp.class));
        for(Emp emp:list){
            System.out.println(emp);
        }
    }

    void test7(){
        String sql = "select count(id) from emp";
        Long total = template.queryForObject(sql,long.class);
        System.out.println(total);
    }
}
