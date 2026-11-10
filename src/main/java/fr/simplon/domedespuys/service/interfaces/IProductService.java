package fr.simplon.domedespuys.service.interfaces;

import fr.simplon.domedespuys.dto.ProductPostDTO;
import fr.simplon.domedespuys.entities.Product;

public interface IProductService extends
        ICreate<Product, ProductPostDTO>,
        IUpdate<Product, ProductPostDTO>,
        ICollection<Product>,
        IGetItem<Product>,
        IDelete
{
}