package com.app.cache.models;

public class CacheItem<V> {
    private V value;
    private double ttl;

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public double getTtl() {
        return ttl;
    }

    public void setTtl(double ttl) {
        this.ttl = ttl;
    }
}
