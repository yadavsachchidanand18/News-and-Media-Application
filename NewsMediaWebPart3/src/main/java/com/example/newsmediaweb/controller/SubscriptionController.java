package com.example.newsmediaweb.controller;

import com.example.newsmediaweb.model.Subscription;
import com.example.newsmediaweb.service.SubscriptionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SubscriptionController {
    private final SubscriptionService subscriptionService;

    public SubscriptionController(SubscriptionService subscriptionService) {
        this.subscriptionService = subscriptionService;
    }

    @PostMapping("/subscriptions")
    public void subscribe(@RequestBody Subscription subscription) { subscriptionService.subscribeToCategory(subscription); }

    @GetMapping("/subscriptions/user/{userId}")
    public List<Subscription> getSubscriptions(@PathVariable Long userId) { return subscriptionService.getSubscriptionsByUser(userId); }

    @DeleteMapping("/subscriptions/{id}")
    public void unsubscribe(@PathVariable Long id) { subscriptionService.unsubscribe(id); }
}
