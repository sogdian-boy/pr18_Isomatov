package com.example.pr19

import java.util.UUID
import java.util.Date
data class Crime(val id:UUID = UUID.randomUUID()) {

var title: String
    get() {
        TODO()
    }
    set(value) {}
     var date:Date
         get() {
             TODO()
         }
         set(value) {}
}