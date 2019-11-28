document.write("<script type='text/javascript' src='js/ajax.js'></script>");
$("#select").click(function () {
    var param = $("#sql").val();
    myAjax('post', 2, "param=" + param, function (res) {
        var result = JSON.parse(res);
        var title="<tr>";
        for (var o in result[0]) {
             title+="<th><input type='text' value='"+o+"'><input type='hidden' value='"+o+"'></th>";
         }
        title+="</tr>";
        $("#title").html("");
        $("#body").html("");
        $("#title").append(title);

         stack(result);
    }, 'text');
});


function stack(obj) {
    if (!isJson(obj) && !isArrayFn(obj)) {//退出条件：当对象不是json的时候推出
        return obj;
    }
    //如果是json进行循环，取出键值对。逐渐减小问题的规模
    var table = "<tr>"
    for (var o in obj) {
        if (stack(obj[o])) {//进行判断，进入子问题
            if (isArrayFn(obj[o])) {//判断是不是数组
                var arr = obj[o];
                for (var i = 0; i < arr.length; i++) {
                    stack(arr[i]);//如果是数组，再判断数组里的数据是不是json。
                }
            } else {
                console.log(o + ":" + obj[o]);
                table += "<td>" + obj[o] + "</td>";
            }
        }
    }
    table += "</tr>";
     $("#body").append(table);
}

//判断obj是否为json对象
function isJson(obj) {
    var isjson = typeof (obj) == "object" && Object.prototype.toString.call(obj).toLowerCase() == "[object object]" && !obj.length;
    return isjson;
}

//判断是不是数组
function isArrayFn(o) {
    return Object.prototype.toString.call(o) == '[object Array]';
}

//保存数据集
$("#save").click(function () {
     var numArr =new Array();
    $('input').each(function(){
        numArr.push($(this).val());//添加至数组
    });
 alert(numArr);
    var report = {
        rName:$("#rName").val(),
        rSql : $("#sql").val(),
        rClunm: numArr
    };
    alert(JSON.stringify(report))
     myAjax('post', 3, "param=" + JSON.stringify(report), function (res) {
  alert(res);
    }, 'text');
});