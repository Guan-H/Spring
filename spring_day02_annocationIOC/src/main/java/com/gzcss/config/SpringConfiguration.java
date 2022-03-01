package com.gzcss.config;


import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.*;

import javax.sql.DataSource;
import javax.xml.crypto.Data;


@Configurable
@ComponentScan("com.gzcss")
@Import(JdbcConfig.class)
@PropertySource("classpath:jdbcConfig.properties")
//@PropertySource("classpath:jdbcConfig.properties")
public class SpringConfiguration {



}
