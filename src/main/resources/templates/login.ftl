<html>
<head>

</head>

<body>
    <form id="login_form" action="/reg/" method="post">
        <p>
        <label for="name">账号</label>
        <input name="name" id="name" type="text" placeholder="手机号或邮箱"/>
        </p>
        <p>
        <label for="name">密码</label>
        <input name="password" id="password" type="password" placeholder="密码"/>
        </p>
        <button type="submit" onclick="form = document.getElementById('login_form');form.action = '/login/'">登录</button>
        <button type="submit" onclick="form = document.getElementById('login_form');form.action = '/reg/'">注册</button>

        <input type="checkbox" value="true" name="rememberme" checked="">记住我
        <br>
        <#if msg?exists>
           <p style="color: red"> ${msg}</p >
        </#if>
    </form>
</body>

</html>