package ruiz.delafuente.oscar.pruebanativaquadram.Utils;



import java.util.List;

import ruiz.delafuente.oscar.pruebanativaquadram.Model.AppModel;
import ruiz.delafuente.oscar.pruebanativaquadram.Model.AppModelDetails;

public class DataHolder {

    public  String appSelectedId;

    public static  DataHolder instance = new DataHolder();
    public List<AppModel> appModelList;
    public List<AppModelDetails> appModelDetailsList;

}