package com.go4me.prototype.model;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderRequest, Long> {
  OrderRequest findByPublishedBy(User publishedBy);
}
