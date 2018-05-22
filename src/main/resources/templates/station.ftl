<html>
<head>
    <meta charset="utf-8">
    <link rel="stylesheet" href="/layui/css/layui.css">
    <script src="/js/jquery-3.3.1.js"></script>
    <script src="/layui/layui.js"></script>
</head>
<body>
<form class="layui-form" action="">
    <div class="layui-form-item">
        <label class="layui-form-label">出发地点</label>
        <div class="layui-input-inline">
            <input type="text" name="from_station" id="from_station" lay-verify="required" autocomplete="off" placeholder="请输入出发地" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">目的地</label>
        <div class="layui-input-inline">
            <input type="text" name="to_station" id="to_station" lay-verify="required" autocomplete="off" placeholder="请输入目的地" class="layui-input">
        </div>
    </div>
    <div class="layui-inline">
        <label class="layui-form-label">出发日期</label>
        <div class="layui-input-inline">
            <input type="text" name="date" id="date" lay-verify="date" placeholder="yyyy-MM-dd" autocomplete="off" class="layui-input">
        </div>
    </div>
    <button type="button" class="layui-btn layui-btn-normal" id="search_btn">查找</button>
    <script>
        layui.use('laydate', function(){
           var laydate = layui.laydate

           laydate.render({
               elem:'#date'
           });
        });
    </script>
</form>
<table id="station_search" lay-filter="test"></table>
<script>
    var v_from_station ;
    var v_to_station ;
    var v_date ;
    $("#search_btn").click(function () {
        v_from_station = $("#from_station").val();
        v_to_station = $("#to_station").val();
        v_date = $("#date").val();

        layui.use('table', function(){
            var table = layui.table;

            //第一个实例
            table.render({
                elem: '#station_search'
                ,height: 315
                ,url: '/getInfo'
                ,where:{
                    from_station:v_from_station,
                    to_station:v_to_station,
                    date:v_date
                }
                ,page: false//开启分页
                ,cols: [[ //表头
                    {field: 'train_no', title: '车次', width:400}
                    ,{field: 'from_station_name', title: '出发地', width:160, sort: true}
                    ,{field: 'to_station_name', title: '目的地', width:160}
                    ,{field: 'start_time', title: '出发时间', width: 177}
                    ,{field: 'arrive_time', title: '到站时间', width: 80, sort: true}
                    ,{field: 'first_class_seat', title: '一等座', width: 80, sort: true}
                    ,{field: 'second_class_seat', title: '二等座', width: 80}
                    ,{field: 'soft_sleep', title: '软卧', width: 80}
                    ,{field: 'hard_sleep', title: '硬卧', width: 80}
                    ,{field: 'hard_seat', title: '硬座', width: 80}
                    ,{field: 'no_seat', title: '无座', width: 80}

                ]]
            });

        });
    });





</script>
</body>
</html>