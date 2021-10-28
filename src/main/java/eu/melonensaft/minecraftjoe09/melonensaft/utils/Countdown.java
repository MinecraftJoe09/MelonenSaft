package eu.melonensaft.minecraftjoe09.melonensaft.utils;

public class Countdown {

    private String name;
    private int time;

    public Countdown(String name, int time) {
        setName(name);
        setTime(time);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
}
