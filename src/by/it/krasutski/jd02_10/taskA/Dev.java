package by.it.krasutski.jd02_10.taskA;
//это POJO класс для экспериметров с JSON
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@XmlRootElement
//минимально достаточно указать только эту аннотацию
class Dev {
    private int id = 0;
    private String name;
    private List<String> skills = new ArrayList<String>();

    public Dev() {};

    public Dev(String name, String[] arraySkills) {
        this.id = ++id;
        this.name = name;
        setSkills(arraySkills);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getSkills() {
        return skills;
    }

    @Override
    public String toString() {
        return "DevPOJO{" +
                "\nid=" + id +
                ",\nname='" + name + '\'' +
                ",\nskills=" + skills +
                "\n}";
    }

    private void setSkills(String[] arraySkills) {
        Collections.addAll(this.skills, arraySkills);
    }
    public void setSkills(List<String> skills) {
        this.skills = skills;
    }
}
