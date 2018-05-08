
package com.go4me.prototype.model;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SellerRepository extends JpaRepository<Order, Long> {
  Seller findByOrder(Order order);
}
