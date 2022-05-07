package selenium_core;

public class DriverManagerFactory {

    public static DriverManager getDriverManager(String type) {
        DriverManager driverManager;

        switch (type) {
            case "CHROME": {
                driverManager = new ChromeDriverManager();
            }
            break;
            case "FIREFOX": {
                driverManager = new FirefoxDriverManager();
            }
            break;
            default: {
//                new Exception("No such browser");
                driverManager = new ChromeDriverManager();
            }
            break;
        }

        return driverManager;
    }

}