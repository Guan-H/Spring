package com.gzcss.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

import javax.sql.DataSource;

public class JdbcConfig {

    @Value("${jdbc.driver}")
    private String drive;
    @Value("${jdbc.url}")
    private String  url ;
    @Value("${jdbc.username}")
    private String username;
    @Value("${jdbc.password}")
    private String password;

    @Bean("queryRunner")
    @Scope("prototype")
    public QueryRunner queryRunner(DataSource dataSource) {
        return new QueryRunner(dataSource);
    };

    @Bean("datasource")
    public DataSource createDatasource(){
        ComboPooledDataSource cp = new ComboPooledDataSource();
        try {
            cp.setDriverClass(drive);
            cp.setJdbcUrl(url);
            cp.setUser(username);
            cp.setPassword(password);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
        return cp;
    }



}
