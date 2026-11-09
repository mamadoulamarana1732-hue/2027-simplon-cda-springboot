package fr.simplon.domedespuys.view;

public class PurchaseView {
    public interface Id {}
    public interface Number {}
    public interface CreatedAt {}
    public interface Status{}
    public interface PurchaseProducts {}


    public interface PurchaseListView extends Number, CreatedAt, Status,PurchaseProducts{}
    public  interface PurchaseDetailView extends Id{}
}
