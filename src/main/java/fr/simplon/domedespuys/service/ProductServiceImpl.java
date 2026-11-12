package fr.simplon.domedespuys.service;

import fr.simplon.domedespuys.dto.ImageDTO;
import fr.simplon.domedespuys.dto.ProductDTO;
import fr.simplon.domedespuys.entities.Brand;
import fr.simplon.domedespuys.entities.Image;
import fr.simplon.domedespuys.entities.Product;
import fr.simplon.domedespuys.repositories.BrandRepository;
import fr.simplon.domedespuys.repositories.ProductRepository;
import fr.simplon.domedespuys.service.interfaces.IProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements IProductService {
    private ProductRepository productRepository;
    private BrandRepository brandRepository;

    @Override
    public List<Product> getCollection() {
        return productRepository.findAll();
    }

    @Override
    public Product create(ProductDTO dto) {
        Product product = new Product();
        product.setLabel(dto.label);
        product.setDescription(dto.description);
        product.setPrice(dto.price);
        product.setBrand(brandRepository.findById(dto.brandId).orElseThrow());

        for (ImageDTO url : dto.images) {
            Image image = new Image();
            //image.setPath(url);
            image.setProduct(product);
            product.getImages().add(image);
        }

        return productRepository.save(product);

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
    public Product update(String id, ProductDTO dto) {
        return null;
    }
}
