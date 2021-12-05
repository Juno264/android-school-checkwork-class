package app.doggy.checkworkclass

import kotlinx.serialization.Serializable

@Serializable // 追記
class User(val name: String, val course: String, val comment: String)