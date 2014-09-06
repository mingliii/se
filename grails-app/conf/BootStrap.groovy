import com.se.Account

class BootStrap {

    def init = { servletContext ->
        Account acc1 = [name:'Ming', email : 'li.ming116@gmail.com', balance: 200d]
        Account acc2= [name:'Hao', email : 'changhao87@gmail.com', balance: 200d]
        acc1.save()
        acc2.save()
    }
    def destroy = {
    }
}
