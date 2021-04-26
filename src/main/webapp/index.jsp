<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix='s' uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>RVAJAX</title>
	<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
	
</head>
<body>

	<s:property value="user"/>
	<s:textfield cssClass="username" label="username" key="name"></s:textfield> <br>
	<p id="nameerr" style="color:red; display:none">  username cannot be empty <p> 
	<s:password class="password" label="password" key="pass"></s:password><br>
	<p id="passerr" style="color:red; display:none">  password cannot be empty <p> <br>
	<button id=button>login</button> <br>	
	

	<a href='signup.jsp'><button id="signup">signup</button></a>
	
	<script type="text/javascript">
		$(function(){
			let present = "username present";
			$('#button').on('click',function(e){
				$('#nameerr').css('display','none');
				$('#passerr').css('display','none');
				alert('clicked');
			
				$.ajax({
					type: 'GET',
					url: "login",
					data: {'name': $('input')[0].value , 'pass': $('input')[1].value},
					success : function(itr){
						console.log(itr);
						console.log(itr['name_error']+ ' before if');
						if(itr['name_error'] != present)
						{
								console.log('name error is null');
								$('#nameerr').html(itr['name_error']);
								$('#nameerr').css('display','block');
							}
						if(itr['pass_error'] != null)
						{
								$('#passerr').html(itr['pass_error']);
								$('#passerr').css('display','block');
							}
						
						console.log(present == itr['name_error'] );

						if(itr['name_error'] == present && itr['pass_error'] ==null)
							window.location.href = window.location.origin + '/noredirect' + '/success.jsp';
					}
					})
					
					
			})
			
			
		})
	</script>
	
</body>
</html>