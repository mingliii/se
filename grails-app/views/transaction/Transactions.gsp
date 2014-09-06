<%--
  Created by IntelliJ IDEA.
  User: Ming
  Date: 05/09/2014
  Time: 20:57
--%>

<%@ page import="com.se.Transaction; com.se.Account" contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>See transactions</title>
    <meta name="layout" content="main" />
</head>
<body>
<div>
    <h2>Pay</h2>
    <br/>
    <g:renderErrors bean="${account}"/>
    <g:form>
    <b>Person:</b> <g:select name="account.id" from="${Account.list()}" noSelection='["":"-----select-----"]' optionKey="id"  optionValue="name"/>
    <br/>
    <b><g:actionSubmit action="list" value="Refresh" id="refresh"/> </b>
    <br/>
    ------------------------------------------------------
    <div class="balance">Balance: </div>
    </g:form>

    <div class="transactions" hidden>
        <table>
            <tr class="header">
                <th>Ref</th>
                <th>Money In</th>
                <th>Money Out</th>
                <th>Balance</th>
                <th>Created Time</th>
            </tr>
        </table>
    </div>
</div>

<g:javascript src="libs/jquery-2.1.1.min.js"/>
<g:javascript src="loadTransactions.js"/>
</body>
</html>