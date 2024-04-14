package com.app.cache.strategy.impl;

import com.app.cache.models.CacheItem;
import com.app.cache.strategy.CachingStrategy;

public class LFUCachingStrategy<K,V> implements CachingStrategy<K,V> {
    @Override
    public void put(K key, V value) {

    }

    @Override
    public CacheItem<V> get(K key) {
        return null;
    }
}
