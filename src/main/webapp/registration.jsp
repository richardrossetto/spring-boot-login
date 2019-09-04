<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Create an account</title>

    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/common.css" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Kaushan+Script" rel="stylesheet">
    <link href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet"
          integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
</head>

<body>

<div class="container">

    <div class="row">
        <div class="col-md-5 mx-auto">
            <div id="first">
                <div class="myform form ">
                    <div class="logo mb-3">
                        <div class="col-md-12 text-center">
                            <h1>Create your account</h1>
                        </div>
                    </div>

                    <form:form method="POST" modelAttribute="userForm" class="form-signin">
                        <spring:bind path="username">
                            <div class="form-group ${status.error ? 'has-error' : ''}">
                                <label>Username</label>
                                <form:input type="text" path="username" class="form-control" placeholder="Enter Username"
                                            autofocus="true" required="required"
                                            oninvalid="this.setCustomValidity('Username is required')"
                                            oninput="this.setCustomValidity('')"
                                ></form:input>
                                <form:errors path="username"></form:errors>
                            </div>
                        </spring:bind>

                        <spring:bind path="password">
                            <div class="form-group ${status.error ? 'has-error' : ''}">
                                <label>Password</label>
                                <form:input type="password" path="password" class="form-control" placeholder="Enter Password"
                                            autofocus="true" required="required"
                                            oninvalid="this.setCustomValidity('Minimum of 8 characters and contains at least 1 number, 1 uppercase, and 1 lowercase character.')"
                                            oninput="this.setCustomValidity('')"></form:input>
                                <form:errors path="password"></form:errors>
                            </div>
                        </spring:bind>

                        <spring:bind path="passwordConfirm">
                            <div class="form-group ${status.error ? 'has-error' : ''}">
                                <label>Confirm your Password</label>
                                <form:input type="password" path="passwordConfirm" class="form-control"
                                            placeholder="Confirm your password" autofocus="true" required="required"
                                            oninvalid="this.setCustomValidity('Minimum of 8 characters and contains at least 1 number, 1 uppercase, and 1 lowercase character.')"
                                            oninput="this.setCustomValidity('')"></form:input>
                                <form:errors path="passwordConfirm"></form:errors>
                            </div>
                        </spring:bind>
                        <div class="col-md-12 text-center ">
                            <button type="submit" class=" btn btn-block mybtn btn-primary tx-tfm">Create</button>
                        </div>
                    </form:form>

                </div>
            </div>
        </div>
    </div>
</div>

<script src="${contextPath}/resources/js/jquery.min.js"></script>
<script src="${contextPath}/resources/js/jquery.validate.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>
