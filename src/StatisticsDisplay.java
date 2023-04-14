import java.io.IOException;

/**
 * @author Trevor Hartman
 * @author Rachelle Iloff
 * created 04/08/2023
 * @since version 1.0
 */
//Create a class StatisticsDisplay.java that implements Display.
//It's update method should update instance variables temperatureMin, temperatureMax, tempRunningTotal, and numReadings
//It's display method should print out the min, max, and average temperature values.
public class StatisticsDisplay implements Display {
    private WeatherStation weatherStation;

    private float temperatureMin;
    private float temperatureTotal;
    private int numReadings;
    private float temperatureMax;
    private float tempHolder;

    public StatisticsDisplay(WeatherStation weatherStation){
        this.weatherStation = weatherStation;
        this.temperatureMin = weatherStation.getTemperature();
        this.temperatureMax = weatherStation.getTemperature();
        this.temperatureTotal = weatherStation.getTemperature();
        this.numReadings = 1;

    }

    @Override
    public void update() throws IOException {
        weatherStation.measure();
        this.numReadings += 1;
        float tempHolder = weatherStation.getTemperature();
        this.temperatureTotal += tempHolder;
        if(tempHolder > this.temperatureMax){
            this.temperatureMax = tempHolder;
        }
        if(tempHolder < this.temperatureMin){
            this.temperatureMin = tempHolder;
        }

    }

    @Override
    public void display() {
        System.out.printf("The temperature max is %.2f\tThe temperature min is %.2f\tThe average of all temperatures is %.2f\n", this.temperatureMax, this.temperatureMin, this.tempHolder/this.numReadings);

    }
}
