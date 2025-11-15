import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.testobject.ConditionType

TestObject byId(String id) {
    def t = new TestObject(id)
    t.addProperty('id', ConditionType.EQUALS, id)
    return t
}

// ambil dari Data Files, BUKAN path file
def data = findTestData('Data Files/LoginData')

WebUI.openBrowser('')
WebUI.navigateToUrl('https://www.saucedemo.com/')

for (def row = 1; row <= data.getRowNumbers(); row++) {
    String username = data.getValue(1, row)   // kolom 1
    String password = data.getValue(2, row)   // kolom 2

    WebUI.setText(byId('user-name'), username)
    WebUI.setText(byId('password'), password)
    WebUI.click(byId('login-button'))

    WebUI.delay(2)
    WebUI.navigateToUrl('https://www.saucedemo.com/')   // balik ke login supaya data berikutnya bisa dijalankan
}

WebUI.closeBrowser()
