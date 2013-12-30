package com.pnc.dbf.system;

import java.io.Serializable;

public class Theme implements Serializable {

    private String name;
    private String image;

    public Theme() {
    }

    public Theme(final String name, final String image) {
        this.name = name;
        this.image = image;
    }

    public final String getName() {
        return name;
    }

    public final void setName(final String name) {
        this.name = name;
    }

    public final String getImage() {
        return image;
    }

    public final void setImage(final String image) {
        this.image = image;
    }
}
