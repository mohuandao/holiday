<html>
<head>
    <meta charset="utf-8">
    <link rel="stylesheet" href="/layui/css/layui.css">
    <script src="/layui/layui.js"></script>

</head>

<body>
<table id="demo" lay-filter="test"></table>
<script>
    layui.use('table', function(){
        var table = layui.table;

        //第一个实例
        table.render({
            elem: '#demo'
            ,height: 315
            ,url: '/query/cproject' //数据接
            ,page: true //开启分页
            ,cols: [[ //表头
                {field: 'xmmc', title: '项目名称', width:400}
                ,{field: 'jzgbh', title: '教职工编号', width:160, sort: true}
                ,{field: 'xybh', title: '学院编号', width:160}
                ,{field: 'nf', title: '年份', width: 177}
                ,{field: 'rkfs', title: '入库方式', width: 80, sort: true}
                ,{field: 'spjg', title: '审批结果', width: 80, sort: true}
                ,{field: 'lczt', title: '流程状态', width: 80}

            ]]
        });

    });



</script>
<button id="btn_test">弹出框</button>
<script>
    $("#btn_test").on('click',function () {

        /*layer.open({
            title:"sadsa"
            ,content:"dsadsad"
        });*/
        alert("sadsa");
    });
</script>
</body>

</html>