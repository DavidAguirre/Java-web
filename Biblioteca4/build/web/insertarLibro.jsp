<%-- 
    Document   : insertarLibro
    Created on : 18-11-2014, 01:58:17 PM
    Author     : Clases
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="dto.Categoria"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%
            ArrayList<Categoria> arrCat = (ArrayList<Categoria>)request.getAttribute("categorias");
        %>
    </head>
    <body>
        <h1>Insertar Libro</h1>
        <form action="InsertarLibro.do" method="post">
        <table>
            <tr>
                <td>
                    Nombre
                </td>
                <td>
                    <input type="text" name="nombre" />
                </td>
            </tr>
            <tr>
                <td>
                    Año
                </td>
                <td>
                    <input type="text" name="anio" />
                </td>
            </tr>
            <tr>
                <td>
                    Categoría
                </td>
                <td>
                    <select name="cat">
                        <option value="0">Seleccionar Categoría</option>
                        <%
                            for(int i=0;i<arrCat.size();i++){
                        %>
                        <option value="<%= arrCat.get(i).getId()%>">
                            <%= arrCat.get(i).getNombre() %>
                        </option>
                        <%}%>
                    </select>
                </td>
            </tr>
            <tr>
                <td>
                    <input type="submit" value="Ingresar" />
                </td>
            </tr>
        </table>
        </form>
    </body>
</html>
