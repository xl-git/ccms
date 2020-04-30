<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020/4/24
  Time: 16:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>借记卡页面</title>
</head>
<body>
    <form action="/repaymentmanage/debitcard.html" method="post">
        <table>
            <tr>
                <td>
                    借记卡:
                </td>
                <td>
                    <select name="debitCardId">
                        <c:forEach var="debitCard" items="${debitCards}">
                            <option value="${debitCard.debitCardId}" >${debitCard.debitCardId}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <td>
                    密码:
                </td>
                <td>
                    <input type="text" name="pasd">
                </td>
                <td><input type="submit" value="确定"></td>
            </tr>
        </table>
            ${message1}
    </form>
</body>
</html>
