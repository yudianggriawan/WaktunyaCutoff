import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.model.FailureHandling

TestObject byId(String id){ def t=new TestObject(id); t.addProperty('id',ConditionType.EQUALS,id); t }
TestObject byCss(String css){ def t=new TestObject(css); t.addProperty('css',ConditionType.EQUALS,css); t }
WebUI.openBrowser('')
WebUI.navigateToUrl('https://www.saucedemo.com')

// Login
WebUI.setText(byId('user-name'), username)
WebUI.setText(byId('password'), password)
WebUI.click(byId('login-button'))

// Verifikasi sudah di inventory
WebUI.waitForPageLoad(10)
WebUI.verifyMatch(WebUI.getUrl(), '.*/inventory\\.html$', true, FailureHandling.STOP_ON_FAILURE)

// Logout via burger menu
WebUI.click(byId('react-burger-menu-btn'))
WebUI.click(byId('logout_sidebar_link'))

// Verifikasi kembali ke halaman login
WebUI.verifyMatch(WebUI.getUrl(), '.*/saucedemo\\.com/?$', true, FailureHandling.STOP_ON_FAILURE)
WebUI.verifyElementPresent(byId('login-button'), 5)

WebUI.closeBrowser()