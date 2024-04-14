package com.app.cache.strategy;

import com.app.cache.models.CacheItem;

public interface CachingStrategy<K, V> {
    void put(K key, V value);

    CacheItem<V> get(K key);
}
