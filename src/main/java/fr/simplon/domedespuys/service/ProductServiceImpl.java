package fr.simplon.domedespuys.service;

import fr.simplon.domedespuys.dto.ProductPostDTO;
import fr.simplon.domedespuys.entities.Product;
import fr.simplon.domedespuys.service.interfaces.IProductService;

import java.util.List;

public class ProductServiceImpl implements IProductService {
    @Override
    public List<Product> getCollection() {
        return List.of();
    }

    @Override
    public Product create(ProductPostDTO dto) {
        return null;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }

    @Override
    public Product getById(String id) {
        return null;
    }

    @Override
    public Product update(String id, ProductPostDTO dto) {
        return null;
    }
}
