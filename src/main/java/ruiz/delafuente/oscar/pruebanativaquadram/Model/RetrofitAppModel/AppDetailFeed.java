
package ruiz.delafuente.oscar.pruebanativaquadram.Model.RetrofitAppModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AppDetailFeed {

    @SerializedName("feed")
    @Expose
    private Feed feed;

    public Feed getFeed() {
        return feed;
    }

    public void setFeed(Feed feed) {
        this.feed = feed;
    }

}
