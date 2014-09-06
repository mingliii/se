package com.se

import groovy.text.GStringTemplateEngine

class TransactionController {

    private static final String DATE_FORMAT = "yyyy-MM-dd hh:mm:ss"
    private def transactionOrder = {obj1, obj2 ->
        if(obj1.createdTime.before(obj2.createdTime)){
            return 1
        }else if(obj1.createdTime.after(obj2.createdTime)){
            return -1
        }else{
            return 0
        }
    }

    def index = {
        render(view: 'Transactions')
    }

    //ajax call
    def list = {
        Account account = Account.get(params?.'account.id')
        if(account){
            def results = Transaction.findAllByAccount(account).sort(transactionOrder)
            if (!results) {
                render(text: 'No transactions to show')
            } else {
                render(contentType: 'text/json'){
                    transactions = array {
                        for (Transaction t in results) {
                            transaction ref: t.ref,
                                    in: (t.amount > 0 ? t.amount + " (from $t.from.name)" : '') ,
                                    out: t.amount < 0 ? -t.amount + " (to $t.to.name)" : '',
                                    balance: t.balance,
                                    createdTime: t.createdTime.format(DATE_FORMAT)
                        }
                    }
                    balance = account.balance
                }
            }
            return
        }
        render(text: '')
    }
}