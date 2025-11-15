import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.model.FailureHandling as FailureHandling

// helper locator by id
TestObject byId(String id) {
    def t = new TestObject(id)
    t.addProperty('id', ConditionType.EQUALS, id)
    return t
}

WebUI.openBrowser('')
WebUI.maximizeWindow()
WebUI.navigateToUrl('https://katalon-demo-cura.herokuapp.com/')

// klik "Make Appointment"
WebUI.click(byId('btn-make-appointment'))

// login pakai data dari variable (akan di-bind dari CSV)
WebUI.setText(byId('txt-username'), username)
WebUI.setText(byId('txt-password'), password)
WebUI.click(byId('btn-login'))

// cek apakah login sukses (tombol "Book Appointment" muncul)
boolean loggedIn = WebUI.verifyElementPresent(byId('btn-book-appointment'), 5, FailureHandling.OPTIONAL)

println "Login result for user '${username}' = ${loggedIn}"

WebUI.closeBrowser()
