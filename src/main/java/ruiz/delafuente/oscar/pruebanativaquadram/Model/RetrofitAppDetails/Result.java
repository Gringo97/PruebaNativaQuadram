
package ruiz.delafuente.oscar.pruebanativaquadram.Model.RetrofitAppDetails;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Result {

    @SerializedName("isGameCenterEnabled")
    @Expose
    private Boolean isGameCenterEnabled;
    @SerializedName("artworkUrl60")
    @Expose
    private String artworkUrl60;
    @SerializedName("artworkUrl100")
    @Expose
    private String artworkUrl100;
    @SerializedName("artistViewUrl")
    @Expose
    private String artistViewUrl;
    @SerializedName("screenshotUrls")
    @Expose
    private List<String> screenshotUrls = null;
    @SerializedName("ipadScreenshotUrls")
    @Expose
    private List<String> ipadScreenshotUrls = null;
    @SerializedName("appletvScreenshotUrls")
    @Expose
    private List<Object> appletvScreenshotUrls = null;
    @SerializedName("artworkUrl512")
    @Expose
    private String artworkUrl512;
    @SerializedName("kind")
    @Expose
    private String kind;
    @SerializedName("features")
    @Expose
    private List<String> features = null;
    @SerializedName("supportedDevices")
    @Expose
    private List<String> supportedDevices = null;
    @SerializedName("advisories")
    @Expose
    private List<String> advisories = null;
    @SerializedName("trackViewUrl")
    @Expose
    private String trackViewUrl;
    @SerializedName("contentAdvisoryRating")
    @Expose
    private String contentAdvisoryRating;
    @SerializedName("trackCensoredName")
    @Expose
    private String trackCensoredName;
    @SerializedName("averageUserRatingForCurrentVersion")
    @Expose
    private Float averageUserRatingForCurrentVersion;
    @SerializedName("languageCodesISO2A")
    @Expose
    private List<String> languageCodesISO2A = null;
    @SerializedName("fileSizeBytes")
    @Expose
    private String fileSizeBytes;
    @SerializedName("sellerUrl")
    @Expose
    private String sellerUrl;
    @SerializedName("userRatingCountForCurrentVersion")
    @Expose
    private Integer userRatingCountForCurrentVersion;
    @SerializedName("trackContentRating")
    @Expose
    private String trackContentRating;
    @SerializedName("genreIds")
    @Expose
    private List<String> genreIds = null;
    @SerializedName("currentVersionReleaseDate")
    @Expose
    private String currentVersionReleaseDate;
    @SerializedName("sellerName")
    @Expose
    private String sellerName;
    @SerializedName("isVppDeviceBasedLicensingEnabled")
    @Expose
    private Boolean isVppDeviceBasedLicensingEnabled;
    @SerializedName("currency")
    @Expose
    private String currency;
    @SerializedName("wrapperType")
    @Expose
    private String wrapperType;
    @SerializedName("version")
    @Expose
    private String version;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("artistId")
    @Expose
    private Integer artistId;
    @SerializedName("artistName")
    @Expose
    private String artistName;
    @SerializedName("genres")
    @Expose
    private List<String> genres = null;
    @SerializedName("price")
    @Expose
    private String price;
    @SerializedName("bundleId")
    @Expose
    private String bundleId;
    @SerializedName("formattedPrice")
    @Expose
    private String formattedPrice;
    @SerializedName("primaryGenreName")
    @Expose
    private String primaryGenreName;
    @SerializedName("primaryGenreId")
    @Expose
    private Integer primaryGenreId;
    @SerializedName("trackId")
    @Expose
    private Integer trackId;
    @SerializedName("trackName")
    @Expose
    private String trackName;
    @SerializedName("releaseNotes")
    @Expose
    private String releaseNotes;
    @SerializedName("minimumOsVersion")
    @Expose
    private String minimumOsVersion;
    @SerializedName("releaseDate")
    @Expose
    private String releaseDate;
    @SerializedName("averageUserRating")
    @Expose
    private Float averageUserRating;
    @SerializedName("userRatingCount")
    @Expose
    private Integer userRatingCount;

    public Boolean getIsGameCenterEnabled() {
        return isGameCenterEnabled;
    }

    public void setIsGameCenterEnabled(Boolean isGameCenterEnabled) {
        this.isGameCenterEnabled = isGameCenterEnabled;
    }

    public String getArtworkUrl60() {
        return artworkUrl60;
    }

    public void setArtworkUrl60(String artworkUrl60) {
        this.artworkUrl60 = artworkUrl60;
    }

    public String getArtworkUrl100() {
        return artworkUrl100;
    }

    public void setArtworkUrl100(String artworkUrl100) {
        this.artworkUrl100 = artworkUrl100;
    }

    public String getArtistViewUrl() {
        return artistViewUrl;
    }

    public void setArtistViewUrl(String artistViewUrl) {
        this.artistViewUrl = artistViewUrl;
    }

    public List<String> getScreenshotUrls() {
        return screenshotUrls;
    }

    public void setScreenshotUrls(List<String> screenshotUrls) {
        this.screenshotUrls = screenshotUrls;
    }

    public List<String> getIpadScreenshotUrls() {
        return ipadScreenshotUrls;
    }

    public void setIpadScreenshotUrls(List<String> ipadScreenshotUrls) {
        this.ipadScreenshotUrls = ipadScreenshotUrls;
    }

    public List<Object> getAppletvScreenshotUrls() {
        return appletvScreenshotUrls;
    }

    public void setAppletvScreenshotUrls(List<Object> appletvScreenshotUrls) {
        this.appletvScreenshotUrls = appletvScreenshotUrls;
    }

    public String getArtworkUrl512() {
        return artworkUrl512;
    }

    public void setArtworkUrl512(String artworkUrl512) {
        this.artworkUrl512 = artworkUrl512;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public List<String> getFeatures() {
        return features;
    }

    public void setFeatures(List<String> features) {
        this.features = features;
    }

    public List<String> getSupportedDevices() {
        return supportedDevices;
    }

    public void setSupportedDevices(List<String> supportedDevices) {
        this.supportedDevices = supportedDevices;
    }

    public List<String> getAdvisories() {
        return advisories;
    }

    public void setAdvisories(List<String> advisories) {
        this.advisories = advisories;
    }

    public String getTrackViewUrl() {
        return trackViewUrl;
    }

    public void setTrackViewUrl(String trackViewUrl) {
        this.trackViewUrl = trackViewUrl;
    }

    public String getContentAdvisoryRating() {
        return contentAdvisoryRating;
    }

    public void setContentAdvisoryRating(String contentAdvisoryRating) {
        this.contentAdvisoryRating = contentAdvisoryRating;
    }

    public String getTrackCensoredName() {
        return trackCensoredName;
    }

    public void setTrackCensoredName(String trackCensoredName) {
        this.trackCensoredName = trackCensoredName;
    }

    public Float getAverageUserRatingForCurrentVersion() {
        return averageUserRatingForCurrentVersion;
    }

    public void setAverageUserRatingForCurrentVersion(Float averageUserRatingForCurrentVersion) {
        this.averageUserRatingForCurrentVersion = averageUserRatingForCurrentVersion;
    }

    public List<String> getLanguageCodesISO2A() {
        return languageCodesISO2A;
    }

    public void setLanguageCodesISO2A(List<String> languageCodesISO2A) {
        this.languageCodesISO2A = languageCodesISO2A;
    }

    public String getFileSizeBytes() {
        return fileSizeBytes;
    }

    public void setFileSizeBytes(String fileSizeBytes) {
        this.fileSizeBytes = fileSizeBytes;
    }

    public String getSellerUrl() {
        return sellerUrl;
    }

    public void setSellerUrl(String sellerUrl) {
        this.sellerUrl = sellerUrl;
    }

    public Integer getUserRatingCountForCurrentVersion() {
        return userRatingCountForCurrentVersion;
    }

    public void setUserRatingCountForCurrentVersion(Integer userRatingCountForCurrentVersion) {
        this.userRatingCountForCurrentVersion = userRatingCountForCurrentVersion;
    }

    public String getTrackContentRating() {
        return trackContentRating;
    }

    public void setTrackContentRating(String trackContentRating) {
        this.trackContentRating = trackContentRating;
    }

    public List<String> getGenreIds() {
        return genreIds;
    }

    public void setGenreIds(List<String> genreIds) {
        this.genreIds = genreIds;
    }

    public String getCurrentVersionReleaseDate() {
        return currentVersionReleaseDate;
    }

    public void setCurrentVersionReleaseDate(String currentVersionReleaseDate) {
        this.currentVersionReleaseDate = currentVersionReleaseDate;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public Boolean getIsVppDeviceBasedLicensingEnabled() {
        return isVppDeviceBasedLicensingEnabled;
    }

    public void setIsVppDeviceBasedLicensingEnabled(Boolean isVppDeviceBasedLicensingEnabled) {
        this.isVppDeviceBasedLicensingEnabled = isVppDeviceBasedLicensingEnabled;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getWrapperType() {
        return wrapperType;
    }

    public void setWrapperType(String wrapperType) {
        this.wrapperType = wrapperType;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getArtistId() {
        return artistId;
    }

    public void setArtistId(Integer artistId) {
        this.artistId = artistId;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getBundleId() {
        return bundleId;
    }

    public void setBundleId(String bundleId) {
        this.bundleId = bundleId;
    }

    public String getFormattedPrice() {
        return formattedPrice;
    }

    public void setFormattedPrice(String formattedPrice) {
        this.formattedPrice = formattedPrice;
    }

    public String getPrimaryGenreName() {
        return primaryGenreName;
    }

    public void setPrimaryGenreName(String primaryGenreName) {
        this.primaryGenreName = primaryGenreName;
    }

    public Integer getPrimaryGenreId() {
        return primaryGenreId;
    }

    public void setPrimaryGenreId(Integer primaryGenreId) {
        this.primaryGenreId = primaryGenreId;
    }

    public Integer getTrackId() {
        return trackId;
    }

    public void setTrackId(Integer trackId) {
        this.trackId = trackId;
    }

    public String getTrackName() {
        return trackName;
    }

    public void setTrackName(String trackName) {
        this.trackName = trackName;
    }

    public String getReleaseNotes() {
        return releaseNotes;
    }

    public void setReleaseNotes(String releaseNotes) {
        this.releaseNotes = releaseNotes;
    }

    public String getMinimumOsVersion() {
        return minimumOsVersion;
    }

    public void setMinimumOsVersion(String minimumOsVersion) {
        this.minimumOsVersion = minimumOsVersion;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Float getAverageUserRating() {
        return averageUserRating;
    }

    public void setAverageUserRating(Float averageUserRating) {
        this.averageUserRating = averageUserRating;
    }

    public Integer getUserRatingCount() {
        return userRatingCount;
    }

    public void setUserRatingCount(Integer userRatingCount) {
        this.userRatingCount = userRatingCount;
    }

}
