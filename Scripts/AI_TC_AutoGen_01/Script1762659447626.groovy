println("Test setup for StudioAssist automation")
// Generate test for login page
// Open the Cura site using custom keyword
CustomKeywords.'com.yudi.helpers.LoginHelper.openCuraSite'()
// Verify the page title contains 'CURA Healthcare Service'
CustomKeywords.'com.yudi.helpers.TitleHelper.verifyTitleContains'('CURA Healthcare Service')
// Set viewport size to 1280x720
CustomKeywords.'com.yudi.helpers.ViewportHelper.setViewport'(1280, 720)
// Wait for 2 seconds to ensure page is loaded
CustomKeywords.'com.yudi.helpers.WaitHelper.waitForSeconds'(2)
// Input username 'John Doe' into username field
WebUI.setText(findTestObject('Object Repository/Page_CURA Healthcare Service/input_Username_username'), 'John Doe')
// Input password 'ThisIsNotAPassword' into password field
WebUI.setEncryptedText(findTestObject('Object Repository/Page_CURA Healthcare Service/input_Password_password'), 'RigbBhfdqOBGNlJIWM1ClA==')
// Click the login button
WebUI.click(findTestObject('Object Repository/Page_CURA Healthcare Service/button_Login'))
// Wait for 3 seconds to allow login processing
CustomKeywords.'com.yudi.helpers.WaitHelper.waitForSeconds'(3)
// Capture screenshot after login
CustomKeywords.'com.yudi.helpers.ScreenshotHelper.capture'('LoginPage_AfterLogin')
// Close the browser using custom keyword
CustomKeywords.'com.yudi.helpers.CloseHelper.closeBrowser'()

// Generate test for logout function
// Click the menu toggle button to open the sidebar menu
WebUI.click(findTestObject('Object Repository/Page_CURA Healthcare Service/button_MenuToggle'))
// Wait for 1 second to ensure the menu is fully displayed
CustomKeywords.'com.yudi.helpers.WaitHelper.waitForSeconds'(1)
// Click the logout link in the sidebar menu
WebUI.click(findTestObject('Object Repository/Page_CURA Healthcare Service/a_Logout'))
// Wait for 2 seconds to allow logout processing
CustomKeywords.'com.yudi.helpers.WaitHelper.waitForSeconds'(2)
// Capture screenshot after logout
CustomKeywords.'com.yudi.helpers.ScreenshotHelper.capture'('LogoutPage_AfterLogout')
// Close the browser using custom keyword
CustomKeywords.'com.yudi.helpers.CloseHelper.closeBrowser'()