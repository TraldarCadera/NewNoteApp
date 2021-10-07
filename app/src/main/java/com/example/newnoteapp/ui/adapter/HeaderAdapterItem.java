package com.example.newnoteapp.ui.adapter;

import java.util.Objects;

public class HeaderAdapterItem implements AdapterItem {

    private final String title;

    public HeaderAdapterItem(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HeaderAdapterItem that = (HeaderAdapterItem) o;
        return Objects.equals(title, that.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title);
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String getUniqueKey() {
        return "HeaderAdapterItem" + title;
    }
}
