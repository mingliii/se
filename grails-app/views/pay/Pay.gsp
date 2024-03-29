<%--
  Created by IntelliJ IDEA.
  User: Ming
  Date: 05/09/2014
  Time: 20:57
--%>

<%@ page import="com.se.Account" contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Pay Some Person</title>
    <meta name="layout" content="main" />
</head>
<body>
<g:renderErrors bean="${from}"/>
<div>
    <h2>Pay</h2>
    <br/>
    <g:form>
    <b>From:</b> <g:select name="from" from="${Account.list()}" value="${from?.id}" noSelection='["":"-----select-----"]' optionKey="id"  optionValue="name"/>
    <br/>
    <b>To: </b> <g:select name="to" from="${Account.list()}" value="${to?.id}" noSelection='["":"-----select-----"]' optionKey="id"  optionValue="name"/>
    <br/>
    <b>Amount:</b> <g:textField name="amount" value="0.00" maxlength="8"/>
    <br/>
    <b><g:actionSubmit value="Pay" action="pay"/> </b>
    </g:form>
    <g:if test="${flash.successMsg}">
        <span>${flash.successMsg}</span>
    </g:if>
</div>
</body>
</html>