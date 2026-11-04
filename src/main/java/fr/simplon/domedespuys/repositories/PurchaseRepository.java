package fr.simplon.domedespuys.repositories;

import fr.simplon.domedespuys.entities.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseRepository extends JpaRepository<Purchase, Long> {
}
