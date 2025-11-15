import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.model.FailureHandling
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By
import com.kms.katalon.core.webui.driver.DriverFactory

WebDriver driver = DriverFactory.getWebDriver()
try {
	driver.findElement(By.cssSelector('button[aria-label="OK"]')).click()
} catch(Exception e) {
	// kalau popup tidak muncul, lanjut aja
}

TestObject byId(String id){ def t=new TestObject(id); t.addProperty('id',ConditionType.EQUALS,id); t }
TestObject byCss(String css){ def t=new TestObject(css); t.addProperty('css',ConditionType.EQUALS,css); t }
WebUI.openBrowser('')
WebUI.navigateToUrl('https://www.saucedemo.com')

// Login
WebUI.setText(byId('user-name'), username)
WebUI.setText(byId('password'), password)
WebUI.click(byId('login-button'))

WebUI.waitForPageLoad(10)
WebUI.verifyMatch(WebUI.getUrl(), '.*/inventory\\.html$', true)

// Add to Cart (Sauce Labs Backpack)
WebUI.click(byId('add-to-cart-sauce-labs-backpack'))

// Verifikasi badge = 1
TestObject badge = byCss('.shopping_cart_badge')
WebUI.verifyElementText(badge, '1', FailureHandling.STOP_ON_FAILURE)

// Buka cart & verifikasi item ada
WebUI.click(byId('shopping_cart_container'))
WebUI.verifyElementPresent(byCss('.cart_item'), 5)

WebUI.closeBrowser()