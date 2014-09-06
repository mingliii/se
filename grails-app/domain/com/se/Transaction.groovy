package com.se

class Transaction {

    String ref
    Date createdTime
    double amount
    double balance
    static belongsTo = [account: Account]
    Account from
    Account to
//    static hasMany = [accounts:Account]

    static constraints = {
    }
}
