package fr.simplon.domedespuys.view;

public class UserView {
    public interface Id{}
    public interface Email{}
    private interface Password{}
    private interface Firstname{}
    private interface Lastname{}
    private interface Phone{}
    private interface CreatedAt{}
    private interface Addresses{}

    public interface UserListView extends Email, Password, Firstname, Lastname, Phone{}
    public interface UserDetailView extends CreatedAt, Addresses{}
}
