package by.it.karpeichyk.jd02_09;



import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 16.02.2018.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Ads", propOrder ={"ad"} )

public class Ads {
    @XmlElement(name = "Ad", required = true)
    private List<Ad> ad;

    @Override
    public String toString() {
        return "Ads{" + "ad="+ ad+ '}';
    }

    public List<Ad> getAd() {
        if (ad==null){
            ad= new ArrayList<Ad>();
        }
        return this. ad;
    }
}
