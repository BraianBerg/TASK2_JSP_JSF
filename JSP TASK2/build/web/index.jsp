<%-- 
    Document   : index
    Created on : Feb 22, 2022, 10:47:17 PM
    Author     : braia
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>System info</title>
    </head>
    <body>
        <jsp:useBean id="host" scope="session" class="beans.HostBean"/>
        <jsp:setProperty name="host" property="*"/>
        <h1>System</h1>
        <table>
            <tr>
                <td colspan="2"><b>Host info</b></td>
                <td colspan="2"><b>Client info</b></td>
                <td colspan="2"><b>Session info</b></td>
            </tr>
            <tr>
                <td>Host IP</td>
                <td>${host.getIP()}</td>
                <td>Client IP</td>
                <td>${ClientIP}</td>
                <td>Session ID</td>
                <td>${SessionID}</td>
            </tr>
            <tr>
                <td>Host name</td>
                <td>${host.getName()}</td>
                <td>Client name</td>
                <td>${ClientName}</td>
                <td>Session created</td>
                <td>${SessionCreated}</td>
            </tr>
            <tr>
                <td>Port</td>
                <td>${LocalPort}</td>
                <td>Port</td>
                <td>${ClientPort}</td>
                <td>Protocol</td>
                <td>${Protocol} - ${Type}</td>
            </tr>
        </table>
    </body>
</html>
