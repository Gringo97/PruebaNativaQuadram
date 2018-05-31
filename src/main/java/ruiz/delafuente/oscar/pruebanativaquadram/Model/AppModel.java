package ruiz.delafuente.oscar.pruebanativaquadram.Model;

public class AppModel {

    private String appImage;
    private String appName;
    private String appArtist;
    private Double appPrice;

    public AppModel(){

    }

    public AppModel(String appImage, String appName, String appArtist, Double appPrice) {
        this.appImage = appImage;
        this.appName = appName;
        this.appArtist = appArtist;
        this.appPrice = appPrice;
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

    public Double getAppPrice() {
        return appPrice;
    }

    public void setAppPrice(Double appPrice) {
        this.appPrice = appPrice;
    }
}
