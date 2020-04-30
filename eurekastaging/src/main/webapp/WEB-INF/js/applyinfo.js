
$("#amount").blur(function () {
    alert(1)
    var money=$("#money");
    var lendmoney=$("#lendmoney").val();
    money.val(lendmoney-$("#amount").val());
});

function changAmount() {

}