package Utils;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

public class IosActions  extends  AppiumUtilities{
    public AppiumDriver driver;

   public IosActions(AppiumDriver driver){

        this.driver = driver;
    }

    public void swipeAction(WebElement element){

        driver.executeScript("mobile: swipe" , ImmutableMap.of("elementId"
        , ((RemoteWebElement)element).getId()  ));

    }

    public void scrollActionTillElement(WebElement element , String direction){

        driver.executeScript("mobile: scroll" , ImmutableMap.of("elementId"
                , ((RemoteWebElement)element).getId() , "direction" , direction ));

    }

    public void longPressAction(WebElement element , String duration){

        driver.executeScript("mobile: touchAndHold" , ImmutableMap.of("elementId"
                , ((RemoteWebElement)element).getId() , "duration" , duration ));

    }


}
