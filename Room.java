import java.util.Set;
import java.util.HashMap;

/**
 * Class Room - a room in an adventure game.
 *
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 *
 * A "Room" represents one location in the scenery of the game.  It is 
 * connected to other rooms via exits.  For each existing exit, the room 
 * stores a reference to the neighboring room.
 * 
 * @author  Michael Kölling and David J. Barnes
 * @version 2011.08.08
 */

public class Room 
{
    private String description;
    private HashMap<String, Room> exits; // stores exits of this room.
    private HashMap<String, Item> items; // stores items in the room added to satisfy 6.22
    
    /**
     * Create a room described "description". Initially, it has
     * no exits. "description" is something like "a kitchen" or
     * "an open court yard".
     * @param description The room's description.
     */
    public Room(String description) 
    {
        this.description = description;
        exits = new HashMap<String, Room>();
        items = new HashMap<String, Item>(); // we instaniate the item list along with the rooms
    }

    /**
     * Define an exit from this room.
     * @param direction The direction of the exit.
     * @param neighbor  The room to which the exit leads.
     */
    public void setExit(String direction, Room neighbor) 
    {
        exits.put(direction, neighbor);
    }
    /**
     * Define an item in this room.
     * @param name The name of the item.
     * @param item The item the name refers to.
     */
    public void addItem(String name, Item item) {
        items.put(name, item);
    }

    /**
     * @return The short description of the room
     * (the one that was defined in the constructor of the room).
     */
    public String getShortDescription()
    {
        return description;
    }

    /**
     * Return a description of the room, along with any items in it, in the form:
     *     You are in the kitchen.
     *     There is the following items: knife.
     *     Exits: north west
     * @return A long description of this room
     */
    // Room is the only object that we are certain keeps a list of all items in the room. Thus we list it in the long description.
    // Game currently creates the items but we may want players to be able to drop items or some kind of trigger to create a new item.
    // For this reason Game does not create the description.
    // If the longDescription is too long one might want to make a mediumDescription
    public String getLongDescription()
    {
        return "You are " + description + ".\n " + getFullItemDescriptionList() + ".\n "  + getExitString();
    }

    /**
     * Return a string describing the room's exits, for example
     * "Exits: north west".
     * @return Details of the room's exits.
     */
    private String getExitString()
    {
        String returnString = "Exits:";
        Set<String> keys = exits.keySet();
        for(String exit : keys) {
            returnString += " " + exit;
        }
        return returnString;
    }
    /**
     * Return a string describing the room's items, example:
     * "There is the following item(s): torch dagger".
     * @return Details of the room's items.
     */
    // this does not return item descriptions only the name, descriptions might be too long.
    private String getItemList() {
        String returnString = "There is the following item(s):";
        
        Set<String> keys = items.keySet();
            for(String itemName : keys) {
                returnString += " " + items.get(itemName).getName(); // gets the actual name of the item not its assigned key. Might be relevant if it isnt axe but Axe of Doom
            }

     // Set<String> keys = items.keySet();
     //     for(String itemName : keys) {
     //         returnString += " " + itemName.getName();
     //     }
        return returnString;
    }
    /** Returns a list of item descriptions. Added for posterity. */
    private String getItemDescriptionList() {
        String returnString = "There is the following item(s):";
        
        Set<String> keys = items.keySet();
            for(String itemName : keys) {
                returnString += " " + items.get(itemName).getDescription();
            }
        return returnString;
    }
    /** Returns a list of the complete item descriptions. */ // added because I only noticed the 
    private String getFullItemDescriptionList() {
        String returnString = "There is the following item(s): \n";
        
        Set<String> keys = items.keySet();
            for(String itemName : keys) {
                Item i = items.get(itemName);
                returnString += " " + i.getName() + ", " + i.getDescription() + ", weight " + i.getWeight() + "\n";
            }
        return returnString;
    }
    
    /**
     * Return the room that is reached if we go from this room in direction
     * "direction". If there is no room in that direction, return null.
     * @param direction The exit's direction.
     * @return The room in the given direction.
     */
    public Room getExit(String direction) 
    {
        return exits.get(direction);
    }
    public Item getItem(String name) {
        return items.get(name);
    }
}

