package com.se

class MessageService {

    static transactional = false

    static final String TRANSACTION_NOTICE = "---New Transaction!!!---"
    def mailService

    def send(Account fromAcc, String fromMsg, Account toAcc, String toMsg) {
        mailService.sendMail {
            to toAcc.email
            from fromAcc.email
            subject TRANSACTION_NOTICE
            body "Transaction details"
        }
    }
}
