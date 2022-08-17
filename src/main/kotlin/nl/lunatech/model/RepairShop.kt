package nl.lunatech.model

import javax.persistence.GeneratedValue
import javax.persistence.Id

//@Entity TODO: Add table to repo in order to get cars from there.
class RepairShop {
    @Id
    @GeneratedValue
    var id: Long? = null
    lateinit var name: String
    lateinit var address: String
}