import java.util.ArrayList;

/**
 * A class to hold details of audio files.
 * This version can play the files.
 * 
 * @author David J. Barnes and Michael Kölling
 * @version 2011.07.31
 */
public class MusicOrganizer
{
    // An ArrayList for storing the file names of music files.
    private ArrayList<String> files;
    // A player for the music files.
    private MusicPlayer player;

    /**
     * Create a MusicOrganizer
     */
    public MusicOrganizer()
    {
        files = new ArrayList<String>();
        player = new MusicPlayer();
    }

    /**
     * Add a file to the collection.
     * @param filename The file to be added.
     */
    public void addFile(String filename)
    {
        files.add(filename);
    }

    /**
     * Return the number of files in the collection.
     * @return The number of files in the collection.
     */
    public int getNumberOfFiles()
    {
        return files.size();
    }

    /**
     * List a file from the collection.
     * @param index The index of the file to be listed.
     */
    public void listFile(int index)
    {
        if(index >= 0 && index < files.size()) {
            String filename = files.get(index);
            System.out.println(filename);
        }
    }

    /**
     * Remove a file from the collection.
     * @param index The index of the file to be removed.
     */
    public void removeFile(int index)
    {
        if(index >= 0 && index < files.size()) {
            files.remove(index);
        }
    }

    /**
     * Start playing a file in the collection.
     * Use stopPlaying() to stop it playing.
     * @param index The index of the file to be played.
     */
    public void startPlaying(int index)
    {
        String filename = files.get(index);
        player.startPlaying(filename);
    }

    /**
     * Stop the player.
     */
    public void stopPlaying()
    {
        player.stop();
    }

    /**
     * Show a list of all the files.
     */
    public void listAllFiles()
    {
        int position = 1;
        for (String filename : files){
            System.out.println(position + ": " + filename);
            position++;
        }
    }

    /**
     * Show a list of all the files that match with the specified String.
     */
    public void listMatching(String searchString)
    {
        boolean coincidence = false;
        for (String filename : files){
            if (filename.contains(searchString)){
                System.out.println(filename);
                coincidence = true;
            }
        }
        if (!coincidence){
            System.out.println("No se ha encontrado coincidencia");
        }
    }
    
    /**
     * Play a few seconds of all the songs of a specified artist.
     */
    public void playArtistMatching(String artist)
    {
        for (String filename : files){
            if (filename.contains(artist)){
                player.playSample(filename);
            }
        }
    }
    
    /**
     * Localizar el indice del primer archivo que se corresponde con la cadena de busqueda indicada"
     */
    public int findFirst (String searchString){
        int index = 0;
        boolean searching = true;
        int numFiles = files.size();
        while (searching && index < numFiles){
            String filename = files.get(index);
            if (filename.contains(searchString)){
                searching = false;
            }
            else {
                index++;
            }
        }
        if (searching){
            index = -1;
        }
        return index;
    }
}
