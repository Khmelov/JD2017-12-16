package by.it.karpeichyk.Project.java.dao.BEAN;

import java.io.Serializable;

/**
 * Created by user on 20.02.2018.
 */
public class Ad implements Serializable {
    private  int id;
    private  String description;
    private  int carrying;
    private  int volume;
    private  String tariff;
    private  int FK_users;

    public Ad() {
    }
    public Ad(int id,
              String description,
              int carrying,
              int volume,
              String tariff,
              int FK_users){
        this.id=id;
        this.description=description;
        this.carrying=carrying;
        this.volume=volume;
        this.tariff=tariff;
        this.FK_users=FK_users;
    }

    public Ad(int id, String login, String description, String carrying, String volume, String tariff) {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCarrying() {
        return carrying;
    }

    public void setCarrying(int carrying) {
        this.carrying = carrying;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public String getTariff() {
        return tariff;
    }

    public void setTariff(String tariff) {
        this.tariff = tariff;
    }

    public int getFK_Users() {
        return FK_users;
    }

    public void setFK_Users(int FK_users) {
        this.FK_users = FK_users;
    }

    @Override
    public String toString() {
        return "Ad{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", carrying=" + carrying +
                ", volume=" + volume +
                ", tariff='" + tariff + '\'' +
                ", FK_users=" + FK_users +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ad ad = (Ad) o;

        if (id != ad.id) return false;
        if (carrying != ad.carrying) return false;
        if (volume != ad.volume) return false;
        if (FK_users != ad.FK_users) return false;
        if (description != null ? !description.equals(ad.description) : ad.description != null) return false;
        return tariff != null ? tariff.equals(ad.tariff) : ad.tariff == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + carrying;
        result = 31 * result + volume;
        result = 31 * result + (tariff != null ? tariff.hashCode() : 0);
        result = 31 * result + FK_users;
        return result;
    }
}
