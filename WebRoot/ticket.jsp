<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>

	<head>
		<base href="<%=basePath%>">

		<title>票号</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
			<link rel="stylesheet" type="text/css" href="styles.css">
			-->
		<script type="text/javascript" src="jquery/jquery-2.0.3.js"></script>
		<script type="text/javascript" src="jquery/jquery.form.js"></script>
	</head>
	
	<style type="text/css">
		* {
    		list-style: outside none none;
   	 		margin: 0;
    		padding: 0;
    		text-decoration: none;
    		font: 12px/24px Helvetica,Tahoma,Arial,sans-serif;
		}
		a.files input {
    		cursor: pointer;
    		font-size: 30px;
    		height: 100%;
    		margin-left: -350px;
    		opacity: 0;
    		outline: medium none;
		}
		a.files {
		    background-image: url("images/blue_upload_file.png");
		    outline: medium none;
		}
		a.btn {
		    display: block;
		    height: 40px;
		    overflow: hidden;
		    text-decoration: none;
		    width: 132px;
		}
		a.sub {
			height: 30px;
			width: 180px;
			background-image: url("images/btn_submit.png");
		    outline: medium none;
		    display: block;
		    overflow: hidden;
		    text-decoration: none;
		}
		a {
		    color: #07519a;
		    cursor: pointer;
		}
		.bor_box{
			height:300px;
			width:400px;
		    border: 4px solid #ddd;
		    margin: 100px auto auto 400px;
		    padding: 20px;
		}
	</style>
	
	<script type="text/javascript">
		function show_uploadfile()
		{
			var filename = $('#txt_userfile').val();
			
			if ( filename )
			{
				filename = filename.replace(/C:\\fakepath\\/, '');
				$('#li_userfile').html('( '+filename+' )');
			}
		}
		function sendForm() 
		{
            $('#fileinfo').ajaxSubmit(
            {  
            	type: 'post',  
                url: "core/ticketAction.action" ,  
                success: function(data)
                {  
                	var successJson = jQuery.parseJSON(data);
                	if(successJson.success)
                	{
                		alert(successJson.uploadFileMessage);
                		$('#fileinfo').resetForm();
                		$('#li_userfile').html('(未选择文件)');  
                	}
                	else
                	{
                		alert(successJson.errorMsg);
                	}
                }
            });  
		}
	</script>
	
	<body>
	
		
			 
		<form enctype="multipart/form-data" id="fileinfo">
			<div class="bor_box">
				<span>选择Excel文件：</span>
				<br/>
				<br/>
				<dl class="note_upload">
					<dt>
						<a class="btn files" href="javascript:void(0);"> 
							<input type="file" name="file" onchange="show_uploadfile();" id="txt_userfile">
						</a>
					</dt>
					<dd>
						<ul>
							<li id="li_userfile">（未选择文件）</li>
							<li>（自动覆盖服务器同名文件）</li>
							<li>（您可以上传小于60兆的文件）</li>
						</ul>
					</dd>
				</dl>
				<br/>
				<a id="btn_submit" class="sub" href="javascript:sendForm();"></a>
			</div>
		</form> 
	</body>
	
</html>











