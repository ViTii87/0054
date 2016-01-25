/**
 * Store the details of a music track,
 * such as the artist, title, and file name.
 * 
 * @author David J. Barnes and Michael Kölling
 * @version 2011.07.31
 */
public class Track
{
    // The artist.
    private String artist;
    // The track's title.
    private String title;
    // Where the track is stored.
    private String filename;
    // Atributo para contar las veces que se reproduce una cancion.
    private int playCount;
    // Atributo para marcar una cancion como favorita.
    private String favorito;
    
    /**
     * Constructor for objects of class Track.
     * @param artist The track's artist.
     * @param title The track's title.
     * @param filename The track file. 
     */
    public Track(String artist, String title, String filename)
    {
        setDetails(artist, title, filename);
        playCount = 0;
        favorito = "No";
    }
    
    /**
     * Constructor for objects of class Track.
     * It is assumed that the file name cannot be
     * decoded to extract artist and title details.
     * @param filename The track file. 
     */
    public Track(String filename)
    {
        setDetails("unknown", "unknown", filename);
        playCount = 0;
        favorito = "No";
    }
    
    /**
     * Return the artist.
     * @return The artist.
     */
    public String getArtist()
    {
        return artist;
    }
    
    /**
     * Return the title.
     * @return The title.
     */
    public String getTitle()
    {
        return title;
    }
    
    /**
     * Return the file name.
     * @return The file name.
     */
    public String getFilename()
    {
        return filename;
    }
        
    /**
     * Return details of the track: artist, title and file name.
     * @return The track's details.
     */
    public String getDetails()
    {
        return artist + ": " + title + "  (file: " + filename + ") " + "Contador: " + playCount + " Favorito: " + favorito;
    }
    
    /**
     * Set details of the track.
     * @param artist The track's artist.
     * @param title The track's title.
     * @param filename The track file. 
     */
    private void setDetails(String artist, String title, String filename)
    {
        this.artist = artist;
        this.title = title;
        this.filename = filename;
    }
    
    /**
     * Metodo para poner a 0 el atributo que cuenta las veces que se reproduce una cancion.
     */
    public void resetPlayCount(){
        playCount = 0;
    }
    
    /**
     * Metodo para ir contando de 1 en 1 las veces que se reproduce una cancion.
     */
    public void addPlayCount(){
        playCount += 1;
    }
    
    /**
     * Metodo que nos permite fijar una cancion como favorita.
     */
    public void setFavorito(boolean esFavorito){
        if(esFavorito){
            favorito = "Si";
        }
        else{
            favorito = "No";
        }
    }
    
    /**
     * Metodo para devolver el valor del atributo favorito.
     */
    public String getFavorito(){
        return favorito;
    }
}
