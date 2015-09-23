import java.util.*;
/**
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.
 * 
 * This class holds an enumeration of all command words known to the game.
 * It is used to recognise commands as they are typed in.
 *
 * @author  Michael Kölling and David J. Barnes
 * @version 2011.08.08
 */

public class CommandWords
{
//     // a constant array that holds all valid command words
//     private static final String[] validCommands = {
//         "go", "quit", "help", "back"
//     };

    // A mapping between a command word and the CommandWord
    // associated with it.
    private HashMap<String, CommandWord> validCommands;
    
    /**
     * Constructor - initialise the command words.
     */
//     public CommandWords()
//     {
//         // nothing to do at the moment...
//     }
    public CommandWords()
    {
            validCommands = new HashMap<String, CommandWord>();
            validCommands.put("gå", CommandWord.GÅ); // Translated to Danish
            validCommands.put("help", CommandWord.HELP);
            validCommands.put("stop", CommandWord.STOP); // Translated to Danish
            validCommands.put("look", CommandWord.LOOK);
            validCommands.put("back", CommandWord.BACK);
    }

//     /**
//      * Check whether a given String is a valid command word. 
//      * @return true if it is, false if it isn't.
//      */
//     public boolean isCommand(String aString)
//     {
//         for(int i = 0; i < validCommands.length; i++) {
//             if(validCommands[i].equals(aString))
//                 return true;
//         }
//         // if we get here, the string was not found in the commands
//         return false;
//     }

    /**
     * Find the CommandWord associated with a command word.
     * @param commandWord The word to look up (as a string).
     * @return The CommandWord correspondng to commandWord, or UNKNOWN
     *         if it is not a valid command word.
     */
    public CommandWord getCommandWord(String commandWord)
    {
        CommandWord command = validCommands.get(commandWord);
        if(command != null) {
            return command;
        }
        else {
            return CommandWord.UNKNOWN;
        }
    }

    /**
     * Check whether a given String is a valid command word. 
     * @return true if it is, false if it isn't.
     */
    public boolean isCommand(String aString)
    {
        return validCommands.containsKey(aString);
    }
    
//     /**
//      * Print all valid commands to System.out.
//      */
//     public void showAll() 
//     {
//         for(String command: validCommands) {
//             System.out.print(command + "  ");
//         }
//         System.out.println();
//     }
    /**
     * Print all valid commands to System.out.
     */
    public void showAll() 
    {
        for(String command : validCommands.keySet()) {
            System.out.print(command + "  ");
        }
        System.out.println();
    }
}
