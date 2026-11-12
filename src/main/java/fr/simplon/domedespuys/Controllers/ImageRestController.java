package fr.simplon.domedespuys.Controllers;

import com.fasterxml.jackson.annotation.JsonView;
import fr.simplon.domedespuys.dto.ImageDTO;
import fr.simplon.domedespuys.entities.Image;
import fr.simplon.domedespuys.service.interfaces.IImageService;
import fr.simplon.domedespuys.view.ImageView;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class ImageRestController {
    private final IImageService imageService;
}
