package PageObjects.AndroidPageObject.GojekPageObject;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class LocationPermissionPageObject {



    @AndroidFindBy(id="com.android.permissioncontroller:id/permission_allow_foreground_only_button")
    public WebElement allowWhileUsingAppPermission;

    @AndroidFindBy(id="com.android.permissioncontroller:id/permission_allow_one_time_button")
    public WebElement  onlyOneTimeAppPermission;

    @AndroidFindBy(id="com.android.permissioncontroller:id/permission_deny_button")
    public WebElement denyAppPermission;


}
