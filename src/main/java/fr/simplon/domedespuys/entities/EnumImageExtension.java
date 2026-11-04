package fr.simplon.domedespuys.entities;

import lombok.Getter;

@Getter
public enum EnumImageExtension {
    JPG("jpg"),
    PNG("png"),
    WEBP("webp");

    private final String value;

    EnumImageExtension(String value) {
        this.value = value;
    }

}
