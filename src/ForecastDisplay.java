import java.io.IOException;

/**
 * @author Trevor Hartman
 * @author Rachelle Iloff
 * created 04/08/2023
 * @since version 1.0
 */
//Create a class ForecastDisplay.java that implements Display.
//It's update method should keep track of the last and current pressure in instance variables lastPressure and currentPressure
//It's display method should use the following algorithm to provide a forecast.
//System.out.print("Forecast: ");
//if (currentPressure > lastPressure) {
//    System.out.println("Improving weather on the way!");
//} else if (currentPressure == lastPressure) {
//    System.out.println("More of the same");
//} else if (currentPressure < lastPressure) {
//    System.out.println("Watch out for cooler, rainy weather");
//}
public class ForecastDisplay implements Display {
    private WeatherStation weatherStation;
    private float lastPressure;
    private float currentPressure;
    public ForecastDisplay (WeatherStation weatherStation) {
         this.weatherStation = weatherStation;
         this.currentPressure = weatherStation.getPressure();
         this.lastPressure = weatherStation.getPressure();
    }
    @Override
    public void update() throws IOException {
        weatherStation.measure();
    this.lastPressure = this.currentPressure;
    this.currentPressure = weatherStation.getPressure();

    }
    @Override
    public void display() {
        System.out.print("Forecast: ");
        if (currentPressure > lastPressure) {
            System.out.println("Improving weather on the way!");
        } else if (currentPressure == lastPressure) {
            System.out.println("More of the same");
        } else if (currentPressure < lastPressure) {
            System.out.println("Watch out for cooler, rainy weather");
        }

    }
}
