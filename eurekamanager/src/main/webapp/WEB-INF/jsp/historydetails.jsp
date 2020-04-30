<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head></head>
<body>
    <table cellpadding="0" cellspacing="0" border="1" style="text-align: center">
        <tr>
            <td>姓名</td>
            <td>${card.baseInfo.name}</td>
        </tr>
        <tr>
            <td>卡号</td>
            <td>${card.cardNum}</td>
        </tr>
        <tr>
            <td>交易类型</td>
            <td>${card.transaction.abstracts}</td>
        </tr>
        <tr>
            <td>交易时间</td>
            <td><fmt:formatDate value="${card.transaction.transDate}" pattern="yyyy-MM-dd HH:mm:ss"/> </td>
        </tr>
        <tr>
            <td>交易金额</td>
            <td>${card.transaction.transMoney}</td>
        </tr>
        <tr>
            <td>账单生成日期</td>
            <td><fmt:formatDate value='${card.transaction.transDate}' pattern='yyyy-MM-dd' /></td>
        </tr>
    </table>
</body>
</html>