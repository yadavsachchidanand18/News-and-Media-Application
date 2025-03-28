package com.example.newsmediaweb.service;

import com.example.newsmediaweb.daos.SubscriptionDao;
import com.example.newsmediaweb.model.Subscription;
import com.example.newsmediaweb.repository.SubscriptionRepo;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SubscriptionService implements SubscriptionDao {
    private final SubscriptionRepo subscriptionRepo;

    public SubscriptionService(SubscriptionRepo subscriptionRepo) {
        this.subscriptionRepo = subscriptionRepo;
    }

    @Override
    public void subscribeToCategory(Subscription subscription) {
       subscriptionRepo.save(subscription);
    }

    @Override
    public List<Subscription> getSubscriptionsByUser(Long userId) {
        return subscriptionRepo.findByUserId(userId);
    }

    @Override
    public void unsubscribe(Long id) {
       subscriptionRepo.deleteById(id);
    }
}
