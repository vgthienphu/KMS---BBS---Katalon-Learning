package groovy

import java.text.DateFormat
import java.text.SimpleDateFormat
import com.kms.katalon.core.annotation.Keyword

public class Exercise {
	@Keyword
	public String convertNumberMonthToStringMonth(int month) {
		switch (month) {
			case 1:
				return 'Jan'
			case 2:
				return 'Feb'
			case 3:
				return 'Mar'
			case 4:
				return 'Apr'
			case 5:
				return 'May'
			case 6:
				return 'Jun'
			case 7:
				return 'Jul'
			case 8:
				return 'Aug'
			case 9:
				return 'Sep'
			case 10:
				return 'Oct'
			case 11:
				return 'Nov'
			case 12:
				return 'Dec'
			default:
				return 'Not a month'
		}
	}

	public double calculateDelta(double a, double b, double c) {
		return Math.pow(b, 2) - 4 * a * c
	}

	@Keyword
	public void solveEquadraticEquation(double a, double b, double c) {
		if (a != 0) {
			double delta = calculateDelta(a, b, c)

			if (delta > 0) {
				println("x1 = " + ((-b + Math.sqrt(delta)) / (2 * a)))
				println("x2 = " + ((-b - Math.sqrt(delta)) / (2 * a)))
			} else if (delta == 0) {
				println("x1 = x2 = " + (-b / (2 * a)))
			} else {
				println("No solutions")
			}
		} else {
			println("a must not be 0")
		}
	}

	@Keyword
	public String getSubstringFromStartToEnd(String str, String start, String end) {
		int startIndex = str.indexOf(start)
		int startIndexWLength = startIndex + start.length()
		int endIndex = str.indexOf(end)

		if (startIndex == -1) return "Start string not found"
		if (endIndex == -1) return "End string not found"
		if (startIndexWLength > endIndex) return "Start string can not be behind or overlapped with end string"

		return str.substring(startIndexWLength, endIndex)
	}

	public void convertListToStringList(def list) {
		for (int i = 0; i < list.size(); i++) {
			list[i] = list[i].toString()
		}
	}

	public String getCurrentStatus(def list) {
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

			if (list[i].isNumber() && list[i + 1].isNumber() && list[i].toInteger() > list[i + 1].toInteger()) {
				closureCurrentStatus.call("descending")
			} else {
				if (list[i].isNumber() && list[i + 1].isNumber() && list[i].toInteger() < list[i + 1].toInteger()) {
					closureCurrentStatus.call("ascending")
				} else {
					if (list[i] < list[i + 1]) {
						closureCurrentStatus.call("ascending")
					} else {
						if (list[i] < list[i + 1]) {
							closureCurrentStatus.call("descending")
						}
					}
				}
			}
		}

		return currentStatus
	}

	@Keyword
	public String getSortOrderStatus(def list) {
		convertListToStringList(list)

		return getCurrentStatus(list)
	}


	public boolean convertListToDate(def list) {
		int iterate = list.size()
		String pattern = "yyyy/MM/dd"

		for (int i = 0; i < iterate; i++) {
			try {
				SimpleDateFormat spDate = new SimpleDateFormat(pattern)
				spDate.setLenient(false)
				list[i] = spDate.parse(list[i])
				println(list[i])
			} catch (Exception ex) {
				ex.printStackTrace()
				return false
			}
		}

		return true
	}

	@Keyword
	public String getSortOrderStatusForDateString(def list) {
		String currentStatus = ""

		if (convertListToDate(list) == false) {
			return "wrong format"
		}

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

			if (list[i] > list[i + 1]) {
				closureCurrentStatus.call("descending")
			} else {
				if (list[i] < list[i + 1]) {
					closureCurrentStatus.call("ascending")
				}
			}
		}

		return currentStatus
	}

	@Keyword
	public String convertDateToString(String format) {
		return new Date().format(format);
	}
}
