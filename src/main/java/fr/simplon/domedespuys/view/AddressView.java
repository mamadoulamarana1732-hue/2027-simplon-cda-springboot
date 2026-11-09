package fr.simplon.domedespuys.view;
//les views sont en publics
public class AddressView {
    public interface Id{}
    public interface Line{}
    public interface Extraline{}
    public interface City{}
    public interface ZipCode{}
    public interface Country{}
    public interface Firstname{}
    public interface Lastname{}
    public interface Phone{}
    public interface Created{}
    public interface Purchases{}

    public interface AddressListView extends Id, Firstname, Lastname, Phone, City, Country{}
    public interface AddressDetailView extends Line, Extraline, ZipCode, Created, Purchases, PurchaseView.PurchaseListView {}
}
