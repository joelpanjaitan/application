package com.application.demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class DistributedLockService {
    private StringRedisTemplate redisTemplate;
    private static final String LOCK_PREFIX = "lock:";

    public boolean acquireLock(String key, long timeout) {
        String lockValue = UUID.randomUUID().toString();
        Boolean success = redisTemplate.opsForValue().setIfAbsent(LOCK_PREFIX + key, lockValue, timeout, TimeUnit.MILLISECONDS);
         if (Boolean.TRUE.equals(success)) {
            return true;
        }

        String currentValue = redisTemplate.opsForValue().get(LOCK_PREFIX + key);
        if (currentValue != null && !currentValue.isEmpty() && isLockExpired(currentValue)) {
            String oldValue = redisTemplate.opsForValue().getAndSet(LOCK_PREFIX + key, lockValue);
            if (oldValue != null && oldValue.equals(currentValue)) {
                return true;
            }
        }
        return false;
    }

    public void releaseLock(String key){
        String currentValue = redisTemplate.opsForValue().get(LOCK_PREFIX + key);
        if (currentValue != null) {
            redisTemplate.delete(LOCK_PREFIX + key);
        }
    }

    public boolean isLockExpired(String lockValue) {
        return true;
    }
}
