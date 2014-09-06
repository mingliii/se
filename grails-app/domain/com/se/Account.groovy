package com.se

class Account {

    String name
    String email
    double balance

    static hasMany = [transactions: Transaction]

    static constraints = {
        name blank: false, unique: true
        email email: true, blank: false
        balance validator: {
            val, obj -> val > 0
        }
    }
}
