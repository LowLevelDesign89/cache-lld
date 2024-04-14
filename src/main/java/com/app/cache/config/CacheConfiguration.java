package com.app.cache.config;


import com.app.cache.models.enums.CacheEvictionStrategy;

public class CacheConfiguration {
    private CacheEvictionStrategy cacheEvictionStrategy;
    private double ttl;

    private int maxCapacity;

    public CacheEvictionStrategy getCacheEvictionStrategy() {
        return cacheEvictionStrategy;
    }

    public void setCacheEvictionStrategy(CacheEvictionStrategy cacheEvictionStrategy) {
        this.cacheEvictionStrategy = cacheEvictionStrategy;
    }

    public double getTtl() {
        return ttl;
    }

    public void setTtl(double ttl) {
        this.ttl = ttl;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }
}
