import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.testobject.ObjectRepository as OR

CustomKeywords.'com.yudi.helpers.LoginHelper.openCuraSite'()
CustomKeywords.'com.yudi.helpers.ViewportHelper.setViewport'(1280, 720)
CustomKeywords.'com.yudi.helpers.ScreenshotHelper.capture'('open_cura')

CustomKeywords.'com.yudi.helpers.NavigateHelper.goTo'('https://www.saucedemo.com')
CustomKeywords.'com.yudi.helpers.TitleHelper.verifyTitleContains'('Swag')  // tidak wajib pass

String mail = CustomKeywords.'com.yudi.helpers.RandomDataHelper.randomEmail'()
println "Sample email: ${mail}"

CustomKeywords.'com.yudi.helpers.ScrollHelper.scrollToBottom'()
CustomKeywords.'com.yudi.helpers.WaitHelper.waitForSeconds'(1)
CustomKeywords.'com.yudi.helpers.DateTimeHelper.now'()

CustomKeywords.'com.yudi.helpers.CloseHelper.closeBrowser'()
