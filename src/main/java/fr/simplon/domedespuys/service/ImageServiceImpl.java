package fr.simplon.domedespuys.service;

import fr.simplon.domedespuys.dto.ImageDTO;
import fr.simplon.domedespuys.entities.Image;
import fr.simplon.domedespuys.service.interfaces.IImageService;

public class ImageServiceImpl implements IImageService {
    @Override
    public Image create(ImageDTO dto) {
        return null;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }
}
