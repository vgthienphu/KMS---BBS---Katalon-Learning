def formats = ['yyyy-MM-dd', 'yyyyddMM', 'yyyy-MMM-dd']

for (format in formats) {
	println('Format ' + format + ' : ' + CustomKeywords.'groovy.Exercise.convertDateToString'(format))
}