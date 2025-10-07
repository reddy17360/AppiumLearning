package Utils;

import com.github.javafaker.App;
import com.google.common.collect.ImmutableMap;
import coreDriver.Drivers;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;


public class AndroidActions extends AppiumUtilities{


    public void scrollItTill( String scrollObject  , AppiumDriver driver){

        driver.findElement(AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector()).scrollIntoView(text( \"" + scrollObject + "\"));")).click();
    }

    public void pressBack(AppiumDriver driver) throws Exception {
        ((AndroidDriver) driver).pressKey(new KeyEvent().withKey(AndroidKey.BACK));

    }

    public void scrollMore( AppiumDriver driver) {
        boolean canScrollMore ;
        do {
            canScrollMore = (Boolean) driver.executeScript("mobile: scrollGesture",
                    ImmutableMap.of("left", 100, "top", 100,
                            "width", 200, "height", 200,
                            "direction", "left", "percent", 3.0));
        }while(canScrollMore);
    }

    public void longPress(WebElement element , AppiumDriver driver){
        driver.executeScript("mobile: longClickGesture" ,
                ImmutableMap.of("elementId" ,((RemoteWebElement)element).getId()  , "duration" , 2000));
    }

    public void dragAndDrop(WebElement element , String endX , String endY , AppiumDriver driver){
        driver.executeScript("mobile: dragGesture" ,
                ImmutableMap.of("elementId" ,((RemoteWebElement)element).getId()  ,"endX" , endX , "endY" , endY ));
    }

    public void startAnActivity(String intent , AppiumDriver driver){
        ((JavascriptExecutor)driver).executeScript("mobile: startActivity" , ImmutableMap.of("intent" , intent));
    }

    public void swipeIt(WebElement element , AppiumDriver driver){
        driver.executeScript("mobile: swipeGesture" , ImmutableMap.of(
                "elementId" , ((RemoteWebElement)element).getId() , "direction" , "left" ,
                "percent" , "0.75"));
    }
}
