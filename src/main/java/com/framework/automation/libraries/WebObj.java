package com.framework.automation.libraries;

import org.openqa.selenium.By;

/**
 * The WebObj class is used to define a data type with By, Description and Value
 * It will contain all web Object identification
 * @since 04-10-2019
 * @version 1.0
 *
 */
public class WebObj {

    public By by;
    public String desc;
    public String value;

    public WebObj(By by, String desc) {
        this.by = by;
        this.desc = desc;
        this.value = "";
    }
}
