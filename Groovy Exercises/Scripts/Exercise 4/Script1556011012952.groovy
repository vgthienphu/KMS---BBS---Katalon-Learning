def list1 = [9, 18, 102, 1002]
def list2 = [102, 18, 9, 1002]
def list3 = [1002, 102, 18, 9]
def list4 = ['9', '18', '102', '1002']
def list5 = ['1002', '102', '18', '9']
def list6 = ['1ab', 'ab', 'cd', 'ya']
def list7 = ['1ab', '0', 'cd', 'ya']

println(list1 + ' should be ascending: ' + CustomKeywords.'groovy.Exercise.getSortOrderStatus'(list1))
println(list2 + ' should be normal: ' + CustomKeywords.'groovy.Exercise.getSortOrderStatus'(list2))
println(list3 + ' should be descending: ' + CustomKeywords.'groovy.Exercise.getSortOrderStatus'(list3))
println(list4 + " should be ascending: " + CustomKeywords.'groovy.Exercise.getSortOrderStatus'(list4))
println(list5 + " should be descending: " + CustomKeywords.'groovy.Exercise.getSortOrderStatus'(list5))
println(list6 + " should be ascending: " + CustomKeywords.'groovy.Exercise.getSortOrderStatus'(list6))
println(list7 + " should be ascending: " + CustomKeywords.'groovy.Exercise.getSortOrderStatus'(list7))


