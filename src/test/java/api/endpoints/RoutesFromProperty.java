package api.endpoints;

import java.util.ResourceBundle;

public class RoutesFromProperty {
    public static ResourceBundle getUrl() {
        //This class can read file from src/test/Resources using Resource bundle
        ResourceBundle routes = ResourceBundle.getBundle("../../resources/Routes");//Load properties file using Resource bundle
        return routes;
    }
}
