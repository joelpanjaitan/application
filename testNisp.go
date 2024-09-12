package main

import (
	"fmt"
	"sync"
	"time"
)

type RateLimiter struct{
	limitPerSecond int
	requests sync.Map
}

type UserRequests struct{
	timestamps []time.Time
	mu	sync.Mutex
}

func NewRateLimiter(limitPerSecond int) *RateLimiter {
	return &RateLimiter{
		limitPerSecond: limitPerSecond,
	}
}

func (rl *RateLimiter) AllowRequest(userID string) bool {
	now := time.Now()
	windowStart := now.Add(-time.Second)

	userData, _ := rl.requests.LoadOrStore(userID, &UserRequests{})
	userReqs := userData.(*UserRequests)

	userReqs.mu.Lock()
	defer userReqs.mu.Unlock()

	filtered := make([]time.Time, 0, len(userReqs.timestamps))
	for _, t := range userReqs.timestamps {
		if t.After(windowStart) {
			filtered = append(filtered, t)
		}
	}
	userReqs.timestamps = filtered

	// Check if limit is exceeded
	if len(userReqs.timestamps) >= rl.limitPerSecond {
		return false
	}

	// Record the new request
	userReqs.timestamps = append(userReqs.timestamps, now)
	return true
}

func main() {
	rateLimiter := NewRateLimiter(5)

	userID := "user1"

	for i := 0; i < 10; i++ {
		if rateLimiter.AllowRequest(userID) {
			println("Request allowed")
		} else {
			println("Request rate-limited")
		}
		time.Sleep(200 * time.Millisecond)
	}
	fmt.Println("Hello world")
}