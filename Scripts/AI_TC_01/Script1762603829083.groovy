import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.testobject.ConditionType

TestObject byId(String id) {
    def t = new TestObject(id)
    t.addProperty('id', ConditionType.EQUALS, id)
    return t
}

WebUI.openBrowser('')
WebUI.navigateToUrl('https://www.saucedemo.com/')

// pakai byId, bukan findTestObject
WebUI.setText(byId('user-name'), 'standard_user')
WebUI.setText(byId('password'), 'secret_sauce')
WebUI.click(byId('login-button'))

WebUI.waitForPageLoad(10)
WebUI.verifyMatch(WebUI.getUrl(), '.*inventory\\.html.*', true)

WebUI.closeBrowser()
//