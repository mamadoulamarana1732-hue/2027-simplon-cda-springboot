package fr.simplon.domedespuys.service;

import fr.simplon.domedespuys.dto.BrandDTO;
import fr.simplon.domedespuys.dto.ImageDTO;
import fr.simplon.domedespuys.dto.ProductDTO;
import fr.simplon.domedespuys.entities.Brand;
import fr.simplon.domedespuys.entities.Image;
import fr.simplon.domedespuys.entities.Product;
import fr.simplon.domedespuys.repositories.BrandRepository;
import fr.simplon.domedespuys.repositories.ProductRepository;
import fr.simplon.domedespuys.service.interfaces.IBrandService;
import fr.simplon.domedespuys.service.interfaces.IImageService;
import fr.simplon.domedespuys.service.interfaces.IProductService;
import fr.simplon.domedespuys.utils.Slugger;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements IProductService {
    private Slugger slugger;
    private ProductRepository productRepository;
    private final IImageService imageService;
    private final IBrandService brandService;

    @Override
    public List<Product> getCollection() {
        return productRepository.findAll();
    }

    @Override
    public Product getById(String id) {
        return productRepository
                .findById(Long.parseLong(id))
                .orElse(null);
    }

    @Override
    public Product create(ProductDTO dto) {
        Product product = new Product();
        product.setLabel(dto.label);
        product.setDescription(dto.description);
        product.setSlug(slugger.slugify(dto.label));
        product.setPrice(dto.price);
        product.setCreatedAt(LocalDateTime.now());
        product.setBrand(brandService.getById(String.valueOf(dto.brandId)));
        productRepository.saveAndFlush(product);

      for(ImageDTO imageDTO : dto.images) {
            imageService.create(imageDTO, product);
        }

        productRepository.flush();
        return product;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }


    @Override
    public Product update(String id, ProductDTO dto) {
        return null;
    }



}
