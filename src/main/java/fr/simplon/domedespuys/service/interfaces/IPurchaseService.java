package fr.simplon.domedespuys.service.interfaces;

import fr.simplon.domedespuys.dto.PurchaseDTO;
import fr.simplon.domedespuys.entities.Purchase;

public interface IPurchaseService extends
        ICreate<Purchase, PurchaseDTO>,
        IUpdate<Purchase, PurchaseDTO>,
        ICollection<Purchase>,
        IGetItem<Purchase>,
        IDelete
{
}
