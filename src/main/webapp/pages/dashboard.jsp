
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<link rel = "stylesheet" href="pages/main.css">
		<meta charset="UTF-8">
		<script type = "text/javascript">
			function write_below(form)
				{
			var input = document.forms.write.input_to_write.value;
			document.getElementById('write_here').innerHTML="Your input was:"+input;
			return false;
				}
		</script>
		<title>Cloud Waste Management DashBoard</title>
	</head>
	<body>
		<div class = "main">
		<h2>What attribute do you want to use for search</h2>
		<div class="select">
			<select name="slt-1" id="slt-1">
				<option>Choose An Option</option>
				<option value="1">resource ID</option>
				<option value="2">owner</option>
				<option value="3">application team</option>
				<option value="4">account name</option>
				           
			</select>
		</div>
		<div class = "input-form">
			<form name='write' onsubmit='return write_below(this);'>
			<label for ="option">input</label>
			<input type ="text" Id = "input_to_write" placeholder="Entered something..">
			<input type ="submit" value="Submit">
			
			</form>
		</div>
			<div id ='write_here'></div>
		</div>

	</body>
</html>