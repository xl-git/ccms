<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <meta charset="utf-8">
    <title>办卡申请</title>
</head>

<body>
<div>
    <h2>
        填写基本信息
    </h2>
    <form action="${pageContext.request.contextPath }/savecard.html" method="post">
        <div id="baseinfo_div">
           <table>
               <tr>
                   <td>
                        姓名：
                   </td>
                   <td>
                       <input type="text" name="name" value="">*
                   </td>
               </tr>
               <tr>
                   <td>
                        证件号：
                   </td>
                   <td>
                       <input type="text" name="identityCard" value="">*
                   </td>
               </tr>
               <tr>
                   <td>
                        证件类型：
                   </td>
                   <td>
                       <select name="">
                           <option value="1">
                               中华人民共和国居民身份证
                           </option>
                           <option value="1">
                               其他
                           </option>
                       </select>*
                   </td>
               </tr>

               <tr>
                   <td>
                        手机号码：
                   </td>
                   <td>
                       <input type="text" id="phone1" name="iphoneNum" value="">*
                   </td>
               </tr>
               <tr>
                   <td>
                        手机验证码：
                   </td>
                   <td>
                       <input type="text" name="CadoDemo" value="">*
                       <input id="but1" type="button" name="but1" value="获取验证码"/>
                       <span id="mag"></span>
                   </td>
               </tr>
               <tr>
                   <td>
                        民族：
                   </td>
                   <td>
                       <input type="text" name="nation" value="${baseinfo.nation}">
                   </td>
               </tr>
               <tr>
                   <td>
                        婚姻状况:
                   </td>
                   <td>
                       <select name="education">
                           <option value="1">
                               未婚
                           </option>
                           <option value="2">
                               已婚
                           </option>
                           <option value="3">
                               离异
                           </option>
                           <option value="4">
                               丧偶
                           </option>
                       </select>
                   </td>
               </tr>
               <tr>
                   <td>
                        受教育程度：
                   </td>
                   <td>
                       <select name="education">
                           <option value="1">
                               小学
                           </option>
                           <option value="2">
                               初中
                           </option>
                           <option value="3">
                               高中
                           </option>
                           <option value="4">
                               大专
                           </option>
                           <option value="5">
                               本科
                           </option>
                           <option value="6">
                               本科以上
                           </option>
                       </select>*
                   </td>
               </tr>
               <tr>
                   <td>
                        安全问题：
                   </td>
                   <td>
                       <select name="questionId">
                           <option value="1">
                               您父亲的名字
                           </option>
                           <option value="2">
                               您初中班主任的名字
                           </option>
                           <option value="3">
                               您配偶的名字
                           </option>
                           <option value="4">
                               您好朋友的名字
                           </option>
                       </select>
                   </td>
               </tr>
               <tr>
                   <td>
                        预留答案：
                   </td>
                   <td>
                       <input type="text" name="answer" value="">*
                   </td>
               </tr>
               <tr>
                   <td>
                        现住宅地址：
                   </td>
                   <td>
                       <input type="text" name="homeAddress" value="">*
                   </td>
               </tr>
               <tr>
                   <td>
                        邮政编码：
                   </td>
                   <td>
                       <input type="text" name="baseMail" value="">
                   </td>
               </tr>
           </table>
            <center><input type="button" id="but2" value="下一步" style=""/></center>
        </div>
        <div id="unitinfo_div" style="display: none">
            <h2>单位信息</h2>
            <table>
                <tr>
                    <td>
                        单位名称：
                    </td>
                    <td>
                        <input type="text" name="companyName" value="">*
                    </td>
                </tr>
                <tr>
                    <td>
                        单位性质：
                    </td>
                    <td>
                        <select name="companyTpe">
                            <option value="1">
                                国有企业
                            </option>
                            <option value="2">
                                私营企业
                            </option>
                            <option value="3">
                                事业单位
                            </option>
                            <option value="4">
                                政府机关
                            </option>
                            <option value="5">
                                个体户
                            </option>
                        </select>*
                    </td>
                </tr>
                <tr>
                    <td>
                        单位电话：
                    </td>
                    <td>
                        <input type="text" name="unitIphone" value=""/>*
                    </td>
                </tr>

                <tr>
                    <td>
                        单位地址：
                    </td>
                    <td>
                        <input type="text" id="unitAddress" name="unitAddress" value="">*
                    </td>
                </tr>
                <tr>
                    <td>
                        年收入：
                    </td>
                    <td>
                        <select name="companyTpe">
                            <option value="1">
                                5万以下
                            </option>
                            <option value="2">
                                5~15万
                            </option>
                            <option value="3">
                                15~30万
                            </option>
                            <option value="4">
                                30~50万
                            </option>
                            <option value="5">
                                50万以上
                            </option>
                        </select>*
                    </td>
                </tr>
                <tr>
                    <td>
                       担任职务：
                    </td>
                    <td>
                        <select name="duty">
                            <option value="总经理">
                                总经理
                            </option>
                            <option value="销售经理">
                                销售经理
                            </option>
                            <option value="技术部长">
                                技术部长
                            </option>
                            <option value="生产部长">
                                生产部长
                            </option>
                            <option value="采购主管">
                                采购主管
                            </option>
                            <option value="财务主管">
                                财务主管
                            </option>
                            <option value="人事行政主管">
                            人事行政主管
                            </option>
                            <option value="其他">
                                其他
                            </option>
                        </select>*
                    </td>
                </tr>
                <tr>
                    <td>
                        邮政编码:
                    </td>
                    <td>
                        <input type="text" name="unitMail" value=""/>
                    </td>
                </tr>
            </table>
            <center>
                <input type="button" id="but3" value="下一步" style=""/>
                <input type="button" id="but4" value="返回" style=""/>
            </center>
        </div>
        <div id="contactinfo_div" style="display: none">
            <h2>联系人信息</h2>
            <table>
                <tr>
                    <td>
                        联系人姓名：
                    </td>
                    <td>
                        <input type="text" name="contactName" value="">*
                    </td>
                </tr>
                <tr>
                    <td>
                        联系人电话：
                    </td>
                    <td>
                        <input type="text" name="contactIphone" value="">*
                    </td>
                </tr>
                <tr>
                    <td>
                        与主卡申请人的关系：
                    </td>
                    <td>
                        <select name="relation">
                            <option value="1">
                                父子
                            </option>
                            <option value="2">
                                母子
                            </option>
                            <option value="3">
                                夫妻
                            </option>
                            <option value="4">
                                亲戚
                            </option>
                            <option value="5">
                                朋友
                            </option>
                            <option value="6">
                                同事
                            </option>
                        </select>*
                    </td>
                </tr>

                <tr>
                    <td>
                        E-mail账单地址：
                    </td>
                    <td>
                        <input type="text" name="email" value="">*
                    </td>
                </tr>
                <tr>

                    <td><input type="checkbox" id="checkbox1" value="0" ><a href="">知情书</a></td>
                </tr>
            </table>
            <center>
                <input type="submit" id="but5" value="提交" disabled="disabled"/>
                <input type="button" id="but6" value="返回" />
            </center>
        </div>
    </form>
</div>
<span>${msg}</span>

<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.8.2.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/cardadd.js"></script>
</body>
</html>