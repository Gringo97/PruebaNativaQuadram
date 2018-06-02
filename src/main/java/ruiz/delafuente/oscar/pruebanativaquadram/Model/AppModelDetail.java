package ruiz.delafuente.oscar.pruebanativaquadram.Model;

import java.util.Date;
import java.util.List;

public class AppModelDetail {

    private String artworkUrl100;
    private String trackName;
    private String artistName;
    private Double price;
    private List genresList;
    private Double version;
    private Date releaseDate;
    private Date currentVersionReleaseDate;
    private String description;

    public AppModelDetail() {
    }

    public AppModelDetail(String artworkUrl100, String trackName, String artistName, Double price, List genresList, Double version, Date releaseDate, Date currentVersionReleaseDate, String description) {
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public List getGenresList() {
        return genresList;
    }

    public void setGenresList(List genresList) {
        this.genresList = genresList;
    }

    public Double getVersion() {
        return version;
    }

    public void setVersion(Double version) {
        this.version = version;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Date getCurrentVersionReleaseDate() {
        return currentVersionReleaseDate;
    }

    public void setCurrentVersionReleaseDate(Date currentVersionReleaseDate) {
        this.currentVersionReleaseDate = currentVersionReleaseDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
