import java.io.File;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Map.Entry;

import javax.lang.model.util.ElementScanner14;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/*
   To compile: javac SpotifyLikeApp.java
   To run: java SpotifyLikeApp
*/

// declares a class for the app
public class SpotifyLikeApp {
    
    // global variables for the app
    String status;
    Long position;
    static Clip audioClip;
static HashMap<String, Song> song = new HashMap<>();
private static HashMap<String, Song> songs;
   // "main" makes this class a java app that can be executed
   public static void main(String[] args) {
       Song s = new Song();
           s.setArtist("CKay - Love Nwantiti.wav");
           s.setTitle("Love Nwantiti");
           s.setYear("2020");
           s.setGenre("Pop");
           s.setFilePath("./love/CKay - Love Nwantiti.wav");
           songs.put((String) s.getTitle(), s);

           s = new Song();
           s.setArtist("Migos - T-Shirt ");
           s.setTitle("T-Shirt");
           s.setYear("2018");
           s.setGenre("Pop");
           s.setFilePath("./love/Migos - T-Shirt .wav");
           songs.put((String) s.getTitle(), s);

           s = new Song();
           s.setArtist("Dj khalid- hold you down");
           s.setTitle("hold you down");
           s.setYear("2015");
           s.setGenre("Pop");
           s.setFilePath("./love/Dj khalid- hold you down.wav");
           songs.put((String) s.getTitle(), s);
        // create a scanner for user input
        Scanner input = new Scanner(System.in);

        String userInput = "";
        while (!userInput.equals("q")) {
            
            menu();

            // get input
            userInput = input.nextLine();

            // accept upper or lower case commands
            userInput.toLowerCase();

            // do something
            handleMenu(userInput);
        }

        /// close the scanner 
        input.close();

   }
   
    /*
    * displays the menu for the app
    */
    private static void menu() {

        System.out.println("---- SpotifyLikeApp ----");
        System.out.println("[H]ome");
        System.out.println("[S]earch by title");
        System.out.println("[L]ibrary");
        System.out.println("[P]lay");
        System.out.println("[Q]uit");
        System.out.println("");

        System.out.println("");
        System.out.println("Please press the first letter of the menu screen.");
    }

    /*
     * handles the user input for the app
     */
    private static void handleMenu(String userInput) {

        switch (userInput) {
            case "h":
                System.out.println("-->Home<--");            
                break;
            case "s":
                System.out.println("-->Search by title<--");
                Scanner input = new Scanner(System.in);
                System.out.println("Please enter the title");
                String title = input.nextLine();
                Song song = songs.get(title);
                
                if (song !=null) 
                {
                    System.out.println("Your current selection is now playing");
                    play((String) song.getFilePath());
                    
                }else {
                    System.out.println("Sorry, please search again.");
            }
                break;

                case "l":
                System.out.println("-->Library<--");
                for(Entry<String, Song> s : songs.entrySet()){
                    System.out.println("Title: " + s.getValue().getTitle());
                    System.out.println("Artist: " + s.getValue().getArtist());
                    System.out.println("Gemre: " + s.getValue().getGenre());
                    System.out.println("Year: " + s.getValue().getYear());
                    System.out.println("");
                }

                break;

            case "p":
                System.out.println("-->Play<--");
                break;

            case "q":
                System.out.println("-->Quit<--");
                break;

            default:
                break;
            
        }
    }
    /*
     * plays an audio file
     */

    private static void play(String object) {

        // open the audio file
        final File file = new File(object);


        try {
            // create clip
            audioClip = AudioSystem.getClip();

            // get input stream
            final AudioInputStream in = getAudioInputStream(file);

            audioClip.open(in);
            audioClip.setMicrosecondPosition(0);
            audioClip.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static AudioInputStream getAudioInputStream(File file) {
        return null;
    }
     
    



}
