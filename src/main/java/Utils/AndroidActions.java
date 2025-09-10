package Utils;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import static io.appium.java_client.CommandExecutionHelper.executeScript;

public class AndroidActions extends AppiumUtilities{

   public AppiumDriver driver;
    public AndroidActions(AppiumDriver driver){

        this.driver = driver;
    }
    public void scrollItTill( String scrollObject){

        driver.findElement(AppiumBy.androidUIAutomator(
                "new UiScrollable(" +
                        "new UiSelector()).scrollIntoView(text( \"" + scrollObject + "\"));")).click();
    }


    public void longPress(WebElement element){
        driver.executeScript("mobile: longClickGesture" ,
                ImmutableMap.of("elementId" ,((RemoteWebElement)element).getId()  , "duration" , 2000));
    }

    public void dragAndDrop(WebElement element , String endX , String endY){
        driver.executeScript("mobile: dragGesture" ,
                ImmutableMap.of("elementId" ,((RemoteWebElement)element).getId()  ,"endX" , endX , "endY" , endY ));
    }

    public void startAnActivity(String intent){
        ((JavascriptExecutor)driver).executeScript("mobile: startActivity" , ImmutableMap.of("intent" , intent));
    }
}
