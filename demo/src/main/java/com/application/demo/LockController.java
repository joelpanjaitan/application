package com.application.demo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

public class LockController {
     private final DistributedLockService lockService;

    public LockController(DistributedLockService lockService) {
        this.lockService = lockService;
    }

    @GetMapping("/process")
    public String process() {
        String lockKey = "resourceLock";
        boolean locked = lockService.acquireLock(lockKey, 5000);

        if (locked) {
            try {
                // Perform critical section operations
                return "Processing complete.";
            } finally {
                lockService.releaseLock(lockKey);
            }
        } else {
            return "Could not acquire lock. Try again later.";
        }
    }
}
