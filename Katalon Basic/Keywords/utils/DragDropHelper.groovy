package utils

import static org.testng.reporters.Files.readFile

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

public class DragDropHelper {
	@Keyword
	public void dragDrop(String cssSelectorFrom, cssSelectorTo) {
		String simulateJS = ""

		try {
			simulateJS = readFile(new File(RunConfiguration.getProjectDir() + "\\Plugins\\Javascript Helper\\drag_and_drop_helper.js"));
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		WebUI.executeJavaScript(simulateJS, null)

		String dragDropScript = '$(arguments[0]).simulateDragDrop({ dropTarget: arguments[1]});'
		WebUI.executeJavaScript(dragDropScript, Arrays.asList(cssSelectorFrom, cssSelectorTo))
	}
}
