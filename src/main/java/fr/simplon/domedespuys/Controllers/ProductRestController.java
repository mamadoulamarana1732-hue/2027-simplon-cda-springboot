package fr.simplon.domedespuys.Controllers;

import com.fasterxml.jackson.annotation.JsonView;
import fr.simplon.domedespuys.dto.BrandDTO;
import fr.simplon.domedespuys.dto.ProductDTO;
import fr.simplon.domedespuys.entities.Brand;
import fr.simplon.domedespuys.entities.Product;
import fr.simplon.domedespuys.service.interfaces.IProductService;
import fr.simplon.domedespuys.view.BrandView;
import fr.simplon.domedespuys.view.ProductView;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/api/product")
public class ProductRestController {

    private final IProductService productService;

    @GetMapping
    @JsonView(ProductView.ProductListView.class)
    public List<Product> getProducts() {
        return productService.getCollection();
    }

    @GetMapping("/{id}")
    @JsonView(ProductView.ProductDetailView.class)
    public Product getProductById(@PathVariable String id) {
        return productService.getById(id);
    }

    @PostMapping
    @JsonView(ProductView.ProductDetailView.class)
    public Product create(@RequestBody ProductDTO productDTO) {
        return productService.create(productDTO);
    }
}
