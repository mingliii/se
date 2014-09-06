package com.se

class PayController {

    def payService
    def messageService

    def index = {
        render(view: 'pay')
    }

    @SuppressWarnings("GroovyAssignabilityCheck")
    def pay = {
        Account from = Account.get(params?.from)
        Account to = Account.get(params?.to)
        double amount = params.double('amount')

        payService.transfer(from, to, amount)
        render(view: 'pay')
    }
}
