package fr.simplon.domedespuys.service;

import fr.simplon.domedespuys.dto.ImageDTO;
import fr.simplon.domedespuys.entities.Image;
import fr.simplon.domedespuys.entities.Product;
import fr.simplon.domedespuys.repositories.ImageRepository;
import fr.simplon.domedespuys.service.interfaces.IImageService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ImageServiceImpl implements IImageService {
    private ImageRepository imageRepository;
    @Override

    public Image create(ImageDTO dto, Product product) {
        Image image = new Image();
        image.setPath(dto.path);
        image.setDefault(dto.isDefault);
        image.setExtension("PNG");
        image.setProduct(product);
        imageRepository.saveAndFlush(image);
        return image;
    }

    @Override
    public void flush() {

    }

    @Override
    public boolean delete(String id) {
        return false;
    }
}
