package heartbeat.social.tcs.socialhb.bean;

/**
 * Created by admin on 21/01/17.
 */

public class TipDescription {

    private int id;
    private TipCategory tipCategory;
    private String tip_heading;
    private String tip_description;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TipCategory getTipCategory() {
        return tipCategory;
    }

    public void setTipCategory(TipCategory tipCategory) {
        this.tipCategory = tipCategory;
    }

    public String getTip_heading() {
        return tip_heading;
    }

    public void setTip_heading(String tip_heading) {
        this.tip_heading = tip_heading;
    }

    public String getTip_description() {
        return tip_description;
    }

    public void setTip_description(String tip_description) {
        this.tip_description = tip_description;
    }
}
