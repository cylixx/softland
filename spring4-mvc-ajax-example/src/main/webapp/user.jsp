<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<c:url var="home" value="/" scope="request" />
<meta charset="UTF-8">
<link href="<c:url value="/resources/core/css/bootstrap.min.css" />" rel="stylesheet">
<script src="<c:url value="/resources/core/js/jquery-3.3.1.min.js" />"></script>
</head>
<body>

<nav class="navbar navbar-inverse">
	<div class="container">
		<div class="navbar-header">
			<a class="navbar-brand" href="#">Spring 4 MVC Ajax Example</a>
		</div>
	</div>
</nav>

	<form  class="form-horizontal" id="registro" action="#">
		<br> Name: <input type="text" name="name" id="name">
		<br> Age: <input type="text" name="age" id="age"> 
		<br> <input type="submit" value="registrar">
	</form>
	
	<br><br>
	<table id="userTable" border="1">
    <tbody>
        <tr><td>Id</td><td>Nombre</td><td>Edad</td></tr>
    </tbody>
	</table>
	
	
	
<script type="text/javascript">

	listAllUsers();
	
	$('#registro').submit(function(evento) {
		// Prevent the form from submitting via the browser.
	    evento.preventDefault();
	    createUser();
	});
	
	
	function createUser() {
		var user = {
				name: $('#name').val(), 
		  		age: $('#age').val()	
			};
			
		    $.ajax({
		        url: '${home}user/',
		        type: 'POST',
		        data: JSON.stringify(user),
		        processData: false,
		        contentType: "application/json",
		        success: function(data, status, xhr) {	
					console.log("SUCCESS: ", data);
					console.log("LOCATION: ", xhr.getResponseHeader('Location'));
					getUser( xhr.getResponseHeader('Location') );
				},
				statusCode: {
				    409: function() {
				        alert("El nombre de usuario ya existe!");
				    }
				},
				error: function(e) {	
					console.log("ERROR: ", e);
				},
				done : function(e) {
					console.log("DONE");
	
				}
		    })
	}

	function listAllUsers() {
	  
	  $.getJSON( "${home}user/", 
		function( data ) {
		  var items = [];
		  $.each( data, function( key, val ) {
			  $("#userTable > tbody").append(
						"<tr><td>" + val.id + "</td><td>" + val.name + "</td><td>" + val.age + "</td></tr>");
		  });

		});
	}


	function getUser(url) {
		$.getJSON(url, function(data) {

			$("#userTable > tbody").append(
					"<tr><td>" + data.id + "</td><td>" + data.name + "</td><td>" + data.age + "</td></tr>");

		});
	}
	
</script>

</body>
</html>