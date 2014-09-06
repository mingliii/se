package com.se

class PayService {

    static transactional = true

    def transactionService

    def transfer(Account from, Account to, double amount) {
        from.balance -= amount
        to.balance += amount
        transactionService.create(from, to, amount)
        from.save(true)
        to.save(true)

    }
}
