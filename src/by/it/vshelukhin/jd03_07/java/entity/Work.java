package by.it.vshelukhin.jd03_07.java.entity;

public class Work {
    private int id = 0;
    private String name = "";
    private double price = 0.0;

    public Work(){
        super();
    }

    public Work(int id, String name, double price){
        super();
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Work{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
