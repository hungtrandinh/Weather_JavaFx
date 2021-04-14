package Data;

import java.text.SimpleDateFormat;
import java.util.Arrays;

public class List {
    private Maiin main;
    private Weather[] weather;
    private Clouds clouds;
    private Wind wind;
    private String dt_txt;

    public List(Maiin main, Weather[] weather, Clouds clouds, Wind wind, String dt_txt) {
        this.main = main;
        this.weather = weather;
        this.clouds = clouds;
        this.wind = wind;
        this.dt_txt = dt_txt;
    }


    public Maiin getMain() {
        return main;
    }

    public void setMain(Maiin main) {
        this.main = main;
    }

    public Weather[] getWeather() {
        return weather;
    }

    public void setWeather(Weather[] weather) {
        this.weather = weather;
    }

    public Clouds getClouds() {
        return clouds;
    }

    public void setClouds(Clouds clouds) {
        this.clouds = clouds;
    }

    public Wind getWind() {
        return wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }

    public String getDt_txt() {
        return dt_txt;
    }

    public void setDt_txt(String dt_txt) {
        this.dt_txt = dt_txt;
    }

    @Override
    public String toString() {
        return "List{" +
                "main=" + main +
                ", weather=" + Arrays.toString(weather) +
                ", clouds=" + clouds +
                ", wind=" + wind +
                ", dt_txt='" + dt_txt + '\'' +
                '}';
    }
}
