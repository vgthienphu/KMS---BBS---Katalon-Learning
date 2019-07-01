import com.kms.katalon.core.testdata.TestDataFactory

def _TestData = TestDataFactory.findTestData(p_DataFileName)

def _ColNames = _TestData.getColumnNames()
def _Data = _TestData.getAllData()

def _Info = []

_Data.each { _Row ->
	def _Obj = [:]
	
	_ColNames.eachWithIndex  { _ColName, _Index ->
		_Obj[_ColName] = _Row[_Index]
	}
	
	_Info.add(_Obj)
}

print _Info

return _Info