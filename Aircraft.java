public abstract class Aircraft 
{
    protected long id = 1;
    protected String name;
    protected Coordinates coordinates;
    protected static long idCounter = 0l;

    protected Aircraft(String name, Coordinates coordinates)
    {
        this.name = name;
        this.coordinates = coordinates;
        this.id = nextId();
    }

    private long nextId()
    {
        idCounter += 1;
        return (idCounter);
    }
}