package Data;

import java.util.Arrays;
import java.util.Date;

public class Data {
    private ThanhPho city;
    private List[] list;


    public Data(ThanhPho city, List[] list) {
        this.city = city;
        this.list = list;
    }

    public ThanhPho getCity() {
        return city;
    }

    public void setCity(ThanhPho city) {
        this.city = city;
    }

    public List[] getList() {
        return list;
    }

    public void setList(List[] list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "all{" +
                "city=" + city +
                ", list=" + Arrays.toString(list) +
                '}';
    }
}
