import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

WebUI.openBrowser('')
WebUI.navigateToUrl('https://www.saucedemo.com/')

WebUI.setText(findTestObject('Page_Login/input_Username'), username)
WebUI.setText(findTestObject('Page_Login/input_Password'), password)
WebUI.click(findTestObject('Page_Login/btn_Login'))

WebUI.click(findTestObject('Page_Home/btn_AddToCart_Backpack'))
WebUI.click(findTestObject('Page_Home/icon_Cart'))
WebUI.click(findTestObject('Page_Cart/btn_Checkout'))

WebUI.delay(2)
WebUI.closeBrowser()
