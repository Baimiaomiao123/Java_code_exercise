function jQuery(selector){

    if (typeof selector == "string") {
        if (selector.charAt(0) == "#") {
            domObj = document.getElementById(selector.substring(1));
            return new jQuery();
        }
    }

    if (typeof selector == "function") {
        window.onload = selector;
    }

    this.html = function (html){
        domObj.innerHTML = html;
    }

    this.click = function (fun) {
        domObj.onclick = fun;
    }

    this.val = function (text){
        if (text==undefined){
            return domObj.value;
        }else{
            domObj.value = text;
        }
    }
    
    this.change = function (fun){
        domObj.onchange = fun;
    }

    /**
     * 分析：使用ajax函数发送请求的时候，需要程序员给我们传过来什么？
     *  请求的方式method：GET/POST
     *  请求的URLurl：url
     *  请求时提交的数据data：data
     *  异步或同步async：true/false
     * @param method
     * @param url
     * @param async
     */
    //定义一个静态方法，发送ajax请求
    jQuery.ajax = function (jsonArgs) {
        var xhr = new XMLHttpRequest();
        xhr.onreadystatechange = function () {
            if (this.readyState == 4) {
                if (this.status == 200) {
                    //这个工具类在封装的时候不考虑这么多，假设返回的都是JSON字符串
                    var jsonObj = JSON.parse(this.responseText);
                    //返回的json格式的数据：{"uname":"zhangsan"}
                    // document.getElementById("mydiv").innerHTML = jsonObj.uname;
                    jsonArgs.success(jsonObj);
                }
            }
        }
        if (jsonArgs.method.toUpperCase() == "POST") {
            xhr.open("POST",jsonArgs.url,jsonArgs.async);
            xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
            xhr.send(jsonArgs.data);
        }

        if (jsonArgs.method.toUpperCase() == "GET") {
            xhr.open("GET",jsonArgs.url + "?" + jsonArgs.data,jsonArgs.async);
            xhr.send();
        }

    }

}

$ = jQuery;

//这里有个细节，执行这个是为了让静态方法ajax生效
new jQuery();