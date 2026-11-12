package fr.simplon.domedespuys.Controllers;

import com.fasterxml.jackson.annotation.JsonView;
import fr.simplon.domedespuys.entities.Product;
import fr.simplon.domedespuys.service.interfaces.IProductService;
import fr.simplon.domedespuys.view.ProductView;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    /*
    @GetMapping("/slug/{slug}")
    @JsonView(ProductView.ProductDetailView.class)
    public Optional<Product> getBrandBySlug(@PathVariable String slug) {
        return productRepository.findBySlug(slug);
    }

    @GetMapping("/{id}")
    @JsonView(ProductView.ProductDetailView.class)
    public Optional<Product> getBrandById(@PathVariable String id) {
        return productRepository.findById(Long.valueOf(id));
    }
*/
}
