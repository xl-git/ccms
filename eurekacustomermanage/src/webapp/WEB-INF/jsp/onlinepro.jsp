<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>网上申请进度查询页面</title>
</head>
<body>
    <h2>网上申请进度查询</h2>
    <table border="1" cellpadding="0" cellspacing="0">
        <tr>
            <td>
                证件类型：
                <select>
                    <option value="0">
                        请选择
                    </option>
                    <option value="1">
                        身份证
                    </option>
                    <option value="1">
                        外籍护照
                    </option>
                    <option value="1">
                        军官证
                    </option>
                    <option value="1">
                        港澳通行证
                    </option>
                    <option value="1">
                        其他样式
                    </option>
                </select>
            </td>
        </tr>
        <tr>
            <td>
                证件号码：
            </td>
            <td>
                <input name="certificatenum" type="text" >
            </td>
        </tr>
    </table>
</body>
</html>