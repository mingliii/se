package com.se

import groovy.text.GStringTemplateEngine

class TransactionController {
    static final String DATE_FORMAT = "yyyy-MM-dd hh:mm:ss"

    def engine = new GStringTemplateEngine()

    def index = {
        render(view: 'Transactions')
    }

    //ajax call
    def list = {
        Account account = Account.get(params?.'account.id')
        if(account){
            def results = Transaction.findAllByAccount(account)
            if (!results) {
                render(text: 'No transactions to show')
            } else {
                render(contentType: 'text/json'){
                    transactions = array {
                        for (t in results) {
                            transaction ref: t.ref,
                                    in: t.amount > 0 ? t.amount : '',
                                    out: t.amount < 0 ? -t.amount : '',
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

    private String generateAjaxTransData(List<Transaction> transactions) {
        assert transactions
        StringBuilder sb = new StringBuilder("")
        for (transaction in transactions) {
            def binding = [ref        : transaction.ref,
                           iN         : transaction.amount > 0 ? transaction.amount : '',
                           ouT        : transaction.amount < 0 ? -transaction.amount : '',
                           balance    : transaction.account.balance,
                           createdTime: transaction.createdTime.format("yyyy-MM-dd hh:mm:ss")
            ]
            sb.append(engine.createTemplate(TRANSACTION_TABLE_DATA).make(binding))
        }
        return sb.toString()
    }

    private static final String TRANSACTION_TABLE_DATA = '''
            <td>${ref}</td>
            <td>${iN}</td>
            <td>${ouT}</td>
            <td>${balance}</td>
            <td>${createdTime}</td>
'''
}