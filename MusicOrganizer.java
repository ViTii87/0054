import java.util.ArrayList;
import java.util.Iterator;

/**
 * A class to hold details of audio tracks.
 * Individual tracks may be played.
 * 
 * @author David J. Barnes and Michael Kölling
 * @version 2011.07.31
 */
public class MusicOrganizer
{
    // An ArrayList for storing music tracks.
    private ArrayList<Track> tracks;
    // A player for the music tracks.
    private MusicPlayer player;
    // A reader that can read music files and load them as tracks.
    private TrackReader reader;
    // Atributo para saber si se esta reproduciendo una cancion.
    private boolean isPlay;
    // Atributo iterador
    private Iterator<Track> it;

    /**
     * Create a MusicOrganizer
     */
    public MusicOrganizer()
    {
        tracks = new ArrayList<Track>();
        player = new MusicPlayer();
        reader = new TrackReader();
        isPlay = false;
        readLibrary("audio");
        System.out.println("Music library loaded. " + getNumberOfTracks() + " tracks.");
        System.out.println();
    }

    /**
     * Add a track file to the collection.
     * @param filename The file name of the track to be added.
     */
    public void addFile(String filename)
    {
        tracks.add(new Track(filename));
    }

    /**
     * Add a track to the collection.
     * @param track The track to be added.
     */
    public void addTrack(Track track)
    {
        tracks.add(track);
    }

    /**
     * Play a track in the collection.
     * @param index The index of the track to be played.
     */
    public void playTrack(int index)
    {
        if(!isPlay){
            if(indexValid(index)) {
                Track track = tracks.get(index);
                player.startPlaying(track.getFilename());
                System.out.println("Now playing: " + track.getArtist() + " - " + track.getTitle());
                track.addPlayCount();
                isPlay = true;
            }
        }
        else{
            isPlaying();
        }
    }

    /**
     * Return the number of tracks in the collection.
     * @return The number of tracks in the collection.
     */
    public int getNumberOfTracks()
    {
        return tracks.size();
    }

    /**
     * List a track from the collection.
     * @param index The index of the track to be listed.
     */
    public void listTrack(int index)
    {
        System.out.print("Track " + index + ": ");
        Track track = tracks.get(index);
        System.out.println(track.getDetails());
    }

    /**
     * Show a list of all the tracks in the collection.
     */
    public void listAllTracks()
    {
        System.out.println("Track listing: ");

        for(Track track : tracks) {
            System.out.println(track.getDetails());
        }
        System.out.println();
    }

    /**
     * List all tracks by the given artist.
     * @param artist The artist's name.
     */
    public void listByArtist(String artist)
    {
        for(Track track : tracks) {
            if(track.getArtist().contains(artist)) {
                System.out.println(track.getDetails());
            }
        }
    }

    /**
     * Remove a track from the collection.
     * @param index The index of the track to be removed.
     */
    public void removeTrack(int index)
    {
        if(indexValid(index)) {
            tracks.remove(index);
        }
    }

    /**
     * Play the first track in the collection, if there is one.
     */
    public void playFirst()
    {
        if(!isPlay){
            if(tracks.size() > 0) {
                player.startPlaying(tracks.get(0).getFilename());
                tracks.get(0).addPlayCount();
                isPlay = true;
            }
        }
        else{
            isPlaying();
        }
    }

    /**
     * Stop the player.
     */
    public void stopPlaying()
    {
        player.stop();
        isPlay = false;
    }

    /**
     * Determine whether the given index is valid for the collection.
     * Print an error message if it is not.
     * @param index The index to be checked.
     * @return true if the index is valid, false otherwise.
     */
    private boolean indexValid(int index)
    {
        // The return value.
        // Set according to whether the index is valid or not.
        boolean valid;

        if(index < 0) {
            System.out.println("Index cannot be negative: " + index);
            valid = false;
        }
        else if(index >= tracks.size()) {
            System.out.println("Index is too large: " + index);
            valid = false;
        }
        else {
            valid = true;
        }
        return valid;
    }

    private void readLibrary(String folderName)
    {
        ArrayList<Track> tempTracks = reader.readTracks(folderName, ".mp3");

        // Put all thetracks into the organizer.
        for(Track track : tempTracks) {
            addTrack(track);
        }
    }

    /**
     * Metodo que muestra la informacion de los titulos que contengan el nombre de la cancion pasador por parametro.
     */
    public void findInTitle(String nombreCancion){
        for(Track track : tracks) {
            if(track.getTitle().contains(nombreCancion)) {
                System.out.println(track.getDetails());
            }
        }
    }

    /**
     * Metodo que nos permite fijar una cancion como favorita de nuestra coleccion de musica
     */
    public void setAsFavourite(int index, boolean esFavorito){
        tracks.get(index).setFavorito(esFavorito);
    }

    /**
     * Metodo que nos imprime por pantalla si se esta reproduciendo una cancion.
     */
    public void isPlaying(){
        if(isPlay){
            System.out.println("ERROR. Actualmente se esta reproduciendo una cancion.");
        }
        else{
            System.out.println("En este momento no se esta reproduciendo ninguna cancion.");
        }
    }
    
    /**
     * Metodo que listara todas las canciones de nuestra coleccion a traves de un iterador.
     */
    public void listAllTrackWithIterator(){
        it = tracks.iterator();
        while(it.hasNext()){
            System.out.println(it.next().getDetails());
        }
    }
    
    /**
     * Metodo que eliminara una cancion de la coleccion usando iteradores si hay coincidencia con el artista pasado por parametro.
     */
    public void removeByArtist(String artista){
        it = tracks.iterator();
        while(it.hasNext()){
            if(it.next().getArtist().contains(artista)){
                it.remove();
            }
        }
    }
    
    /**
     * Metodo que eliminara una cancion de la coleccion usando iteradores si hay coincidencia con el titulo pasado por parametro.
     */
    public void removeByTitle(String titulo){
        it = tracks.iterator();
        while(it.hasNext()){
            if(it.next().getTitle().contains(titulo)){
                it.remove();
            }
        }
    }
}
