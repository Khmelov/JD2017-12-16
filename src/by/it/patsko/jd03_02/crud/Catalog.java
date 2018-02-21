package by.it.patsko.jd03_02.crud;

import java.util.Objects;

public class Catalog {
    private int id;
    private String catalogName;

    public Catalog() {
    }

    public Catalog(int id, String catalogName) {
        this.id = id;
        this.catalogName = catalogName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCatalogName() {
        return catalogName;
    }

    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Catalog catalog = (Catalog) o;
        return id == catalog.id &&
                Objects.equals(catalogName, catalog.catalogName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, catalogName);
    }

    @Override
    public String toString() {
        return "Catalog{" +
                "id=" + id +
                ", catalogName='" + catalogName + '\'' +
                '}';
    }
}
