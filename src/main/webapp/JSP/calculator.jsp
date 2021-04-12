<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
        <title>JSP Page</title>
    </head>
    <body style="background-color:#ff1;">
        <c:url value="calculator.jsp" var="submitUrl" />
        <form action="${submitUrl}" method="GET">
            <table border="0">
                <tbody>
                    <tr>
                        <td>Первое число: </td>
                        <td><input type="text" name="firstNum" value="" /></td>
                    </tr>
                    <tr>
                        <td>Второе число: </td>
                        <td><input type="text" name="secondNum" value="" /></td>
                    </tr>
                    <tr>
                        <td>Операция: </td>
                        <td>
                            <select name="oper">
                                <option value="1">Сложение</option>
                                <option value="2">Вычитание</option>
                                <option value="3">Деление</option>
                                <option value="4">Умножение</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2"><input type="submit" name="res" value="Вперед!"></td>
                    </tr>
                </tbody>
            </table>
        </form>
        <c:if test="${param.res != null}">
            <jsp:useBean id="Calc" scope="request" class="com.jsplesson.calc.Calculator" />
            <jsp:setProperty name="Calc" property="firstNum" param="firstNum" />
            <jsp:setProperty name="Calc" property="secondNum" param="secondNum" />
            <jsp:setProperty name="Calc" property="oper" param="oper" />

            <h2>Результаты расчетов</h2>
            <div>Число №1 = <jsp:getProperty name="Calc" property="firstNum" /> </div>
            <div>Число №2 = <jsp:getProperty name="Calc" property="secondNum" /> </div>
            <div>Ответ = <jsp:getProperty name="Calc" property="result" /> </div>
        </c:if>
    </body>
</html>