(function($){
    var selectEl = $('select');

    function buildContent(transactions) {
        var html = null;
        if (transactions && transactions.length > 0) {
            $.each(transactions, function(index, tran){
                html += '<tr><td>' + tran.ref + '</td><td>' + tran.in + '</td><td>' + tran.out + '</td><td>' + tran.balance + '</td><td>' + tran.createdTime + '</td></tr>';
            });
        }
        return html;
    }

    function updateTransactions () {
        var apiData = {
            'account.id' : selectEl.val()
        };
        $.ajax({
            url: '/se/transaction/list',
            method: 'GET',
            data: apiData
        }).done(function(response){
            var content = buildContent(response.transactions);
            $('.balance').text('Balance: ' + response.balance);
            $('tr:not(.header)').remove();
            $('.transactions table').append(content);
            $('.transactions').removeAttr('hidden');
        }).fail(function(response){
            // handle error
        });
    }

    selectEl.on('change', function (){
        updateTransactions();
    });

    $('#refresh').on('click', function(e) {
        e.preventDefault();
        updateTransactions();
    });
}(jQuery));