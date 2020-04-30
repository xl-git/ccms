<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta charset="utf-8">
  <title>信用卡管理系统</title>
  <meta name="renderer" content="webkit">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <link rel="shortcut icon" href="/favicon.ico" type="image/x-icon" />
  <meta name="apple-mobile-web-app-status-bar-style" content="black">
  <meta name="apple-mobile-web-app-capable" content="yes">
  <meta name="format-detection" content="telephone=no">
  <!--<script type="text/javascript" src="/static/xiyuan/lib/loading/okLoading.js"></script>-->
  <link rel="stylesheet" href="./css/x-admin.css" media="all">
</head>
<style>
  .show_list{display: block;}
  .hide_lits{display: none;}

</style>
<body>
<div class="layui-layout layui-layout-admin">
  <div class="layui-header header header-demo">
    <div class="layui-main">
      <div class="admin-logo-box">
        <a class="logo" href="" title="logo">信用卡管理系统</a>
        <div class="larry-side-menu">
          <i class=" layui-icon iconfont" aria-hidden="true">&#xe83c;</i>
        </div>
      </div>
      <ul class="layui-nav layui-layout-left layui-ygyd-menu" style="position:absolute; left:250px;">
        <li class="layui-nav-item daohang" ids="#table1"><a href="javascript:;"></a></li>
      </ul>

      <ul class="layui-nav" lay-filter="">
        <li class="layui-nav-item" id="time" style="margin-right: 50px;font-size: 20px;color: #2fb9d4;font-family: 'yjsz'"></li>
        <li class="layui-nav-item"><img src="./images/logo.png" class="layui-circle" style="border: 2px solid #A9B7B7;" width="35px" alt=""></li>
        <li class="layui-nav-item"> <a href="javascript:;">${loginUser.userName}</a>
          <dl class="layui-nav-child">
            <!-- 二级菜单 -->
            <dd><a href="/user/login.html">切换帐号</a></dd>
			<dd><a href="/user/login.html">注册</a></dd>
          </dl>
        </li>
      </ul>
    </div>
  </div>

  <!--左侧导航区域-->
  <div class="layui-side layui-bg-black x-side show_list" style="left:0px;" id="table1">
    <div style="height: 130px; width: 220px; ">
      <a class="img" title="我的头像" style="display: block;width: 80px;height: 80px;margin: 10px auto 10px;">
        <img src="./images/logo.png" class="userAvatar" style="display: block;width: 100%;height: 100%;border-radius: 50%;-webkit-border-radius: 50%;-moz-border-radius: 50%;border: 4px solid #44576b;box-sizing: border-box;">
      </a>
      <p style=" display: block;width: 100%;height: 25px;color: #ffffff;text-align: center;font-size: 12px;white-space: nowrap;line-height: 25px;overflow: hidden;">
        你好！<span class="userName">${loginUser.userName}</span>, 欢迎回来
      </p>
    </div>
    <div class="layui-side-scroll">
      <ul class="layui-nav layui-nav-tree site-demo-nav" lay-filter="side">
        <li class="layui-nav-item"> <a class="javascript:;" href="javascript:;"> <i class="layui-icon iconfont" style="top: 3px;">&#xe65c;</i><cite>客户管理</cite> </a>
          <dl class="layui-nav-child">
            <dd class="">
            <dd class=""> <a href="javascript:;" _href="http://localhost:8004/customermanage/customerselect.html"> <cite>客户基本账户信息</cite> </a> </dd>
            <dd class=""> <a href="javascript:;" _href="http://localhost:8004/customermanage/cardinfo.html"> <cite>账户下卡片信息</cite> </a> </dd>

            <dd class=""> <a href="javascript:;" _href="http://localhost:8004/customermanage/onlinepro.html"> <cite>网上申请进度查询</cite> </a> </dd>
              <dd class=""> <a href="javascript:;" _href="http://localhost:8004/customermanage/emailset.html"> <cite>Email地址设置</cite> </a> </dd>
            </dd>
          </dl>
        </li>
        <li class="layui-nav-item"> <a class="javascript:;" href="javascript:;"> <i class="layui-icon iconfont" style="top: 3px;">&#xe661;</i><cite>账户管理</cite> </a>
          <dl class="layui-nav-child">
            <dd class="">
            <dd class=""> <a href="javascript:;" _href="http://localhost:8006/accountManage/index.htm"> <cite>账户总览</cite> </a> </dd>
            <dd class=""> <a href="javascript:;" _href="http://localhost:8006/accountManage/accountQuery.html"> <cite>账户查询</cite> </a> </dd>
			<dd class=""> <a href="javascript:;" _href="http://localhost:8006/accountManage/alreadyAccount.html"> <cite>已出账单查询</cite> </a> </dd>
			<dd class=""> <a href="javascript:;" _href="http://localhost:8006/accountManage/notAccount.html"> <cite>未出账单查询</cite> </a> </dd>
            </dd>
          </dl>
        </li>
        <li class="layui-nav-item"> <a class="javascript:;" href="javascript:;"> <i class="layui-icon iconfont" style="top: 3px;">&#xe60b;</i><cite>分期管理</cite> </a>
          <dl class="layui-nav-child">
            <dd class="">
            <dd class=""> <a href="javascript:;" _href="http://localhost:8005/staging/apply.html"> <cite>分期申请</cite> </a> </dd>
            </dd>
            <dd class="">
            <dd class=""> <a href="javascript:;" _href="http://localhost:8005/staging/currapply.html"> <cite>当前申请查询</cite> </a> </dd>
            </dd>
            <dd class="">
            <dd class=""> <a href="javascript:;" _href="http://localhost:8005/staging/hisapply.html"> <cite>历史申请查询</cite> </a> </dd>
            </dd>
          </dl>
        </li>
        <li class="layui-nav-item"> <a class="javascript:;" href="javascript:;"> <i class="layui-icon iconfont" style="top: 3px;">&#xe621;</i><cite>还款管理</cite> </a>
          <dl class="layui-nav-child">
            <dd class=""> <a href="javascript:;" _href="http://localhost:8007/repaymentmanage/repayment.html"> <cite>快速还款</cite> </a> </dd>
          </dl>
          <dl class="layui-nav-child">
            <dd class=""> <a href="javascript:;" _href="http://localhost:8007/repaymentmanage/detail.html"> <cite>还款明细</cite> </a> </dd>
          </dl>
        </li>
        <li class="layui-nav-item"> <a class="javascript:;" href="javascript:;"> <i class="layui-icon iconfont" style="top: 3px;">&#xe60f;</i><cite>卡片管理</cite> </a>
          <dl class="layui-nav-child">
            <dd class=""> <a href="javascript:;" _href="http://localhost:8003/cardmanage/cardsystem/1"> <cite>在线挂失</cite> </a> </dd>
            <dd class=""> <a href="javascript:;" _href=http://localhost:8003/cardmanage/cardsystem/3> <cite>交易密码管理</cite> </a> </dd>
            <dd class=""> <a href="javascript:;" _href=http://localhost:8003/cardmanage/cardsystem/2"> <cite>销卡</cite> </a> </dd>
          </dl>
        </li>
        <li class="layui-nav-item"> <a class="javascript:;" href="javascript:;"> <i class="layui-icon iconfont" style="top: 3px;">&#xe60f;</i><cite>办卡</cite> </a>
          <dl class="layui-nav-child">
            <dd class=""> <a href="javascript:;" _href="http://localhost:8003/cardmanage/cardadd/1"> <cite>普卡</cite> </a> </dd>
            <dd class=""> <a href="javascript:;" _href="http://localhost:8003/cardmanage/cardadd/2"> <cite>金卡</cite> </a> </dd>
            <dd class=""> <a href="javascript:;" _href="http://localhost:8003/cardmanage/cardadd/3"> <cite>白金卡</cite> </a> </dd>
          </dl>
        </li>
      </ul>
    </div>
  </div>


  <div class="layui-tab layui-tab-card site-demo-title x-main" lay-filter="x-tab" lay-allowclose="true" style="left: 220px;border-left: solid 2px #2299ee;">
    <ul class="layui-tab-title">
      <li class="layui-this"> 我的桌面 <i class="layui-icon layui-unselect layui-tab-close">ဆ</i> </li>
    </ul>
    <div class="layui-tab-content site-demo site-demo-body">
      <div class="layui-tab-item layui-show">
        <iframe frameborder="0" src="/user/welcome.html" class="x-iframe"></iframe>
      </div>
    </div>
  </div>
  <div class="site-mobile-shade"> </div>

</div>

<script src="./lib/layui/layui.js" charset="utf-8"></script>
<script src="./js/x-admin.js"></script>
<script src="./js/jquery.min.js"></script>
<script src="./js/x-layui.js" charset="utf-8"></script>

<script>
    $(".daohang").click(function(){
        var table = $(this).attr("ids");
        var ids = $(".show_list").attr("id");
        $("#"+ids+"").addClass("hide_lits");
        $("#"+ids+"").removeClass("show_list");
        $(""+table+"").removeClass("hide_lits");
        $(""+table+"").addClass("show_list");
    })


</script>
<script>
    layui.use(['laydate','element','laypage','layer'], function(){
        $ = layui.jquery;//jquery
        laydate = layui.laydate;//日期插件
        lement = layui.element();//面包导航
        laypage = layui.laypage;//分页
        layer = layui.layer;//弹出层
        //以上模块根据需要引入
    });

    function member_show(title,url,id,w,h){
      x_admin_show(title,url,w,h);
    }
</script>
<script>
    //顶部时间
    function getTime(){
        var myDate = new Date();
        var myYear = myDate.getFullYear(); //获取完整的年份(4位,1970-????)
        var myMonth = myDate.getMonth()+1; //获取当前月份(0-11,0代表1月)
        var myToday = myDate.getDate(); //获取当前日(1-31)
        var myDay = myDate.getDay(); //获取当前星期X(0-6,0代表星期天)
        var myHour = myDate.getHours(); //获取当前小时数(0-23)
        var myMinute = myDate.getMinutes(); //获取当前分钟数(0-59)
        var mySecond = myDate.getSeconds(); //获取当前秒数(0-59)
        var week = ['星期日','星期一','星期二','星期三','星期四','星期五','星期六'];
        var nowTime;

        nowTime = myYear+'-'+fillZero(myMonth)+'-'+fillZero(myToday)+'&nbsp;&nbsp;'+fillZero(myHour)+':'+fillZero(myMinute)+':'+fillZero(mySecond)+'&nbsp;&nbsp;'+week[myDay]+'&nbsp;&nbsp;';
        //console.log(nowTime);
        $('#time').html(nowTime);
    };
    function fillZero(str){
        var realNum;
        if(str<10){
            realNum	= '0'+str;
        }else{
            realNum	= str;
        }
        return realNum;
    }
    setInterval(getTime,1000);
</script>
</body>
</html>