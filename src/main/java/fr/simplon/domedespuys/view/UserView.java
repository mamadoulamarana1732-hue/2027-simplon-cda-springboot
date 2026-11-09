package fr.simplon.domedespuys.view;

public class UserView {
    public interface Id{}
    public interface Email{}
    public interface Password{}
    public interface Firstname{}
    public interface Lastname{}
    public interface Phone{}
    public interface CreatedAt{}
    public interface Addresses{}

    public interface UserListView extends Email, Password, Firstname, Lastname, Phone{}
    public interface UserDetailView extends CreatedAt, Addresses{}
}
