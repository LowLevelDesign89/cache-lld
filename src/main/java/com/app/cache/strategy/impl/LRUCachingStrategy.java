package com.app.cache.strategy.impl;

import com.app.cache.models.CacheItem;
import com.app.cache.strategy.CachingStrategy;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class LRUCachingStrategy<K, V> implements CachingStrategy<K, V> {
    static class Item<K, V> {
        K key;
        CacheItem<V> cacheItem;

        public Item(K key, CacheItem<V> cacheItem) {
            this.key = key;
            this.cacheItem = cacheItem;
        }
    }

    private Map<K, Item<K, V>> map;
    private Deque<Item<K, V>> queue;
    private int currentCapacity;
    private int maxCapacity;

    public LRUCachingStrategy(int maxCapacity) {
        this.currentCapacity = 0;
        this.maxCapacity = maxCapacity;
        map = new HashMap<>();
        queue = new LinkedList<>();
    }

    @Override
    public void put(K key, V value) {
        if(!map.containsKey(key)) {
            CacheItem<V> cacheItem = createItem(value);
            Item<K, V> newItem = new Item<>(key, cacheItem);
           if(currentCapacity == maxCapacity) {
               Item<K, V> item = queue.pollLast();
               map.remove(item.key);
               currentCapacity--;
           }
           map.put(key, newItem);
           queue.addFirst(newItem);
           currentCapacity++;
        } else {
            Item<K, V> existingItem = map.get(key);
            queue.remove(existingItem);
            CacheItem<V> cacheItem = createItem(value);
            existingItem.cacheItem = cacheItem;
            map.put(key, existingItem);
            queue.addFirst(existingItem);
        }
    }

    @Override
    public CacheItem<V> get(K key) {
        if(!map.containsKey(key))
            return null;
        Item<K, V> existingItem = map.get(key);
        queue.remove(existingItem);
        queue.addFirst(existingItem);
        return existingItem.cacheItem;
    }

    private CacheItem<V> createItem(V value) {
        CacheItem<V> cacheItem = new CacheItem<>();
        cacheItem.setValue(value);
        return cacheItem;
    }
}
