package com.yudi.helpers
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

class ScrollHelper {
    @Keyword
    def scrollToBottom() {
        WebUI.executeJavaScript("window.scrollTo(0, document.body.scrollHeight);", null)
    }
}
