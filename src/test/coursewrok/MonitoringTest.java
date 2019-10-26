package test.coursewrok;

import coursewrok.Earthquake;
import coursewrok.Monitoring;
import coursewrok.Observatory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Tonghui Li
 * @createdTime 2019/10/22
 * @description
 */
class MonitoringTest {

    Observatory observatory1 = new Observatory("ob1","country",2000,123);
    Earthquake earthquake1 = new Earthquake(2,new float[]{12,21},2000,observatory1);
    Earthquake earthquake2 = new Earthquake(3,new float[]{21,12},2001,observatory1);
    Observatory observatory2 = new Observatory("ob2","country",2001,123);
    Earthquake earthquake3 = new Earthquake(4,new float[]{23,32},2002,observatory2);
    Earthquake earthquake4 = new Earthquake(5,new float[]{32,23},2003,observatory2);
    Monitoring monitoring = new Monitoring();


    @BeforeEach
    public void before(){
        System.out.println("before");
        monitoring.addObservatory(observatory1);
        monitoring.addObservatory(observatory2);
    }

    @Test
    void largestAvgMaObservatory() {
        assertEquals(observatory2,monitoring.largestAvgMaObservatory());
    }

    @Test
    void greaterEarthquakes() {
        assertEquals(new ArrayList<Earthquake>(Arrays.asList(earthquake3,earthquake4)),monitoring.greaterEarthquakes(3));
    }


}