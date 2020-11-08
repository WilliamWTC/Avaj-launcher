public class JetPlane extends Aircraft implements Flyable{
    private WeatherTower weatherTower;

    JetPlane(String name, Coordinates coordinates)
    {
        super(name, coordinates);
    }

    private String craftID()
    {
		return ("JetPlane#" + this.name + "(" + this.id + "): ");
    }

    public void updateCondition()
    {
        String weather = this.weatherTower.getWeather(this.coordinates);
        if (weather.equals("RAIN"))
        {
            this.coordinates.setLatitude(this.coordinates.getLatitude() + 5);
            weatherTower.writeToFile(craftID() + "(rain) Water in the skies captain.\n");
        }
        else if (weather.equals("SNOW"))
        {
            this.coordinates.setHeight(this.coordinates.getHeight() - 7);
            weatherTower.writeToFile(craftID() + "(snow) Snowflakes incoming captain.\n");
        }
        else if (weather.equals("SUN"))
        {
            this.coordinates.setLatitude(this.coordinates.getLongitude() + 10);
            this.coordinates.setHeight(this.coordinates.getHeight() + 2);
            weatherTower.writeToFile(craftID() + "(sun) Rays of sun shine captain.\n");
        }
        else if (weather.equals("FOG"))
        {
            this.coordinates.setLatitude(this.coordinates.getLatitude() + 1);
            weatherTower.writeToFile(craftID() + "(fog) Its like navigating through the unknown.\n");
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