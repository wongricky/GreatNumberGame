<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<link href="gameStyle.css" rel="stylesheet" type="text/css">
	<meta charset="UTF-8">
	<title>Too Low!</title>
</head>
<body>
<br/><br/>
	<h1>Welcome to the Great Number Game!</h1>
	<p>I am thinking of a number between 1 and 100</p>
	<p>Take a guess!</p>
	<div class="cont">
		<h1>TOO LOW!!!!!</h1>
	</div>
	<p>You've guessed <%= session.getAttribute("count") %> times </p>
	
	
	<form action="Game" method="POST">
		<input type="text" name="number"></input><br/>
		<input type="submit" value="SUBMIT"></input>
	</form>
	
</body>
</html>