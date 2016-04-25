package by.bsuir.timetable.rest;

import org.springframework.boot.autoconfigure.web.WebMvcAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;

@Configuration
public class MvcConfig extends WebMvcAutoConfiguration.WebMvcAutoConfigurationAdapter {
    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new LocalDateConverter());
    }
}
