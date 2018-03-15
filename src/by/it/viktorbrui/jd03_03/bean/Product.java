package by.it.viktorbrui.jd03_03.bean;

import java.io.Serializable;

public class Product implements Serializable{

    private int ID;
    private String ProductName;
    private String Sku;
    private int Count;
    private int Price;
    private String PriceCurrencу;
    private int FK_Users;

    public Product() {
    }

    public Product(int ID, String ProductName, String Sku, int Count, int Price, String PriceCurrencу, int FK_Users) {
        this.ID = ID;
        this.ProductName = ProductName;
        this.Sku = Sku;
        this.Count = Count;
        this.Price = Price;
        this.PriceCurrencу = PriceCurrencу;
        this.FK_Users = FK_Users;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String ProductName) {
        this.ProductName = ProductName;
    }

    public String getSku() {
        return Sku;
    }

    public void setSku(String Sku) {
        this.Sku = Sku;
    }

    public int getCount() {
        return Count;
    }

    public void setCount(int Count) {
        this.Count = Count;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int Price) {
        this.Price = Price;
    }

    public String getPriceCurrencу() {
        return PriceCurrencу;
    }

    public void setPriceCurrencу(String PriceCurrencу) {
        this.PriceCurrencу = PriceCurrencу;
    }

    public int getFK_Users() {
        return FK_Users;
    }

    public void setFK_Users(int FK_Users) {
        this.FK_Users = FK_Users;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (ID != product.ID) return false;
        if (ProductName != product.ProductName) return false;
        if (Count != product.Count) return false;
        if (Integer.compare(product.Price, Price) != 0) return false;
        if (PriceCurrencу != product.PriceCurrencу) return false;
        if (FK_Users != product.FK_Users) return false;
       // if (ProductName != null ? !ProductName.equals(product.ProductName) : product.ProductName != null) return false;
        return Sku != null ? Sku.equals(product.Sku) : product.Sku == null;

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = ID;
        result = 31 * result + (ProductName != null ? ProductName.hashCode() : 0);
        result = 31 * result + (Sku != null ? Sku.hashCode() : 0);
        result = 31 * result + Count;
        result = 31 * result + Price;
        result = 31 * result + (PriceCurrencу != null ? PriceCurrencу.hashCode() : 0);
        temp = Double.doubleToLongBits(Price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));

        result = 31 * result + FK_Users;
        return result;
    }

    @Override
    public String toString() {
        return "Product{" +
                "ID=" + ID +
                ", ProductName='" + ProductName + '\'' +
                ", Sku='" + Sku + '\'' +
                ", Count=" + Count +
                ", Price=" + Price +
                ", PriceCurrencу=" + PriceCurrencу +
                ", FK_Users=" + FK_Users +
                '}';
    }
}

