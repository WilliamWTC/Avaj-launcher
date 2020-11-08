public class Baloon extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    Baloon(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    private String craftID() {
		return ("Baloon#" + this.name + "(" + this.id + "): ");
	}

    public void updateCondition()
    {
        String weather = this.weatherTower.getWeather(this.coordinates);
        if (weather.equals("RAIN"))
        {
            this.coordinates.setHeight(this.coordinates.getHeight() - 5);
            weatherTower.writeToFile(craftID() + "(rain) Seems the clouds are taking a leak.\n");
        } else if (weather.equals("SNOW"))
        {
            this.coordinates.setHeight(this.coordinates.getHeight() - 15);
            weatherTower.writeToFile(craftID() + "(snow) Expect that canadian weather.\n");
        } else if (weather.equals("SUN"))
        {
            this.coordinates.setLongitude(this.coordinates.getLongitude() + 2);
            this.coordinates.setHeight(this.coordinates.getHeight() + 4);
            weatherTower.writeToFile(craftID() + "(sun) Its bright and sunny, buddy.\n");
        } else if (weather.equals("FOG"))
        {
            this.coordinates.setHeight(this.coordinates.getHeight() - 3);
            weatherTower.writeToFile(craftID() + "(fog) It's like walking into the unknown.\n");
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

        public void registerTower (WeatherTower weatherTower)
        {
            this.weatherTower = weatherTower;
            this.weatherTower.register(this);
            weatherTower.writeToFile("Tower says: " + craftID() + " registered to weather tower.\n");
        }


}