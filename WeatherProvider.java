import java.util.Random;

class WeatherProvider {
	private static WeatherProvider weatherprovider = null;
	private static String[] weather = {"RAIN", "FOG", "SUN", "SNOW"};

	private WeatherProvider(){}

	public static WeatherProvider getProvider(){
		if (weatherprovider == null)
			weatherprovider = new WeatherProvider();
		return weatherprovider;
	}

	public String getCurrentWeather(Coordinates coordinates){
		Random rand = new Random(coordinates.getLatitude() * coordinates.getHeight() * coordinates.getLongitude());
		return (weather[rand.nextInt(4)]);
	}
}