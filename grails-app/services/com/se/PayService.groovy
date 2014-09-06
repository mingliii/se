package com.se

class PayService {

    static transactional = true

    def transactionService

    def transfer(Account from, Account to, double amount) {
        from.balance -= amount
        if(from.validate()){
            to.balance += amount
            transactionService.create(from, to, amount)
            from.save(failOnError: true)
            to.save(failOnError:true)
        }
    }
}
