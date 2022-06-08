package com.graphsql.learn.config;

import javax.servlet.Filter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.support.OpenEntityManagerInViewFilter;

@Configuration
public class LazyFilter {
    @Bean
    public Filter openSessionInView() {
        return new OpenEntityManagerInViewFilter();
    }
}
