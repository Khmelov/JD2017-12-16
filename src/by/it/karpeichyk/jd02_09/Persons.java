package by.it.karpeichyk.jd02_09;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 16.02.2018.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "",propOrder = {"person"})
@XmlRootElement (name = "Persons")
public class Persons {
    @XmlElement(name = "Person", required = true)
    protected List<Person> person;

    public List<Person> getPerson() {
        if (person == null) {
            person = new ArrayList<Person>();
        }
        return this.person;
    }

    @Override
    public String toString() {
        return "Persons{" + "person=" + person + '}';
    }
    }

