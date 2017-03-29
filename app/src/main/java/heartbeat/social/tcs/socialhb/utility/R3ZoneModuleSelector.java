package heartbeat.social.tcs.socialhb.utility;

/**
 * Created by admin on 19/02/17.
 */

public class R3ZoneModuleSelector {
    public String getModuleNameByModuleId(int id)
    {
        String module_name = "";

        switch(id)
        {
            case 1:
                module_name = "r3_zone_category_wise";
                break;
            case 2:
                module_name = "r3_zone_most_popular";
                break;
            case 3:
                module_name = "r3_zone_user_store";
                break;
            case 4:
                module_name = "r3_zone_user_contribution";
                break;
        }
        return module_name;
    }
}
