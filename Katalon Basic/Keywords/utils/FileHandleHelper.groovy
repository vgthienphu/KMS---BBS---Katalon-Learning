package utils

import java.awt.Robot
import java.awt.Toolkit
import java.awt.datatransfer.StringSelection
import java.awt.event.KeyEvent
import java.util.concurrent.TimeUnit
import java.util.function.Function

import org.openqa.selenium.NotFoundException
import org.openqa.selenium.support.ui.FluentWait

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

public class FileHandleHelper {
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

	//For IE
	@Keyword
	public void uploadFileOnIE(TestObject to, String filePath) {
		WebUI.click(to);

		StringSelection sel = new StringSelection(filePath);

		// Copy to clipboard
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(sel, null)

		Robot robot = new Robot();

		// Press CTRL+V
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);

		// Release CTRL+V
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);

		//Press Enter
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

		robot.delay(GlobalVariable.ShortTime * 1000)

		//Press Esc in case of issue
		for (int i = 0; i < 3; i++) {
			robot.keyPress(KeyEvent.VK_ESCAPE)
			robot.keyRelease(KeyEvent.VK_ESCAPE)
		}
	}
}
