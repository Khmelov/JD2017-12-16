package by.it.karpeichyk.jd02_09;

import javax.xml.bind.annotation.*;
import java.math.BigInteger;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType (name = "Ad",propOrder = {})
public class Ad {
    @XmlElement(name = "Description", required = true)
    protected String description;
    @XmlElement(name = "Carrying", required = true)
    protected double carrying;
    @XmlElement(name = "Volume", required = true)
    protected Integer volume;
    @XmlElement(name = "Tariff", required = true)
    protected double tariff;


    public String getDescription() {
        return description;
    }

    public void setDescription(String value) {
        this.description = value;
    }

    public Double getCarrying() {
        return carrying;
    }

    public void setCarrying(Double value) {
        this.carrying = value;
    }


    public Integer getVolume() {
        return volume;
    }

    public void setVolume(Integer value) {
        this.volume = value;
    }

    public Double getTariff() {
        return tariff;
    }
    public void setTariff(Double value) {
        this.tariff = value;
    }

    @Override
    public String toString() {
        return "Ad {" +
                "description= :" + description +'\'' +
                "- carrying= :" + carrying + '\'' +
                "- volume= :" + volume + '\'' +
                "- tariff= :" + tariff + '\''+ '}'
                        ;
    }
}