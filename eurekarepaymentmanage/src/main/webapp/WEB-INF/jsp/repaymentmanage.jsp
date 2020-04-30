<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020/4/22
  Time: 10:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>快速还款页面</title >
    <script type="text/javascript" src="./js/jquery-1.8.3.min.js"></script>
    <script type="text/javascript">
            $(function () {
                $("#code").bind("click",function () {
                    $.ajax({
                        type:"GET",//请求类型
                        url:"/repaymentmanage/getphonecode.html",//请求的url
                        data:{method:"getphonecode",phone: $("#phone").val()},//请求参数
                        dataType:"json",//ajax接口（请求url）返回的数据类型
                    })
                })
            })

        </script>
</head>
<body>
<form action="addrepayment.html" method="post">
    <table>
        <tr>
            <td>
                本期账单：
            </td>
            <td>
                <input type="text" value="${gross}"  disabled="disabled"/>
            </td>
        </tr>


        <tr>
            <td>
                还款金额:
            </td>
            <td>
                <input type="text" name="current">

                <input type="hidden" name="creditCard" value="${creditCard}">
                <input type="hidden" name="debitCard}" value="${debitCard}">
                <input type="hidden" name="changePeriods" value="${changePeriods}">
                <input type="hidden" name="nowdate" value="${nowdate}">
                <input type="hidden" name="ormount" value="${ormount}">
                <input type="hidden" name="ccamount" value="${ccamount}">
            </td>
        </tr>


            <tr>
                <td>
                    输入手机号码:
                </td>
                <td>
                    <input type="text" name="phone" id="phone" nullmsg="手机号不能为空！" datatype="*11-11" errormsg="手机号为11个字符！" sucmsg="手机号格式验证通过！"/>

                </td>
            </tr>
            <tr>
                <td>
                    验证码:
                </td>
                <td>
                    <input type="text" name="nowcode" value="" nullmsg="验证码不能为空！" datatype="*6-6" errormsg="验证码有6位数！" sucmsg="验证码格式验证通过！"/>
                    <input type="button" id="code" name="" value="获取验证码">
                    ${message}
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value="确定">
                </td>



    </table>
</form>
</body>
</html>
