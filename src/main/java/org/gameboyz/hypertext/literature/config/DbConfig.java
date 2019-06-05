package org.gameboyz.hypertext.literature.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
@Configuration
@Slf4j
public class DbConfig {

    @Bean(name="dataSource")
    @Qualifier(value="dataSource")
    @Primary
    @ConfigurationProperties(prefix="c3p0")
    public DataSource dataSource(){
        return DataSourceBuilder.create().type(ComboPooledDataSource.class).build();
    }

}
