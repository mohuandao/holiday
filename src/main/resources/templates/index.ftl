<html>
<head>
    <meta charset="utf-8">
    <title>测试用</title>


    <script src="http://static.runoob.com/assets/jquery-validation-1.14.0/lib/jquery.js"></script>
    <script src="http://static.runoob.com/assets/jquery-validation-1.14.0/dist/jquery.validate.min.js"></script>
    <script src="http://static.runoob.com/assets/jquery-validation-1.14.0/dist/localization/messages_zh.js"></script>
    <script >
        debugger;
        $().ready(function(){
            $("#wdtet").validate({
                rules:{
                    name:"required",
                    sex:{required:true},
                    age:{required:true,minlength:5},
                    hobby:{required:true,minlength:5}
                },
                messages:{
                    name:"请输入姓名",
                    sex:{required:"不能为空"},
                    age:{required:"请输入密码",minlength:"不能小于5个字符"},
                    hobby:{required:"请输入确认密码",minlength:"不能小于5个字符"}
                }
            });
        });
    </script>
    <style>
        .error{
            color:red;
        }
    </style>

</head>
<body>


<form id="wdtet" action="/adduser/" method="post">
    <p>
        <label for="name">姓名</label>
        <input id="name" name="name" type="text"/>
    </p>
    <p>
        <label for="sex">性别</label>
        <input id="sex" name="sex" type="text"/>
    </p>
    <p>
        <label for="age">年龄</label>
        <input id="age" name="age" type="text"/>
    </p>
    <p>
        <label for="hobby">爱好</label>
        <input id="hobby" name="hobby" type="text"/>
    </p>
    <input id="submit" type="submit" value="提交">
</form>

<form id="excel_one" action="/export_1"></form>
<button id="excel_one_button">导出单sheet</button>
<script>
    $("#excel_one_button").click(function () {
        $("#excel_one").submit();
    });

</script>
</body>
</html>
