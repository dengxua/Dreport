document.write("<script type='text/javascript' src='js/properties.js'></script>");

/*
*ajax函数
*有5个参数，最后一个参数可选
*
* @param method(必选)    请求类型  get 和 post
* @param url(必选)       请求的url地址   相同域名下的页面（此函数不支持跨域请求）
* @param data(必选)      请求协带的数据  以js对象的形式定义，如：{name:'张三'}
* @param callback(必选)  回调函数,可接收一个参数，这个参数就是服务器响应的数据
* @param type(可选)      指定服务器响应的数据类型（可选值：json,xml,text），如果是json模式，则使用json解析数据，默认为text普通字符串
*/
function myAjax(method, url, data, callback, type) {
       $.ajax({
        type: method,
        url: getUrl(url),
        data:data,
        success: function(data) {
            callback(data);
         }
    });
 }
