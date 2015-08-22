<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<?xml version="1.0" encoding="ISO-8859-1" ?>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
  <title>Find user</title>
</head>
<body>
<h1>Find user</h1>
<p>Here you can find the user.</p>

<form:form method="POST" commandName="findObj" action="${pageContext.request.contextPath}/user/find.html">
  <table>
    <tbody>
    <tr>
      <td>Search by:</td>
      <td><form:select path="field">
        <form:option selected="selected" value="id">Id</form:option>
        <form:option value="name">Name</form:option>
        <form:option value="age">Age</form:option>
        <form:option value="createdDate">CreatedDate</form:option>
      </form:select></td>
    </tr>
    <tr>
      <td>From:</td>
      <td><form:input path="from" /></td>
    </tr>
    <tr>
      <td>To:</td>
      <td><form:input path="to" /></td>
    </tr>
    <tr>
      <td>Sort by:</td>
      <td><form:select path="sort">
        <form:option selected="selected" value="id">Id</form:option>
        <form:option value="name">Name</form:option>
        <form:option value="age">Age</form:option>
        <form:option value="isAdmin">IsAdmin</form:option>
        <form:option value="createdDate">CreatedDate</form:option>
      </form:select></td>
    </tr>
    <tr>
      <td><input type="submit" value="Find" /></td>
      <td></td>
    </tr>
    </tbody>
  </table>
</form:form>

<table border="1px" cellpadding="0" cellspacing="0" >
  <thead>
  <tr>
    <th width="10%">id</th><th width="15%">name</th><th width="10%">age</th><th width="5%">isAdmin</th><th width="10%">createdDate</th><th width="10%">actions</th>
  </tr>
  </thead>
  <tbody>
  <c:forEach var="user" items="${users}">
    <tr>
      <td>${user.id}</td>
      <td>${user.name}</td>
      <td>${user.age}</td>
      <td>${user.isAdmin}</td>
      <td>${user.createdDate}</td>
      <td>
        <a href="${pageContext.request.contextPath}/user/edit/${user.id}.html">Edit</a><br/>
        <a href="${pageContext.request.contextPath}/user/delete/${user.id}.html">Delete</a><br/>
      </td>
    </tr>
  </c:forEach>
  </tbody>
</table>

<p><a href="${pageContext.request.contextPath}/index.html">Home page</a></p>

</body>
</html>