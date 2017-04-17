package Models;

/**
 * Created by grodrigu on 17/04/17.
 */
public class HomePageDetails {

    public static final HomePageDetails VALID_TITLE = new HomePageDetails("The Active Admin Store");

    private String homeTitle;

    public HomePageDetails(String homeTitle){
        setHomeTitle(homeTitle);
    }

    public void setHomeTitle(String homeTitle){
         this.homeTitle = homeTitle;
    }

    public String getHomeTitle(){
        return homeTitle;
    }
}
