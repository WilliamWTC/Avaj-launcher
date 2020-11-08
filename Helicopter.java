public class Helicopter extends Aircraft implements Flyable {

    private WeatherTower weatherTower;

    Helicopter(String name, Coordinates Coordinates)
    {
        super(name, Coordinates);
    }

    private String craftID()
    {
		return ("Helicopter#" + this.name + "(" + this.id + "): ");
    }
    
    public void updateCondition()
    {
        String weather = this.weatherTower.getWeather(this.coordinates);
        if (weather.equals("RAIN"))
        {
            this.coordinates.setLongitude(this.coordinates.getLongitude() + 5);
            weatherTower.writeToFile(craftID() + "(rain) The heavens are open.\n");
        }
        else if (weather.equals("SNOW"))
        {
            this.coordinates.setHeight(this.coordinates.getHeight() - 12);
            weatherTower.writeToFile(craftID() + "(snow) Hell has frozen over.\n");
        }
        else if(weather.equals("SUN"))
        {
            this.coordinates.setLongitude(this.coordinates.getLongitude() + 10);
            this.coordinates.setHeight(this.coordinates.getHeight() + 2);
            weatherTower.writeToFile(craftID() + "(sun) Bask in the suns rays.\n");
        }
        else if (weather.equals("FOG"))
        {
            this.coordinates.setLongitude(this.coordinates.getLongitude() + 1);
            weatherTower.writeToFile(craftID() + "(fog) synonym for mist.\n");
        }
        if (this.coordinates.getHeight() > 100)
            this.coordinates.setHeight(100);
        else if (this.coordinates.getHeight() <= 0)
        {
            this.weatherTower.unregister(this);
            weatherTower.writeToFile(craftID() + " landing.\n");
            weatherTower.writeToFile("Tower says: " + craftID() + " unregistered from weather tower.\n");
        }
    }

    public void registerTower(WeatherTower weatherTower)
    {
        this.weatherTower = weatherTower;
        this.weatherTower.register(this);
        weatherTower.writeToFile("Tower says: " + craftID() + " registered to weather tower.\n");
    }
}