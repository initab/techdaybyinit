package se.init.tdbi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.handler.MappedInterceptor;

@SpringBootApplication
public class YorickApplication {

    public static void main(String[] args) {
        SpringApplication.run(YorickApplication.class, args);
    }

    @Bean
    @Autowired
    public MappedInterceptor addEmailHeaderInterceptor(EmailHeaderInterceptor emailHeaderInterceptor) {
        return new MappedInterceptor(new String[]{"/**"}, emailHeaderInterceptor);
    }
}
