<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<link href="gameStyle.css" rel="stylesheet" type="text/css">
	<meta charset="UTF-8">
	<title>You've Won!</title>
</head>
<body>
<br/><br/>
	<h1>Welcome to the Great Number Game!</h1>
	<p>I am thinking of a number between 1 and 100</p>
	<p>Take a guess!</p>
	<div class="cont1">
		<h1><%= session.getAttribute("mainNumber") %> was the number!</h1>
		<br/>
		<p>You guessed a total of <%= session.getAttribute("count") %> times </p>
		<br/>
		<form action="Game" method="GET">
			<input type="submit" value="START OVER"><% session.invalidate(); %></input>
		</form>
	</div>
	
	
</body>
</html>