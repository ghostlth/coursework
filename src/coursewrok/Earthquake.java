package coursewrok;

/**
 * @author Tonghui Li
 * @version v1.0 2019/10/22
 **/
public class Earthquake implements Comparable<Earthquake>{

    private float magnitude;
    private float[] position;
    private int year;
    private Observatory belongToOb;

    public Earthquake(float magnitude, float[] position, int year,Observatory observatory) {
        this.magnitude = magnitude;
        this.position = position;
        this.year = year;
        this.belongToOb = observatory;
        observatory.getEarthquakeList().add(this);
    }

    public float getMagnitude() {
        return magnitude;
    }

    public void setMagnitude(float magnitude) {
        this.magnitude = magnitude;
    }

    public float[] getPosition() {
        return position;
    }

    public void setPosition(float[] position) {
        this.position = position;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Observatory getBelongToOb() {
        return belongToOb;
    }

    public void setBelongToOb(Observatory belongToOb) {
        this.belongToOb = belongToOb;
        belongToOb.getEarthquakeList().add(this);
    }

    @Override
    public int compareTo(Earthquake earthquake) {
        if (this.magnitude>earthquake.magnitude){
            return 1;
        }else if (this.magnitude<earthquake.magnitude){
            return -1;
        }else {
            return 0;
        }

    }


    @Override
    public String toString() {
        return "Earthquake{" +
                "magnitude=" + magnitude +
                ", position=" + this.position[0]+":"+this.position[1] +
                ", year=" + year +
                ", belongToOb=" + belongToOb.getNameOfOb() +
                '}';
    }
}
