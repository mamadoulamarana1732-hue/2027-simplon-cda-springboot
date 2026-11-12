package fr.simplon.domedespuys.Controllers;

import fr.simplon.domedespuys.service.interfaces.IImageService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class ImageRestController {
    private final IImageService imageService;
}
