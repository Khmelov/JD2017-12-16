package by.it.shalukhin.jd01_01;

public class Hello {
    private String slogan = "Hello World!";
    void printSlogan(){
        System.out.println(slogan);
    }

    public void setSlogan(String slogan) {
        this.slogan = slogan;
    }

    public String getSlogan() {

        return slogan;
    }
}
