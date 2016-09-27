import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    public Main() throws IOException {
    }

    public static void main (String[] args) throws IOException {
        ArrayList<AnimalTrack> animalTrackArrayList = new ArrayList<>();
        String matcher = ".{8}-.{4}-.{4}-.{4}-.{12}";
        Pattern r = Pattern.compile(matcher);
        List<String> lines;
        lines = Files.readAllLines(Paths.get("data.json"), Charset.forName("UTF-8"));
        int i = 0;
        int j = 0;
        for (i = 0; i < lines.size(); i++)
        {
            if (r.matcher(lines.get(i)).matches()){
                ArrayList<Animal> animalArrayList = new ArrayList<>();
                String id = lines.get(i);
                String date = lines.get(i+1);
//                System.out.println("id:"+id);
//                System.out.println("date:"+date);
                i+=2;
                for (j = i;  j < lines.size() &&!(r.matcher(lines.get(j)).matches()); j++){
                    String[] animalSplit = lines.get(j).split(" ");
                    String name = animalSplit[0];
                    int x = Integer.parseInt(animalSplit[1]);
                    int y = Integer.parseInt(animalSplit[2]);
                    int heartRate = 0;
                    int current = animalTrackArrayList.size();
                    boolean occurBefore = false;
                    if(current > 0){
                        animalArrayList = animalTrackArrayList.get(current-1).animalArrayList;
                        for (Animal animal:animalArrayList) {
                            if(animal.name.equals(name)){
                                occurBefore = true;
                                if (animalSplit.length == 5){
                                    if (animal.x != x || animal.y != y){
                                        System.out.println("id: "+id+" is wrong!");
                                        return;
                                    }
                                    x = x + Integer.parseInt(animalSplit[3]);
                                    y = y + Integer.parseInt(animalSplit[4]);
                                    animal.x = x;
                                    animal.y = y;
                                }
                                else if (animalSplit.length == 7){
                                    heartRate = Integer.parseInt(animalSplit[5]);
                                    if (animal.x != x || animal.y != y || animal.heartRate != heartRate){
                                        System.out.println("id: "+id+" is wrong!");
                                        return;
                                    }
                                    x = x + Integer.parseInt(animalSplit[3]);
                                    y = y + Integer.parseInt(animalSplit[4]);
                                    heartRate = heartRate + Integer.parseInt(animalSplit[6]);
                                    animal.x = x;
                                    animal.y = y;
                                    animal.heartRate = heartRate;
                                }
                            }
                        }
                    }
                    if (!occurBefore){
                        if (animalSplit.length == 3){
                            heartRate = 0;
                        }
                        else heartRate = Integer.parseInt(animalSplit[3]);
                        Animal animal = new Animal(name,x,y, heartRate);
                        animalArrayList.add(animal);
                    }
                }
                AnimalTrack animalTrack = new AnimalTrack(id, date, animalArrayList);
                animalTrackArrayList.add(animalTrack);
//                System.out.println("animal list: " + animalTrack.animalArrayList);
//                System.out.println();
            }
        }

        System.out.println("id:");
        String id =  new Scanner(System.in).next();
        for(AnimalTrack animalTrack:animalTrackArrayList){
            if (animalTrack.id.equals(id)){
                System.out.print(animalTrack);
            }
        }
    }



}
