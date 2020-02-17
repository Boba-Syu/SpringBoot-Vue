package cn.bobasyu.entity

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int? = null
    var cname: String? = null
    var csex: String? = null
    var cschool: String? = null
    var clevel: String? = null
    var cpower: String? = null
    var cgrade: String? = null
}