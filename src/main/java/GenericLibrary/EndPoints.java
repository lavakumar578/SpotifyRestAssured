package GenericLibrary;

/**
 * This  interface consists of all endpoints
 * @author LAVA KUMAR
 *
 */
public interface EndPoints{
	
	String GETALBUM = "/albums/";
	String TRACKS="/tracks";
	String SAVEDALBUMS="/me/albums";
	String CHECKSAVEDALBUMS="/me/albums/contains";
	String NEWRELEASES="/browse/new-releases";
	String ARTISTS="/artists/";
	String TOPTRACKS="/top-tracks";
	String RELATEDARTIST="/related-artists";
	String PLAYLISTS="/playlists";
	String USERS="/users/";
}
