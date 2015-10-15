package com.ethertion.lab.webapp;

import org.springframework.cache.CacheManager;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Application configuration
 * @author amiguel
 */
@Configuration
public class AppConfig {

    @Bean(name="cacheManager")
    public CacheManager getCacheManager() {
        CacheManager cacheManager = new EhCacheCacheManager();
        return cacheManager;
    }

}
