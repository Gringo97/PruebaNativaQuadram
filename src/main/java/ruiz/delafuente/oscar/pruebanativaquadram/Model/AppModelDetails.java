package ruiz.delafuente.oscar.pruebanativaquadram.Model;


public class AppModelDetails {

    private String id;
    private String artworkUrl100;
    private String trackName;
    private String artistName;
    private String price;
    private String genresList;
    private String version;
    private String releaseDate;
    private String currentVersionReleaseDate;
    private String description;

    public AppModelDetails() {
    }

    public AppModelDetails(String id,String artworkUrl100, String trackName, String artistName, String price, String genresList, String version, String releaseDate, String currentVersionReleaseDate, String description) {
        this.id = id;
        this.artworkUrl100 = artworkUrl100;
        this.trackName = trackName;
        this.artistName = artistName;
        this.price = price;
        this.genresList = genresList;
        this.version = version;
        this.releaseDate = releaseDate;
        this.currentVersionReleaseDate = currentVersionReleaseDate;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getArtworkUrl100() {
        return artworkUrl100;
    }

    public void setArtworkUrl100(String artworkUrl100) {
        this.artworkUrl100 = artworkUrl100;
    }

    public String getTrackName() {
        return trackName;
    }

    public void setTrackName(String trackName) {
        this.trackName = trackName;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getGenresList() {
        return genresList;
    }

    public void setGenresList(String genresList) {
        this.genresList = genresList;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getCurrentVersionReleaseDate() {
        return currentVersionReleaseDate;
    }

    public void setCurrentVersionReleaseDate(String currentVersionReleaseDate) {
        this.currentVersionReleaseDate = currentVersionReleaseDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
