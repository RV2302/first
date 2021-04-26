<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix='s' uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>signup</title>
	<script src="https://code.jquery.com/jquery-3.6.0.js"></script>

</head>
<body>

	<s:property value="user"/>
	<s:textfield cssClass="username" label="username" key="name"></s:textfield> <br>
	<p id="nameerr" style="color:red; display:none">  username cannot be empty <p> 
	<s:password class="password" label="password" key="pass"></s:password><br>
	<p id="passerr" style="color:red; display:none">  password cannot be empty <p> <br>
	<s:textfield label="dummy" key="dummy"></s:textfield>
	<button id=button>login</button> <br>	
	
	<script type="text/javascript">
		$(function(){
			$('#button').on('click',function(e){
				var present = "username present";
				var emptypass = "password cannot be empty";
				$('#nameerr').css('display','none');
				$('#passerr').css('display','none');
				alert('clicked');
			
				$.ajax({
					type: 'GET',
					url: "signup",
					data: {'name': $('input')[0].value , 'pass': $('input')[1].value, 'dummy' : $('input')[2].value},
					success : function(itr){
						console.log(itr);
						console.log(itr['name_error']);
						if(itr['name_error'] == present)
						{
								console.log('name error is null');
								console.log(present+"yrfda");
								$('#nameerr').html(itr['name_error']);
								$('#nameerr').css('display','block');
							}
						if(itr['pass_error'] == emptypass)
						{
								$('#passerr').html(itr['pass_error']);
								$('#passerr').css('display','block');
						}else if(itr['name_error'] != present && itr['pass_error'] != emptypass)
								{
								 console.log("entered");
								 window.location.href = window.location.origin + '/noredirect/' +'/success.jsp'}
						}
					})
					
					
			})
			
			
		})
	</script>

</body>
</html>