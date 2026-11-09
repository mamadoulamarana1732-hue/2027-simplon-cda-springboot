package fr.simplon.domedespuys.view;

public class PurchaseProductView {
    public interface Id {}
    public interface Quantity {}
    public interface Price {}

    public interface PurchaseProductListView extends Quantity, Price{}
    public interface PurchaseProductDetailView extends PurchaseProductView.Id {}
}
