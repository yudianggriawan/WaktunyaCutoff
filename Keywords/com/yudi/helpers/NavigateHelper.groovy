package com.yudi.helpers
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

class NavigateHelper {
    @Keyword
    def goTo(String url) {
        WebUI.navigateToUrl(url)
    }
}