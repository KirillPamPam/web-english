package org.vagrs.english.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.vagrs.english.config.security.SecurityConfig;

/**
 * Created by Kirill Zhitelev on 13.05.2018.
 */
@Configuration
@ComponentScan(basePackages = "org.vagrs.english*")
@Import({HibernateConfig.class, SecurityConfig.class})
@EnableWebMvc
public class AppConfig {
}
