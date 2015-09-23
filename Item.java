
/**
 * Write a description of class Item here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Item
{
    // instance variables - replace the example below with your own
    private String name, description;    
    private int weight;

    /**
     * Constructor for objects of class Item
     */
    public Item(String name, String description, int weight)
    {
        // initialise instance variables
        this.name = name;
        this.description = description;
        this.weight = weight;
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public String getName()
    {
        // put your code here
        return name;
    }
    public String getDescription()
    {
        // put your code here
        return description;
    }
    public int getWeight()
    {
        // put your code here
        return weight;
    }
}
