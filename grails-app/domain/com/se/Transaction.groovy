package com.se

class Transaction {

    String ref
    Date createdTime
    double amount
    double balance
    static belongsTo = [account: Account]
//    static hasMany = [accounts:Account]

    static constraints = {
    }
}
