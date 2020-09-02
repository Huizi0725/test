package study_jdbc;

import org.springframework.jdbc.core.JdbcTemplate;
import util.JDBC_druidUtils;

public class JDBCTmlpate1 {
    public static void main(String[] args) {
        //1.导入jar包
        //2.创建对象
        JdbcTemplate template = new JdbcTemplate(JDBC_druidUtils.getDataSource());
        //3.调用方法
        String sql = "update user set password = ? where id = ?";

        template.update(sql,"000",1);
    }
}
