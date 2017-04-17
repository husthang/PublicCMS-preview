package com.sanluan.common.hibernate.redis;

import com.sanluan.common.cache.redis.RedisClient;
import com.sanluan.common.hibernate.redis.timestamper.CacheTimestamper;

/**
 *
 * ConfigurableRedisRegionFactory
 * 
 */
public interface ConfigurableRedisRegionFactory {
    
    /**
     * @param redisClient
     * @param cacheKey
     * @return
     */
    public CacheTimestamper createCacheTimestamper(RedisClient redisClient, String cacheKey);
}
