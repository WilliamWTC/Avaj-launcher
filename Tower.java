import java.io.*;
import java.util.*;

public class Tower
{
    private ArrayList<Flyable> observers = new ArrayList<>();
    private FileWriter writer;
    private File file;

    public void register(Flyable flyable)
    {
        if (observers.contains(flyable))
            return;
        else
            observers.add(flyable);
    }

    public void unregister(Flyable flyable)
    {
        if (observers.contains(flyable))
            return;
        else
            observers.remove(flyable);
    }

    public void conditionsChanged()
    {
        for (Flyable flyable : observers)
            flyable.updateCondition();
    }

    public void writeToFile(String text)
    {
        try {
            this.file = new File("simulation.txt");
            this.writer = new FileWriter(file, true);
            this.file.createNewFile();

            try {
                writer.write(text);
                writer.flush();
             }
             catch (Exception e)
            {
                e.printStackTrace();
            }
        } catch (Exception e) {
        }
    }
}