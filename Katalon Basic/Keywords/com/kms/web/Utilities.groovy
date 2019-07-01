package com.kms.web

import java.awt.Robot
import java.awt.event.KeyEvent
import java.util.concurrent.TimeUnit
import java.util.function.Function

import org.openqa.selenium.Keys
import org.openqa.selenium.NotFoundException
import org.openqa.selenium.interactions.Actions
import org.openqa.selenium.support.ui.FluentWait

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

public class Utilities {
	public String getSortOrderStatus(ArrayList<String> list) {
		String currentStatus = ""

		def closureCurrentStatus = { status ->
			if (currentStatus == "" || currentStatus == status) {
				currentStatus = status
			} else {
				currentStatus = "normal"
			}
		}

		int iterate = list.size() - 1

		for (int i = 0; i < iterate; i++) {
			if (currentStatus == "normal") return currentStatus

			if (list[i].compareTo(list[i + 1]) < 0) {
				closureCurrentStatus.call("ascending")
			} else {
				if (list[i].compareTo(list[i + 1]) > 0) {
					closureCurrentStatus.call("descending")
				} else {
					closureCurrentStatus.call(currentStatus)
				}
			}
		}

		return currentStatus
	}

	@Keyword
	public void waitUntilFileDownloaded(String downloadLocation, String fileName, int waitTimeOutInSeconds, int checkExistsEverySecond) {
		File f = new File(downloadLocation + fileName)

		FluentWait<File> wait = new FluentWait<File>(f)
				.withTimeout(waitTimeOutInSeconds, TimeUnit.SECONDS)
				.pollingEvery(checkExistsEverySecond, TimeUnit.SECONDS)
				.ignoring(NotFoundException.class)

		wait.until(new Function<File, Boolean>() {
					@Override
					public Boolean apply(File file) {
						if (file.exists()) return true;

						throw new NotFoundException("File is not downloaded successfully");
					}
				});
	}

	@Keyword
	public boolean deleteFile(String filePath, String fileName) {
		File f = new File(filePath + fileName)

		return f.delete()
	}

	@Keyword
	public void pressAltS() {
		Robot robot = new Robot()
		robot.setAutoDelay(250)
		robot.keyPress(KeyEvent.VK_ALT)
		WebUI.delay(GlobalVariable.ShortTime)
		robot.keyPress(KeyEvent.VK_S)
		robot.keyRelease(KeyEvent.VK_ALT)
		robot.keyRelease(KeyEvent.VK_S)
	}

	@Keyword
	public void sendKeyWithKeyboard(String key) {
		new Actions(DriverFactory.getWebDriver()).sendKeys(key).build().perform()
	}

	@Keyword
	public void sendKeyWithKeyboard(Keys key) {
		new Actions(DriverFactory.getWebDriver()).sendKeys(key).build().perform()
	}
}
