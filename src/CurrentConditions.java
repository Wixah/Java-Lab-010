import java.io.IOException;

/**
 * @author Trevor Hartman
 * @author Rachelle Iloff
 * created 04/08/2023
 * @since version 1.0
 */
//Create a class CurrentConditions.java that implements Display.
//It's update method should update its temperature, humidity, and pressure instance variables from its WeatherStation instance then call the display() method.
//It's display method should simply print out in a well formatted message of this object's: Temperature, Humidity, and Pressure.
public class CurrentConditions implements Display {
    private WeatherStation weatherStation;
    private float temperature;
    private float humidity;

    public CurrentConditions(WeatherStation weatherStation){
        this.weatherStation = weatherStation;
        this.temperature = weatherStation.getTemperature();
        this.humidity = weatherStation.getHumidity();

    }

    @Override
    public void update() throws IOException {
        weatherStation.measure();
        this.temperature = weatherStation.getTemperature();
        this.humidity = weatherStation.getHumidity();
    }

    @Override
    public void display() {
        System.out.printf("Current Conditions are...\tTemperature: %.2f\tHumidity: %.2f\n",this.temperature, this.humidity);

    }
}
