<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>index</title>
<script type="text/javascript" src="./js/jquery-1.8.2.js"></script>
<script type="text/javascript">

	var i = 1;
	var percent = 0;
	function ajaxFileUpload()
	{
		var file = document.getElementById("file1").files[0];
		var data = new FormData();
	    data.append('file1', file);
	    if(percent < 100)
    	{
	    	self.setInterval("getP()",1000);
    	}
	    
		$.ajax({url:"upload.action",
			processData: false,
			contentType: false,
			cache: false,
			async:true,
			type:"POST",
			data:data
		});
	}
	
	function getP()
	  {
		$.ajax({
			url:"progress.action",
			type:"GET",
			cache: false,
			async:true,
			dataType: "text",
			success:function (data)
			{
				document.getElementById("pro").value = data;
				percent = data;
			}
		})
	  }
	
		  //获取进度信息
	

    function add ()
    {
    	var fileName = "file" + Math.random();
        var input = document.createElement('input');
        input.setAttribute('type', 'file');
        var id = 'file' + i++;
        input.setAttribute('id', id);
        input.setAttribute('name', "fileName");
        input.setAttribute('onchange', "ajaxFileUpload()");
        var br = document.createElement('br');
        var progress = document.createElement('progress');
        progress.setAttribute('value', 0);
        progress.setAttribute('max', 100);
        document.getElementById('form').appendChild(br);
        document.getElementById('form').appendChild(input);
        document.getElementById('form').appendChild(progress);

    }
</script>

</head>
<body>
index2
<button onclick="add()">增加</button>
<form id="form" method="POST" enctype="multipart/form-data" >
 <input type="button"  value="Upload"><br/><br/>
  <input type="file" multiple="multiple" onchange="ajaxFileUpload()" id="file1" name="file1">&nbsp;
  <progress id="pro" value="0" max="100" > </progress> 
</form>
</body>
</html>