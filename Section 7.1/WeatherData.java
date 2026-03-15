import java.util.ArrayList;

public class WeatherData {

    /** Guaranteed not to be null and to contain only non-null entries */
    private ArrayList<Double> temperatures;
    
    public WeatherData(ArrayList<Double> data) {
        temperatures = data;
    }

    /**
    * Cleans the data by removing from temperatures all values that are less than
    * lower and all values that are greater than upper, as described in part (a) */
    public void cleanData(double lower, double upper) { 
        int index = 0;
        while (index < temperatures.size()) {
            if ((temperatures.get(index) < lower) || (temperatures.get(index) > upper)) {
                temperatures.remove(index);
                continue;
            }

            index++;
        }
    }

    /**
    * Returns the length of the longest heat wave found in temperatures, as described in
    * part (b)
    * Precondition: There is at least one heat wave in temperatures based on threshold. */
    public int longestHeatWave(double threshold) { 
        int longestHeatWave = 0;
        int currentHeatWave = 0;

        for (int i = 0; i < temperatures.size(); i++) {
            if (temperatures.get(i) < threshold) {
                if (currentHeatWave > longestHeatWave) longestHeatWave = currentHeatWave;
                currentHeatWave = 0;
            } else {
                currentHeatWave++;
            }
        }

        return longestHeatWave;
    }

    @Override
    public String toString() {
        return temperatures.toString();
    }

    public static void main(String[] args) {
        ArrayList<Double> temps = new ArrayList<Double>();
        temps.add(99.1);
        temps.add(142.0);
        temps.add(85.0);
        temps.add(85.1);
        temps.add(84.6);
        temps.add(94.3);
        temps.add(124.9);
        temps.add(98.0);
        temps.add(101.0);
        temps.add(102.5);
        WeatherData wdObject = new WeatherData(temps);
        System.out.println(wdObject);
        wdObject.cleanData(85.0, 120.0);
        System.out.println(wdObject);

        temps = new ArrayList<Double>();
        temps.add(100.5);
        temps.add(98.5);
        temps.add(102.0);
        temps.add(103.9);
        temps.add(87.5);
        temps.add(105.2);
        temps.add(90.3);
        temps.add(94.8);
        temps.add(109.1);
        temps.add(102.1);
        temps.add(107.4);
        temps.add(93.2);
        wdObject = new WeatherData(temps);
        System.out.println(wdObject);
        System.out.println(wdObject.longestHeatWave(100.5));
        System.out.println(wdObject.longestHeatWave(95.2));

    }
}