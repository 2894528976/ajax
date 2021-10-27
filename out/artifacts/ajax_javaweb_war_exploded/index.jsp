<%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 2021/10/27
  Time: 13:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
$END$
<button onclick="qq()">请求</button>
<script>
    function qq() {
        // alert("aa")
        var req = new XMLHttpRequest();//创建
/**
 * 表单数据
 * json
 * */
          //get请求 参数设置 :
           //                req.open("get","http://localhost:8080/ajax_javaweb_war_exploded/hello?name="+'参数')

        // req.open("post","http://localhost:8080/ajax_javaweb_war_exploded/hello?name="+"addParam&name=delParam")
        req.open("post","http://localhost:8080/ajax_javaweb_war_exploded/hello")
/** json测试*/
        req.setRequestHeader("content-type","application/json;charset=utf-8")
        req.send("{user:'测试'}"); //发送

        /**表单数据测试  */
         // req.setRequestHeader("content-type","application/x-www-form-urlencoded;charset=utf-8")
         // req.send("user='测试'"); //发送
        req.onreadystatechange = function () {        //接收
            //status 状态码  readyState就绪状态
            if (req.status===200&&req.readyState===4)
                //req.responseText返回结果
            console.log(req.responseText)
        }

/*        req.open("post","http://localhost:8080/ajax_javaweb_war_exploded/hello")
        req.send();
        req.onreadystatechange = function (a) {
            console.log(req.status)
            console.log(req.readyState)
            console.log(req.responseText)
        }*/
    }
</script>
</body>
</html>
