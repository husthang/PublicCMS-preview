package com.sanluan.common.cache.redis;

import java.util.HashMap;
import java.util.Map;

import com.sanluan.common.base.Base;
import com.sanluan.common.cache.CacheEntity;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * RedisClient
 */
public class RedisClient extends Base {
    /**
     * 
     */
    public static final int DEFAULT_EXPIRY_IN_SECONDS = 120;
    
    private static JedisPool jedisPool;
    private Map<String, CacheEntity<Object, Object>> regionMap = new HashMap<String, CacheEntity<Object, Object>>();

    /**
     * @param jedisPool
     */
    public RedisClient(JedisPool jedisPool) {
        RedisClient.jedisPool = jedisPool;
    }

    /**
     * @return
     */
    public long dbSize() {
        Jedis jedis = jedisPool.getResource();
        long size = jedis.dbSize();
        jedis.close();
        return size;
    }

    /**
     * @param region
     * @return
     */
    public long getDataSize(String region) {
        return getCache(region).getDataSize();
    }

    /**
     * @param region
     * @param key
     * @return
     */
    public boolean exists(String region, Object key) {
        return getCache(region).contains(key.toString());
    }

    /**
     * @param region
     * @param key
     * @return
     */
    @SuppressWarnings("unchecked")
    public <T> T get(String region, Object key) {
        T cacheItem = (T) getCache(region).get(key.toString());
        log.trace("retrieve cache item. region=" + region + ", key=" + key + ", value=" + cacheItem);
        return cacheItem;
    }

    /**
     * @param region
     * @param key
     * @param value
     */
    public void set(String region, Object key, Object value) {
        set(region, key, value, null);
    }

    /**
     * @param region
     * @param key
     * @param value
     * @param expiry
     */
    public void set(String region, Object key, Object value, Integer expiry) {
        log.trace("set cache item. region=" + region + ", key=" + key + ", timeout=" + (empty(expiry) ? 0 : expiry));
        getCache(region).put(key.toString(), value, expiry);
    }

    /**
     * @param region
     * @param key
     * @return
     */
    public Object del(String region, Object key) {
        return getCache(region).remove(key.toString());
    }

    /**
     * @param region
     */
    public void deleteRegion(String region) {
        getCache(region).clear();
    }

    /**
     * @param region
     * @return
     */
    public Map<?, ?> getAll(String region) {
        return getCache(region).getAll();
    }

    /**
     * 
     */
    public void flushDb() {
        log.info("flush db...");
        Jedis jedis = jedisPool.getResource();
        jedis.flushDB();
        jedis.close();
    }

    /**
     * @param region
     * @return
     */
    public CacheEntity<Object, Object> getCache(String region) {
        synchronized (regionMap) {
            CacheEntity<Object, Object> cache = regionMap.get(region);
            if (null == cache) {
                cache = new RedisCacheEntity<Object, Object>(region, jedisPool);
                regionMap.put(region, cache);
            }
            return cache;
        }
    }

    /**
     * @return
     */
    public boolean isShutdown() {
        return jedisPool != null && jedisPool.isClosed();
    }

    /**
     * 
     */
    public void shutdown() {
        if (jedisPool != null) {
            jedisPool.destroy();
        }
    }
}
