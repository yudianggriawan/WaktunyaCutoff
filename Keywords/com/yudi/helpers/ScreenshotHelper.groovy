package com.yudi.helpers
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import java.text.SimpleDateFormat

class ScreenshotHelper {
    @Keyword
    def capture(String prefix = "ss") {
        String t = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date())
        WebUI.takeScreenshot("Reports/${prefix}_${t}.png")
    }
}
