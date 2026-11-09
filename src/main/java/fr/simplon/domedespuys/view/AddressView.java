package fr.simplon.domedespuys.view;

public class AddressView {
    private interface Line{}
    private interface Extraline{}
    private interface City{}
    private interface ZipCode{}
    private interface Country{}
    private interface Firstname{}
    private interface Lastname{}
    private interface Phone{}
    private interface Created{}
    private interface Purchases{}

    public interface AddressListView extends Firstname, Lastname, Phone, City, Country{}
    public interface AddressDetailView extends Line, Extraline, ZipCode, Created, Purchases, PurchaseView.PurchaseListView {}
}
