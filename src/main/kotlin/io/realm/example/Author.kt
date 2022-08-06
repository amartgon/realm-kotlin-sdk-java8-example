package io.realm.example

import io.realm.kotlin.types.RealmObject

class Author : RealmObject {
    var firstName: String? = ""
    var lastName: String? = ""
    var age: Int? = 0
}