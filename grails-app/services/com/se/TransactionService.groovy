package com.se

import org.apache.commons.lang.RandomStringUtils

/**
 * Created by Ming on 05/09/2014.
 */
class TransactionService {

    static transactional = true

    def create(Account from, Account to, double amount){
        Date current = new Date()
        String ref = RandomStringUtils.randomNumeric(10)
        Transaction fromTransaction = [ref: ref, createdTime: current, account: from, amount: -amount, balance: from.balance]
        Transaction toTransaction = [ref: ref, createdTime: current, account: to, amount: amount,balance: from.balance]
        fromTransaction.save(true)
        toTransaction.save(true)
        from.transactions << fromTransaction
        to.transactions << toTransaction
    }
}
