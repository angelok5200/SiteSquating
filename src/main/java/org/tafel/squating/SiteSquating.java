package org.tafel.squating;

/**
 *
 * @author Liaskovych
 */
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.tafel.squating.config.ApplicationProperties;

@EnableConfigurationProperties(ApplicationProperties.class)
@SpringBootApplication
@EnableScheduling
public class SiteSquating {

    public static void main(String[] args) {
        SpringApplication.run(SiteSquating.class, args);
    }
}
