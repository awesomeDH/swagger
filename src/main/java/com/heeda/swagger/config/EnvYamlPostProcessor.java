package com.heeda.swagger.config;

import org.springframework.core.io.Resource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.YamlPropertySourceLoader;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.boot.env.EnvironmentPostProcessor;

import java.io.IOException;

public class EnvYamlPostProcessor implements EnvironmentPostProcessor {
    @Override
    public void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application) {
        Resource resource = new ClassPathResource("env.yml");
        YamlPropertySourceLoader sourceLoader = new YamlPropertySourceLoader();
        try {
            PropertySource<?> yamlProperties = sourceLoader.load("envYaml", resource).get(0);
            environment.getPropertySources().addLast(yamlProperties);
        } catch (IOException e) {
            throw new IllegalStateException("Failed to load YAML file: " + resource, e);
        }
    }
}
