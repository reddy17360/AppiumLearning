package PageObjects.IosPageObjects.UiCatlogappPages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;



public class AlertViewPage {

  public AppiumDriver driver;
  public  AlertViewPage(AppiumDriver driver){
    this.driver = driver;
    PageFactory.initElements(new AppiumFieldDecorator(driver) , this) ;

  }

    @iOSXCUITFindBy(iOSNsPredicate = "name == \"Simple\"")
    private WebElement simpleField;

    @iOSXCUITFindBy(iOSNsPredicate="name == \"Text Entry\"")
    private WebElement textEntryField;

    @iOSXCUITFindBy( iOSClassChain ="**/XCUIElementTypeAlert/**/XCUIElementTypeTextField")
    private WebElement enterText;


  //@iOSXCUITFindBy(iOSClassChain = "**/XCUIElementStaticText[`name=="Confirm/Cancel"`]")
  @iOSXCUITFindBy(iOSClassChain="**/XCUIElementTypeStaticText[`name == 'Confirm / Cancel'`]")
  private WebElement confirmCancelField;

  @iOSXCUITFindBy(id="A message should be a short, complete sentence.")
  private WebElement textOnConfirm;

  @iOSXCUITFindBy(id="Confirm")
  private WebElement accept;

    public void enterTheText(String text) {
      textEntryField.click();
    enterText.sendKeys(text);
    driver.switchTo().alert().accept();
    }

    public String confimrClick(){
      confirmCancelField.click();
      String text = driver.switchTo().alert().getText();
    //  String text = textOnConfirm.getText();
        driver.switchTo().alert().accept();
       return text;
    }

}
