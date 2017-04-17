package com.sanluan.common.cache;

import java.util.List;
import java.util.Map;

/**
 *
 * CacheEntity
 * @param <K> 
 * @param <V> 
 * 
 */
public interface CacheEntity<K, V> {

    /**
     * @param key
     * @param value
     * @param expiry
     */
    public void put(K key, V value, Integer expiry);

    /**
     * @param key
     * @param value
     * @return
     */
    public List<V> put(K key, V value);

    /**
     * @param key
     * @return
     */
    public V remove(K key);

    /**
     * @param key
     * @return
     */
    public boolean contains(K key);

    /**
     * @param key
     * @return
     */
    public V get(K key);

    /**
     * @return
     */
    public List<V> clear();

    /**
     * @return
     */
    public long getDataSize();

    /**
     * @return
     */
    public Map<K, V> getAll();
}
