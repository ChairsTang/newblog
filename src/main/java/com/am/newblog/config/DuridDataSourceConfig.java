package com.am.newblog.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.bind.RelaxedPropertyResolver;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * @author AMan
 * @Date 2018/1/1 14:11
 * 数据源配置类
 */
@Configuration
public class DuridDataSourceConfig  implements EnvironmentAware {
    //配置解析器
    private RelaxedPropertyResolver propertyResolver;

    @Override
    public void setEnvironment(Environment environment) {
        this.propertyResolver = new RelaxedPropertyResolver(environment,"spring.datasource.");
    }

    //配置数据源 primary加此注解默认使用此数据源
    @Bean
    @Primary
    public DataSource dataSource(){
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setUrl(propertyResolver.getProperty("url"));
        druidDataSource.setDriverClassName(propertyResolver.getProperty("driver-class-name"));
        druidDataSource.setUsername(propertyResolver.getProperty("username"));
        druidDataSource.setPassword(propertyResolver.getProperty("password"));
        return  druidDataSource;
    }
}
