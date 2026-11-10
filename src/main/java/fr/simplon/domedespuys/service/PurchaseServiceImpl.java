package fr.simplon.domedespuys.service;

import fr.simplon.domedespuys.dto.PurchaseDTO;
import fr.simplon.domedespuys.entities.Purchase;
import fr.simplon.domedespuys.service.interfaces.IPurchaseService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PurchaseServiceImpl implements IPurchaseService {
    @Override
    public List<Purchase> getCollection() {
        return List.of();
    }

    @Override
    public Purchase create(PurchaseDTO dto) {
        return null;
    }

    @Override
    public Purchase getById(String id) {
        return null;
    }

    @Override
    public Purchase update(String id, PurchaseDTO dto) {
        return null;
    }
}
