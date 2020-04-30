<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8">
    <title>激活</title>
    <script type="text/javascript" src="./js/jquery-1.8.3.min.js"></script>
    <script type="text/javascript">
        $(function () {
            $("#activate").bind("click", function () {
                $.ajax({
                    type: "GET",//请求类型
                    url: "/manager/actiavtion.html",//请求的url
                    data: {method: "relieve", cardNum: $("#cardNum").val(),phone: $("#phone").val()},//请求参数
                    dataType: "json",//ajax接口（请求url）返回的数据类型
                    success: function (data) {//data：返回数据（json对象）
                        if (data.result == "true") {
                            alert("激活成功！")
                            window.location.href="/manager/findactivate.html?cardNum=${cardNum}"
                        }else{
                            alert("操作失败！")
                            window.location.href="/manager/activate.html"
                        }
                    }
                });
            });
        })
    </script>
</head>

<body>
<div>
    <form action="/manager/findactivate.html" method="post">
        <div>
            <label>卡 号：</label>
            <input type="text"   name="cardNum" value="${cardNum}" >
            <input type="submit" value="搜索">
        </div>
        <div style="color: red">${message}</div>
        <table>
            <tr>
                <td>用户序号:</td>
                <td>
                    <input type="text" value="${card.baseInfo.userId}" >
                </td>
            </tr>
            <tr>
                <td>用户卡号:</td>
                <td>
                    <input type="text" id="cardNum" value="${card.cardNum}" readonly="readonly">
                </td>
            </tr>
            <tr>
                <td>用户姓名:</td>
                <td>
                    <input type="text"  value="${card.baseInfo.name}" readonly="readonly">
                </td>
            </tr>
            <tr>
                <td>身份证号:</td>
                <td>
                    <input type="text" value="${card.baseInfo.identityCard}" readonly="readonly">
                </td>
            </tr>
            <tr>
                <td>手机号:</td>
                <td>
                    <input type="text" id="phone" value="${card.baseInfo.iphoneNum}" readonly="readonly">
                </td>
            </tr>
            <tr>
                <td>状态:</td>
                <td>
                    <input type="text" value="${card.cardStatus.status}" readonly="readonly">
                </td>
            </tr>
        </table>
    </form>
    <div>
        <input type="button" id="activate" value="激活" >
        <input type="button" id="noactivate" value="待激活" onclick="window.location.href='/manager/noactivate.html'" >
    </div>
</div>
</body>
</html>