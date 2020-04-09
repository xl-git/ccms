<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>账户下卡片信息页面</title>
</head>
<body>
<h2>账户下卡片信息</h2>
<table border="1" cellpadding="0" cellspacing="0">
    <tr>
        <td>
            卡号：
        </td>
        <td>
            <input name="cNum" type="text" value=""  />
        </td>
    </tr>
    <tr>
        <td>
            主卡/附属卡：
        </td>
        <td>
            <select>
                <option>
                    主卡
                </option>
                <option>
                    附属卡
                </option>
            </select>
        </td>
    </tr>
    <tr>
        <td>
            <a href="">卡别（种类）：</a>
        </td>
        <td>
            <input name="cType" type="text" value=""  />
        </td>
    </tr>
    <tr>
        <td>
            持卡人：
        </td>
        <td>
            <input name="cardholder" type="text" value=""  />
        </td>
    </tr>
    <tr>
        <td>
            开卡状态：
        </td>
        <td>
            <input name="openStatus" type="text" value=""  />
        </td>
    </tr>
</table>
</body>
</html>