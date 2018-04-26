package com.go4me.prototype.model;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Order, Long> {
  Order findByPublishedBy(User publishedBy);
}
