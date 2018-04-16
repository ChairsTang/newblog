package com.am.newblog.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.bind.RelaxedPropertyResolver;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.io.IOException;

/**
 * @author AMan
 * @Date 2018/2/7 17:48
 * mybatis配置
 */
@Configuration
@AutoConfigureAfter(DuridDataSourceConfig.class)
@EnableTransactionManagement
public class MybaticConfig implements TransactionManagementConfigurer,EnvironmentAware {

    @Resource(name = "dataSource")
    private DataSource dataSource;

    private RelaxedPropertyResolver relaxedPropertyResolver;

    @Override
    public void setEnvironment(Environment environment) {
        this.relaxedPropertyResolver = new RelaxedPropertyResolver(environment,"mybatis.");
    }

    @Bean
    @Primary
    public SqlSessionFactory sqlSessionFactory(){
        try {
            SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
            //设置数据源
            sessionFactoryBean.setDataSource(dataSource);
            //读取别名配置
            sessionFactoryBean.setTypeAliasesPackage(relaxedPropertyResolver.getProperty("type-aliases-package"));
            //设置mapper文件位置

            org.springframework.core.io.Resource[] resources = new PathMatchingResourcePatternResolver().getResources(relaxedPropertyResolver.getProperty("mapper-locations"));

            sessionFactoryBean.setMapperLocations(resources);
            return sessionFactoryBean.getObject();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    @Bean
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory){
        return new SqlSessionTemplate(sqlSessionFactory);
    }

    @Override
    @Bean
    public PlatformTransactionManager annotationDrivenTransactionManager() {
        return new DataSourceTransactionManager(dataSource);
    }
}
