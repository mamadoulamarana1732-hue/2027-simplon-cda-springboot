package fr.simplon.domedespuys.service.interfaces;

import fr.simplon.domedespuys.dto.UserDTO;
import fr.simplon.domedespuys.entities.User;

public interface IUserService extends
        ICreate<User, UserDTO>,
        IUpdate<User, UserDTO>,
        IDelete,
        IGetItem<User>
{
}