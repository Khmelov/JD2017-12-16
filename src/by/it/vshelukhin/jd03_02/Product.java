package by.it.vshelukhin.jd03_02;

public class Product {
    private int id = 0;
    private String name = "";
    private int fk_students = 0;

    Product(){
        super();
    }

    Product(int id, String name, int fk_students){
        super();
        this.id = id;
        this.name = name;
        this.fk_students = fk_students;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFk_students(int fk_students) {
        this.fk_students = fk_students;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getFk_students() {
        return fk_students;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", fk_students=" + fk_students +
                '}';
    }
}
