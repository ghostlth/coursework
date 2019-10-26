package coursewrok;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * @author Tonghui Li
 * @version v1.0 2019/10/22
 */
public class Observatory {
    private String nameOfOb;
    private String nameOfCountry;
    private int startYear;
    private float coveredArea;
    private List<Earthquake> earthquakeList = new ArrayList<>();

    public Observatory(String nameOfOb, String nameOfCountry, int startYear, float coveredArea, List<Earthquake> earthquakeList) {
        this.nameOfOb = nameOfOb;
        this.nameOfCountry = nameOfCountry;
        this.startYear = startYear;
        this.coveredArea = coveredArea;
        this.earthquakeList = earthquakeList;
    }

    public Observatory(String nameOfOb, String nameOfCountry, int startYear, float coveredArea) {
        this.nameOfOb = nameOfOb;
        this.nameOfCountry = nameOfCountry;
        this.startYear = startYear;
        this.coveredArea = coveredArea;
    }

    public String getNameOfOb() {
        return nameOfOb;
    }

    public void setNameOfOb(String nameOfOb) {
        this.nameOfOb = nameOfOb;
    }

    public String getNameOfCountry() {
        return nameOfCountry;
    }

    public void setNameOfCountry(String nameOfCountry) {
        this.nameOfCountry = nameOfCountry;
    }

    public int getStartYear() {
        return startYear;
    }

    public void setStartYear(int startYear) {
        this.startYear = startYear;
    }

    public float getCoveredArea() {
        return coveredArea;
    }

    public void setCoveredArea(float coveredArea) {
        this.coveredArea = coveredArea;
    }

    public List<Earthquake> getEarthquakeList() {
        return earthquakeList;
    }

    public void setEarthquakeList(List<Earthquake> earthquakeList) {
        this.earthquakeList = earthquakeList;
    }

    /**
     * return largest magnitude earthquake
     * @return Earthquake
     */
    public Earthquake largestMaEQ(){
        if (earthquakeList.size()==0) return null;
        Collections.sort(earthquakeList);
        return earthquakeList.get(earthquakeList.size()-1);
    }

    /**
     * return average earthquake magnitude
     * @return float
     */
    public float averageMa(){
        float sum = 0f;
        for (Earthquake e:earthquakeList) {
            sum += e.getMagnitude();
        }
        return sum/earthquakeList.size();
    }

    /**
     * return list of earthquakes with magnitude greater than a given number
     * @param magnitude the given number
     * @return List
     */
    public List<Earthquake> greaterEarthquakes(float magnitude){
        List<Earthquake> earthquakes = new ArrayList<>();
        for (Earthquake earthquake:earthquakeList){
            if (earthquake.getMagnitude()>magnitude){
                earthquakes.add(earthquake);
            }
        }
        return earthquakes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Observatory that = (Observatory) o;
        return nameOfOb.equals(that.nameOfOb) &&
                nameOfCountry.equals(that.nameOfCountry);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nameOfOb, nameOfCountry);
    }

    @Override
    public String toString() {
        return "Observatory{" +
                "nameOfOb='" + nameOfOb + '\'' +
                ", nameOfCountry='" + nameOfCountry + '\'' +
                ", startYear=" + startYear +
                ", coveredArea=" + coveredArea +
                ", earthquakeList=" + earthquakeList +
                '}';
    }
}
