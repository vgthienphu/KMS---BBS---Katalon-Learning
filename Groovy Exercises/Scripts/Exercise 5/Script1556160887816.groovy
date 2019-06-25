def dateList1 = ["2018/01/01", "2018/05/15", "2019/01/02"] //ascending
def dateList2 = ["2019/01/02", "2018/05/15", "2018/01/01"] //descending
def dateList3 = ["2018/01/01", "2019/01/02", "2018/05/15"] //normal
def dateList4 = ["2018/01/01", "2019/00/23", "2018/05/15"] //wrong format

println(dateList1 + " should be ascending: " + CustomKeywords.'groovy.Exercise.getSortOrderStatusForDateString'(dateList1))
println(dateList2 + " should be descending: " + CustomKeywords.'groovy.Exercise.getSortOrderStatusForDateString'(dateList2))
println(dateList3 + " should be normal: " + CustomKeywords.'groovy.Exercise.getSortOrderStatusForDateString'(dateList3))
println(dateList4 + " should be wrong format: " + CustomKeywords.'groovy.Exercise.getSortOrderStatusForDateString'(dateList4))