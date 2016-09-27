public class Animal {
    String name;
    int x;
    int y;
    int heartRate;
    public Animal(String name, int x, int y, int heartRate) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.heartRate = heartRate;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", x=" + x +
                ", y=" + y +
                ", heartRate=" + heartRate +
                '}';
    }
}
