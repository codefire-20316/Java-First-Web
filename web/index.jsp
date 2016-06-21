<%-- 
    Document   : index
    Created on : Jun 21, 2016, 7:54:11 PM
    Author     : CodeFireUA <edu@codefire.com.ua>
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
       <h1>${message}</h1>
       <h2>Welcome ${not empty fullname ? fullname : 'guest'} to cabinet!</h2>
        
        <form method="post" action="${pageContext.servletContext.contextPath}/index">
            <div>
                Enter your name: 
                <input type="text" name="fullname" value="Vasya Pupkin" placeholder="Input your name..." />
                <button>POST</button>
            </div>
        </form>
    </body>
</html>
