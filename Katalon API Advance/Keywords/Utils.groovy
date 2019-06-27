import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.exception.StepFailedException
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS

import groovy.json.JsonSlurper

public class Utils {
	@Keyword
	public void verifyResponsePropertiesValue(ResponseObject response, Map expectedObj) {
		expectedObj.each {
			WS.verifyElementPropertyValue(response, it.key, it.value)
		}
	}

	@Keyword
	public def parseResponeBodytoJSON(ResponseObject response) {
		JsonSlurper slurper = new JsonSlurper()
		def parsedJson = slurper.parseText(response.getResponseBodyContent())

		return parsedJson
	}

	@Keyword
	public def getMapWithBiggestValueOfPropertyInArray(ArrayList array, String property) {
		Comparator<Map> valueCmp = new Comparator<Map>() {
					@Override
					public int compare(Map m1, Map m2) {
						return m1[property].compareTo(m2[property])
					}
				}

		return Collections.max(array, valueCmp)
	}
	
	@Keyword
	public void verifyNoElementWithPropertiesValue(ArrayList elementList, Map propertiesAndTheirValue) {
		elementList.each({
			propertiesAndTheirValue.each { key, value ->
				if (it[key].equals(value)) {
					throw new StepFailedException('There is an element with ' + key + ' equal to ' + value)
				}
			}
		})
	}
}
