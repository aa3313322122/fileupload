<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>index</title>
<script type="text/javascript" src="./js/ajaxfileupload.js"></script>
<script type="text/javascript" src="./js/jquery-1.8.2.js"></script>
<style type="text/css">
	span{display:inline-block;*display:inline-block;}
	.bg{width:80px;height:10px;border-radius:10px;background:grey;}
	.main{height:10px;border-radius:5px;background:green;}
</style>
<script type="text/javascript">

    function add ()
    {
    	var fileName = "file" + Math.random();
        var input = document.createElement('input');
        input.setAttribute('type', 'file');
        input.setAttribute('name', "fileName");
        var br = document.createElement('br');
        document.getElementById('form').appendChild(br);
        document.getElementById('form').appendChild(input);

    }

</script>

</head>
<body>

<button onclick="add()">增加</button>
<form id="form" method="POST" enctype="multipart/form-data" action="upload.action">
 <input type="submit" value="Upload"><br/>
  <input type="file" name="file1"><br/>
  <span class="bg">
    <span class="main"></span>
</span>
<span class="num"></span>
</form>
</body>
</html>