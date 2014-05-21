<%-- 
    Document   : carrito
    Created on : 21/05/2014, 11:00:40 AM
    Author     : admin
--%>
<%  import co.edu.uniandes.csw.item.logic.dto.ItemDTO;
    import co.edu.uniandes.csw.producto.logic.dto.ProductoDTO;

%>

<%@page contentType="text/html" pageEncoding="windows-1252"%>
<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>JSP Page</title>
    </head>
    <body>
        <% 
            for(ItemDTO item: SP.i().items)
            {
         %> 
               <%= SP.i().getProducto(item.getID()).getName() %>
        <%
            }
        %>
        
    </body>
</html>
