package by.it.karpeichyk.jd03_02;

/**
 * Created by user on 20.02.2018.
 */
public class Ad {
    private  int id;
    private  String description;
    private  int carrying;
    private  int volume;
    private  String tariff;
    private  int FK_users;

    public  Ad() {
    }
    protected Ad(  int id,
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

    public int getFK_users() {
        return FK_users;
    }

    public void setFK_users(int FK_users) {
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

}
