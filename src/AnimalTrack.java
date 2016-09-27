import java.util.ArrayList;
import java.util.Date;

public class AnimalTrack {
    String id;
    String date;
    ArrayList<Animal> animalArrayList;

    public AnimalTrack(String id, String date, ArrayList<Animal> animalArrayList) {
        this.id = id;
        this.date = date;
        this.animalArrayList = animalArrayList;
    }

    @Override
    public String toString() {
        return "AnimalTrack{" +
                "id='" + id + '\'' +
                ", date='" + date + '\'' +
                ", animalArrayList=" + animalArrayList +
                '}';
    }
}

