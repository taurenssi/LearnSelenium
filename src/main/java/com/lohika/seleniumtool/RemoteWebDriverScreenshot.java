package com.lohika.seleniumtool;

import java.net.URL;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.internal.WrapsDriver;
import org.openqa.selenium.remote.CommandExecutor;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.DriverCommand;
import org.openqa.selenium.remote.RemoteWebDriver;

public class RemoteWebDriverScreenshot extends RemoteWebDriver implements TakesScreenshot, WrapsDriver {
    public RemoteWebDriverScreenshot(URL address, DesiredCapabilities cap) {
        super(address, cap);
    }

    public RemoteWebDriverScreenshot(CommandExecutor exec, DesiredCapabilities cap) {
        super(exec, cap);
    }

    @Override
    public <X> X getScreenshotAs(OutputType<X> target) throws WebDriverException {
        String base64 = execute(DriverCommand.SCREENSHOT).getValue().toString();
        return target.convertFromBase64Png(base64);
    }

    @Override
    public WebDriver getWrappedDriver() {
        return this;
    }
}
