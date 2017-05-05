package heartbeat.social.tcs.socialhb.utility;

/**
 * Created by shravanjain on 29/03/17.
 */

public class R3ZoneMostPopularModuleSelector {
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
    public String getClassNameByModuleId(int id){
        String class_name = "";

        switch(id)
        {
            case 1:
                class_name = "R3ZoneMostPopular";
                break;
            case 2:
                class_name = "R3ZoneMostPopular";
                break;
            case 3:
                class_name = "R3ZoneMostPopular";
                break;
            case 4:
                class_name = "R3ZoneMostPopular";
                break;
            case 5:
                class_name = "R3ZoneMostPopular";
        }
        return class_name;
    }

}
