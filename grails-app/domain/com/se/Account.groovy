package com.se

class Account {

    String name
    String email
    double balance

    static hasMany = [transactions: Transaction]

    static constraints = {
    }
}
