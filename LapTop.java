
public class LapTop {
    String ram;
    String hdd;
    String os;
    String color;

    LapTop(String ram, String hdd, String os, String color) {
        this.ram = ram;
        this.hdd = hdd;
        this.os = os;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Laptop [RAM=" + ram + ", HDD=" + hdd + ", OS=" + os + ", Color=" + color + "]";
    }
}
