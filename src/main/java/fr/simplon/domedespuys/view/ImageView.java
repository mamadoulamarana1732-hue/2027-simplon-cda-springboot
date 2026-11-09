package fr.simplon.domedespuys.view;

public class ImageView {
    public interface Id {}
    public interface Path {}
    public interface Extension {}
    public interface IsDefault{}

    public interface ImagelistView extends Path, Extension{}
    public interface ImageDetailView extends Id, IsDefault{}
}
