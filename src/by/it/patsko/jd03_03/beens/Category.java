package by.it.patsko.jd03_03.beens;

import java.util.Objects;

public class Category {
    private int id;
    private String categoryName;
    private int Catalog_id;

    public Category() {
    }

    public Category(int id, String categoryName, int catalog_id) {
        this.id = id;
        this.categoryName = categoryName;
        Catalog_id = catalog_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public int getCatalog_id() {
        return Catalog_id;
    }

    public void setCatalog_id(int catalog_id) {
        Catalog_id = catalog_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return id == category.id &&
                Catalog_id == category.Catalog_id &&
                Objects.equals(categoryName, category.categoryName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, categoryName, Catalog_id);
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", categoryName='" + categoryName + '\'' +
                ", Catalog_id=" + Catalog_id +
                '}';
    }
}
