package coursewrok;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Tonghui Li
 * @version v1.0 2019/10/22
 */
public class Monitoring {

    List<Observatory> observatoryList = new ArrayList<>();

    /**
     * add observatory to observatoryList
     * @param observatory the new observatory
     */
    public void addObservatory(Observatory observatory){
        this.observatoryList.add(observatory);
    }

    /**
     * return the observatory with largest average magnitude
     * @return coursewrok.Observatory
     */
    public Observatory largestAvgMaObservatory(){
        if (observatoryList.size()==0) return null;
        Observatory temp = observatoryList.get(0);
        for (Observatory observatory:observatoryList){
            if (temp.averageMa()<observatory.averageMa()){
                temp = observatory;
            }
        }
        return temp;
    }

    /**
     * return list of earthquakes with magnitude greater than a given number
     * @param m the given number
     * @return List
     */
    public List<Earthquake> greaterEarthquakes(float m){
        List<Earthquake> earthquakes = new ArrayList<>();
        for (Observatory observatory:observatoryList){
            earthquakes.addAll(observatory.greaterEarthquakes(m));
        }
        return earthquakes;
    }

    /**
     * the menu to choice which option user need
     */
    public void menu() {
        System.out.println("==================choice method==================");
        System.out.println("==      1:enter observatory data(input:'1')    ==");
        System.out.println("==      2:enter earthquake data(input:'2')     ==");
        System.out.println("==            3:get information                ==");
        System.out.println("==            input 'q' to exit                ==");
        System.out.println("=================================================");
        System.out.print(">");
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextLine()){
            String str = scanner.nextLine();
            switch (str){
                case "1":
                    enterObservatoryData();
                    break;
                case "2":
                    enterEarthquakeData();
                    break;
                case "3":
                    //get information
                    statics();
                    break;
                case "q":
                    System.exit(-1);
            }
        }
    }


    /**
     * method to enter observatory data
     */
    public void enterObservatoryData(){

        System.out.println("input data of observatory in the form like 'nameOfObservatory|nameOfCountry|startYear|coveredArea'");
        Scanner scanner1 = new Scanner(System.in);
        if (scanner1.hasNextLine()){
            String str1 = scanner1.nextLine();
            String[] strings = str1.split("\\|");
            if (strings.length==4){
                String nameOfOb = strings[0];
                String nameOfCountry = strings[1];
                try {
                    int startYear = Integer.parseInt(strings[2]);
                    float coveredArea = Float.parseFloat(strings[3]);
                    Observatory observatory = new Observatory(nameOfOb,nameOfCountry,startYear,coveredArea);
                    if (observatoryList.contains(observatory)){
                        System.out.println("the data of this observatory has already been inputted, please recheck");
                        return;
                    }
                    this.addObservatory(observatory);
                    System.out.println("enter data success");
                }catch (NumberFormatException e){
                    System.out.println("data format error, please recheck");
                    return;
                }
            }else {
                System.out.println("wrong data, please recheck");
            }
        }
    }

    /**
     * method to enter earthquake data
     */
    public void enterEarthquakeData() {
        System.out.println("input data of earthquake in the form like 'magnitude|position(e.g 222:555)|year|observatory'");
        Scanner scanner = new Scanner(System.in);

        if (scanner.hasNextLine()){
            String str = scanner.nextLine();
            String[] strings = str.split("\\|");
            if (strings.length==4){
                try {
                    float magnitude = Float.parseFloat(strings[0]);
                    String[] positions = strings[1].split(":");
                    if (positions.length!=2){
                        System.out.println("wrong data, please recheck");
                        return;
                    }
                    float[] position = new float[]{Float.parseFloat(positions[0]), Float.parseFloat(positions[1])};
                    int year = Integer.parseInt(strings[2]);
                    String strObservatory = strings[3];
                    Observatory observatory = null;
                    for (Observatory ob:this.observatoryList){
                        if (ob.getNameOfOb().equals(strObservatory)){
                            observatory = ob;
                        }
                    }
                    if (observatory!= null){
                        new Earthquake(magnitude,position,year,observatory);
                        System.out.println("enter data success");
                    }else {
                        System.out.println("cannot find the observatory, please recheck the detail of earthquake or enter the data of observatory first");
                    }
                }catch (NumberFormatException e){
                    System.out.println("data format error, please recheck");
                    return;
                }
            }else {
                System.out.println("wrong data, please recheck");
            }
        }
    }
    

    /**
     * method to provide statistics
     */
    public void statics() {
        System.out.println("=================choice which data you want:================");
        System.out.println("==  1:the observatory with the largest average earthquake ==");
        System.out.println("==               2:largest earthquake ever                ==");
        System.out.println("==3:earthquakes with magnitude greater than a given number==");
        System.out.println("==                 q:return to top menu                   ==");
        System.out.println("============================================================");
        System.out.print(">");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        switch (str){
            case "1":
                System.out.println(this.largestAvgMaObservatory());
                statics();
                break;
            case "2":
                float ma = 0f;
                Earthquake eq = null;
                for (Observatory observatory:observatoryList){
                    if (observatory.largestMaEQ()!=null){
                        if (ma<observatory.largestMaEQ().getMagnitude()){
                            ma = observatory.largestMaEQ().getMagnitude();
                            eq = observatory.largestMaEQ();
                        }
                    }
                }
                System.out.println(eq);
                statics();
                break;
            case "3":
                System.out.println("input the number:");
                Scanner scanner1 = new Scanner(System.in);
                try {
                    float num = Float.parseFloat(scanner1.nextLine());
                    System.out.println(this.greaterEarthquakes(num));
                }catch (NumberFormatException e){
                    System.out.println("the input is not a correct number");
                }finally {
                    statics();
                }
            case "q":
                menu();
        }
    }
}
