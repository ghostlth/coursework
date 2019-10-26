package test.coursewrok;

import coursewrok.Earthquake;
import coursewrok.Observatory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Tonghui Li
 * @createdTime 2019/10/22
 * @description
 */
class ObservatoryTest {

    Observatory observatory1 = new Observatory("ob","country",2000,123);
    Earthquake earthquake1 = new Earthquake(2,new float[]{12,21},2000,observatory1);
    Earthquake earthquake2 = new Earthquake(3,new float[]{21,12},2001,observatory1);

    @org.junit.jupiter.api.Test
    void largestMaEQ() {
        this.observatory1.setEarthquakeList(new ArrayList<Earthquake>(Arrays.asList(earthquake1,earthquake2)));
        assertEquals(earthquake2,this.observatory1.largestMaEQ());
        Observatory observatory = new Observatory("ob1","country",123,123);
        assertEquals(null,observatory.largestMaEQ());
    }

    @org.junit.jupiter.api.Test
    void averageMa() {
        assertEquals(2.5,observatory1.averageMa());
    }

    @org.junit.jupiter.api.Test
    void greaterEarthquakes() {
        List<Earthquake> earthquakes = new ArrayList<>(Arrays.asList(earthquake1,earthquake2));
        assertEquals(earthquakes,observatory1.greaterEarthquakes(1));
    }
}