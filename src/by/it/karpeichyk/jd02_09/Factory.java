package by.it.karpeichyk.jd02_09;

import javax.xml.bind.annotation.XmlRegistry;

/**
 * Created by user on 16.02.2018.
 */
@XmlRegistry
public class Factory {
    public Factory() {
    }


    public Persons createPersons() {
        return new Persons();
    }


    public Person createPerson() {
        return new Person();
    }


    public Ad createAd() {
        return new Ad();
    }


    public Ads createAds() {
        return new Ads();
    }

}


