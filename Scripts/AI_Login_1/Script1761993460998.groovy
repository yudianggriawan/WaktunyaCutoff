import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.testobject.ConditionType

TestObject byId(String id) {
    TestObject t = new TestObject(id)
    t.addProperty('id', ConditionType.EQUALS, id)
    return t
}
TestObject byXpath(String xp) {
    TestObject t = new TestObject('xp')
    t.addProperty('xpath', ConditionType.EQUALS, xp)
    return t
}

WebUI.openBrowser('')
WebUI.navigateToUrl('https://www.saucedemo.com')

WebUI.setText(byId('user-name'), 'standard_user')
WebUI.setText(byId('password'), 'secret_sauce')
WebUI.click(byId('login-button'))

WebUI.verifyElementPresent(byXpath("//span[text()='Products']"), 10)
WebUI.closeBrowser()
