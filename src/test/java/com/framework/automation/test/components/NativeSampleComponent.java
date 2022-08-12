package com.framework.automation.test.components;

import com.framework.automation.drivers.DriverFactory;
import com.framework.automation.utils.TestUtil;
import com.framework.automation.wrapper.ui.Element;
import com.framework.automation.wrapper.ui.NativeAppsAction;
import io.qameta.allure.Allure;
import org.openqa.selenium.WebDriver;

public class NativeSampleComponent extends NativeAppsAction {

    WebDriver driver;

    private Element txtPrimarySearch, btnSearchIconBtn;

    public NativeSampleComponent(){
        try{
            driver = DriverFactory.getDriver();
            fetchLocators();
        }catch(Exception e){
            e.printStackTrace();
            TestUtil.updateErrorDetailsToReport("Component initialization failed::" , e.getMessage());
        }
    }

    public void fetchLocators(){
        txtPrimarySearch = Element.returnNativeAppElementFromRepo("SearchComponent","txtPrimarySearch");
        btnSearchIconBtn = Element.returnNativeAppElementFromRepo("SearchComponent","btnSearchIconBtn");
    }


    public void sampleComponentMethod() {
        try{
            click(btnSearchIconBtn);
            type(txtPrimarySearch, "Sample Text");
        }catch(AssertionError | Exception e){
            Allure.addAttachment("Sample Message for the method error",TestUtil.takeScreenShot());
            TestUtil.updateErrorDetailsToReport("Error Message Sample", "name of method",e.toString());
        }
    }
}
