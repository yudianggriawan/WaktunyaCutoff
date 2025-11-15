package com.yudi.helpers
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.util.KeywordUtil

class TitleHelper {
    @Keyword
    def verifyTitleContains(String text) {
        String title = WebUI.getWindowTitle()
        if (!title.toLowerCase().contains(text.toLowerCase())) {
            KeywordUtil.markFailed("Title '${title}' tidak mengandung '${text}'")
        }
    }
}
