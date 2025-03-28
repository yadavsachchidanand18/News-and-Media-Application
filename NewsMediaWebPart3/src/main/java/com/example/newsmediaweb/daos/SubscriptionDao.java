package com.example.newsmediaweb.daos;

import com.example.newsmediaweb.model.Subscription;

import java.util.List;

public interface SubscriptionDao {
    void subscribeToCategory(Subscription subscription);
    List<Subscription> getSubscriptionsByUser(Long userId);
    void unsubscribe(Long id);
}
