package ruiz.delafuente.oscar.pruebanativaquadram.Model;

public class AppModel {

    private String appId;
    private String appImage;
    private String appName;
    private String appArtist;
    private String appPrice;


    public AppModel(String appId, String appImage, String appName, String appArtist, String appPrice) {
        this.appId = appId;
        this.appImage = appImage;
        this.appName = appName;
        this.appArtist = appArtist;
        this.appPrice = appPrice;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getAppImage() {
        return appImage;
    }

    public void setAppImage(String appImage) {
        this.appImage = appImage;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getAppArtist() {
        return appArtist;
    }

    public void setAppArtist(String appArtist) {
        this.appArtist = appArtist;
    }

    public String getAppPrice() {
        return appPrice;
    }

    public void setAppPrice(String appPrice) {
        this.appPrice = appPrice;
    }
}
