package com.example.newsmediaweb.repository;

import com.example.newsmediaweb.model.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubscriptionRepo extends JpaRepository<Subscription, Long> {
    List<Subscription> findByUserId(Long userId);
}
