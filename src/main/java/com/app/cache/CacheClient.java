package com.app.cache;

import com.app.cache.config.CacheConfiguration;
import com.app.cache.strategy.CachingStrategy;
import com.app.cache.strategy.impl.LFUCachingStrategy;
import com.app.cache.strategy.impl.LRUCachingStrategy;

import java.security.InvalidParameterException;

public class CacheClient<K,V> {
    private final CacheConfiguration cacheConfiguration;

    public CacheClient(CacheConfiguration cacheConfiguration) {
        this.cacheConfiguration = cacheConfiguration;
    }

    public CachingStrategy<K, V> cachingStrategy() {
        switch (cacheConfiguration.getCacheEvictionStrategy()) {
            case LRU:
                return new LRUCachingStrategy<>(cacheConfiguration.getMaxCapacity());
            case LFU:
                return new LFUCachingStrategy<>();
            default:
                throw new InvalidParameterException("Invalid parameter");
        }
    }
}
