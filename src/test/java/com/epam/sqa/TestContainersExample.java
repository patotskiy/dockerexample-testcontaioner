package com.epam.sqa;

import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testcontainers.containers.BrowserWebDriverContainer;

import java.io.File;

import static org.testcontainers.containers.BrowserWebDriverContainer.VncRecordingMode.RECORD_ALL;

public class TestContainersExample {

	@Rule
	public BrowserWebDriverContainer chrome = new BrowserWebDriverContainer().withDesiredCapabilities(DesiredCapabilities.chrome())
			.withRecordingMode(RECORD_ALL, new File("target"));

	@Test
	public void simplePlainSeleniumTest() {
		RemoteWebDriver driver = chrome.getWebDriver();

		driver.get("https://tut.by");
		WebElement searchInput = driver.findElementById("search_from_str");

		searchInput.sendKeys("EPAM");
		searchInput.submit();

		WebElement otherPage = driver.findElementByLinkText("www.epam.com/");
		otherPage.click();

	}
}
