package io.realm.example

import io.realm.kotlin.Realm
import io.realm.kotlin.RealmConfiguration
import io.realm.kotlin.ext.query
import io.realm.kotlin.query.RealmResults


class AuthorManager() {

    val realm = Realm.open(RealmConfiguration.create(schema = setOf(Author::class)) )

    fun addAuthor(firstName: String?, lastName: String?, age: Int?) {
        realm.writeBlocking {
            copyToRealm(Author().apply {
                this.firstName = firstName
                this.lastName = lastName
                this.age = age
            })
        }
    }

    fun findAuthors(): RealmResults<Author> {
        return realm.query<Author>().find()
    }
}

