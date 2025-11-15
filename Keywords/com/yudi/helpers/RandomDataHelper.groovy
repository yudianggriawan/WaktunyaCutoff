package com.yudi.helpers
import com.kms.katalon.core.annotation.Keyword

class RandomDataHelper {
    @Keyword
    def randomEmail() {
        String uid = UUID.randomUUID().toString().replace("-", "").substring(0,8)
        return "test_${uid}@example.com"
    }
}
