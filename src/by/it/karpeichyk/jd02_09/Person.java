package by.it.karpeichyk.jd02_09;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * Created by user on 16.02.2018.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Person" , propOrder = {"email" , "nickname",
"password","ads" })

public class Person {
    @XmlElement(name ="Email" ,required = true)
    protected String email;
    @XmlElement(name = "Nickname",required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    @XmlSchemaType(name = "ID")
    protected String nickname;
    @XmlElement(name ="Password" ,required = true)
    protected String password;
    @XmlElement(name ="Ads" ,required = true)
    protected Ads ads;

    @Override
    public String toString() {
        return "Person{" +
                "email='" + email + '\'' +
                ", nickname='" + nickname + '\'' +
                ", password='" + password + '\'' +
                ", ads=" + ads +
                '}';
    }
    public String getEmail() {
        return email;
    }

      public  void setEmail(String value) {
        this.email = value;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String value) {
        this.nickname = value;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String value) {
        this.password = value;}

        public Ads getAds() {return ads;
        }
        public void setAds(Ads value) {this.ads = value;
        }



}
