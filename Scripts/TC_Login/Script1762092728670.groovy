import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.model.FailureHandling

// ini boleh static, karena TANPA "as"
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject   // kalau kamu pakai findTestObject


// helper cepat
TestObject byId(String id) { def t = new TestObject(id); t.addProperty('id', ConditionType.EQUALS, id); t }

WebUI.openBrowser('')
WebUI.navigateToUrl('https://www.saucedemo.com/')

WebUI.setText(byId('user-name'), username)
WebUI.setText(byId('password'), password)
WebUI.click(byId('login-button'))

WebUI.delay(2)
WebUI.takeScreenshot()

// verifikasi jika login gagal/sukses
if (WebUI.verifyElementPresent(byId('login-button'), 2, FailureHandling.OPTIONAL)) {
	println("Login failed for user: ${username}")
} else {
	println("Login success for user: ${username}")
}

WebUI.closeBrowser()
