package fr.simplon.domedespuys.repositories;

import fr.simplon.domedespuys.entities.Product;
import fr.simplon.domedespuys.entities.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PurchaseRepository extends JpaRepository<Purchase, Long> {
}
