package com.yudi.helpers
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

class ViewportHelper {
    @Keyword
    def setViewport(int width, int height) {
        WebUI.setViewPortSize(width, height)
    }
}
