package com.ebei.eba.config;

import org.springframework.boot.env.PropertySourcesLoader;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.core.io.support.PropertySourceFactory;

import java.io.IOException;

/**
 * @Description:
 * @Auther: yangsm
 * @Date: 2018/7/27 0027
 */
public class YmlPropertyFactory implements PropertySourceFactory {
    @Override
    public PropertySource<?> createPropertySource(String name, EncodedResource resource) throws IOException {
        return name != null ? new PropertySourcesLoader().load(resource.getResource(), name, null) : new PropertySourcesLoader().load(
                resource.getResource(), getNameForResource(resource.getResource()), null);
    }

    private static String getNameForResource(Resource resource) {
        String name = resource.getDescription();
        if (!org.springframework.util.StringUtils.hasText(name)) {
            name = resource.getClass().getSimpleName() + "@" + System.identityHashCode(resource);
        }
        return name;
    }
}
