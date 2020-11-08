public abstract class AircraftFactory
{
    public static Flyable newAircraft(String type, String name, int longitude, int latitude, int height)
    {
        Coordinates Coordinates = new Coordinates(longitude, latitude, height);

        switch (type)
        {
            case "Helicopter":
                return new Helicopter(name, Coordinates);
            case "JetPlane":
                return new JetPlane(name, Coordinates);
            case "Baloon":
                return new Baloon(name, Coordinates);
            default:
                return null;
        }
    }
}