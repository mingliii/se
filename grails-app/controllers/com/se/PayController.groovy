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

        if(!from){
            render ()
        }else if(!to){
            render ()
            return
        }else if(from.is(to)){
            to.errors.reject(
                    "pay.to.itself",
                    [to.name] as Object[],
                    "Account {0} can not pay to itself")
        }else if(amount <= 0 ){
            from.errors.reject(
                    'pay.amount.invalid',
                    [from.name, to.name] as Object[],
                    "Account {0} can not pay NONE to Account {1}")
        }else if(amount > from.balance ){
            from.errors.reject(
                    'account.balance.not.enough',
                    [from.name, amount, to.name] as Object[],
                    "Account {0} does not have enough balance to pay {1} to Account {2}")
        }else {
            payService.transfer(from, to, amount)
            flash.successMsg = 'Payment is successful!'
        }
        render(view: 'Pay' , model: [from: from, to:to])
    }
}
