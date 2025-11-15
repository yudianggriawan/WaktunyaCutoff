package com.yudi.helpers
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

class CloseHelper {
    @Keyword
    def closeBrowser() {
        WebUI.closeBrowser()
    }
}