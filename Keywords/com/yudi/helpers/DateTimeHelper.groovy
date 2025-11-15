package com.yudi.helpers
import com.kms.katalon.core.annotation.Keyword
import java.text.SimpleDateFormat

class DateTimeHelper {
    @Keyword
    def now(String pattern = "yyyy-MM-dd HH:mm:ss") {
        return new SimpleDateFormat(pattern).format(new Date())
    }
}
