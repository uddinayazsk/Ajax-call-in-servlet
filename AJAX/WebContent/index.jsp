<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
function ajaxFunction()
{
	//alert("am into ajax");
	var uid=document.getElementById("id1").value;
	//alert(uid)
	//alert("after id");
	/*
	* XMLHttpRequest(IE7 & above,CHrome,Mozilla,Opera,Safari) or 
	* ActiveXObject(IE5,6,Netscape Navigator )
	* XMLHttpRequest/ActiveXObject is used to send 
	* request to server and get response from server
		0 -> Request object is not initialized
		1 -> Request Object is Initialized
		2 -> Request is sent
		3 -> Request is processing
		4 -> Response is ready
	
	*/
	var xmlhttp;
		
		
		if(window.XMLHttpRequest)
			{//IE7 & above,Chrome,mozila,safari,opera
			
			xmlhttp=new XMLHttpRequest();
			//alert("xmlhttp created;");
			}
		else
			{//ie5,6,netscape navigator
			xmlhttp=new ActiveXObject("Microsoft.XMLHTTP")
			}
	
	xmlhttp.onreadystatechange=function()
	{
		//alert("STATE : " +xmlhttp.readyState);
		if(xmlhttp.readyState==4)
			{
			document.getElementById("id2").innerHTML=xmlhttp.responseText;
			alert(xmlhttp.responseText);
			
			}
	}
	
	xmlhttp.open("POST","<%=request.getContextPath()%>/AsyncServlet?userid="+uid,true);
	xmlhttp.send();
	
}

</script>
</head>
<body>
<h1>REGISTRATION FORM</h1>
<form action="">
FNAME : <input type="text" name="fname">
<br>
LNAME : <input type="text" name="lname">
<br>
USERID: <input type="text" name="userid" id="id1"
onblur="ajaxFunction()">
<br>
<div id="id2">==Response==</div>
PASSWORD: <input type="password" name="password">
<br>
<input type="submit">
</form>

</body>
</html>