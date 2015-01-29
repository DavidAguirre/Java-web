<%-- 
    Document   : listarLibros
    Created on : 25-11-2014, 01:12:00 PM
    Author     : Clases
--%>

<%@page import="dto.Categoria"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dto.Libro"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%
            ArrayList<Libro> arrLib = (ArrayList<Libro>)request.getAttribute("libros");
            ArrayList<Categoria> arrCat = (ArrayList<Categoria>)request.getAttribute("categorias");
        %>
        <script>
            function TraerLibrosPorCategoria(){                
                var cbbCat = document.getElementById('cbbCat');
                var idCat = cbbCat.options[cbbCat.selectedIndex].value;                
                window.location.href = "TraerLibrosPorCategoria.do?idCat="+idCat+"";
            }
        </script>
    </head>
    <body>
        <h1>Listar Libros</h1>
        <form action="EliminarLibro.do" method="post">
            
            <select id="cbbCat">
                <option value="0" >Seleccione una categoría</option>
                
                <%
                    for(int i=0;i<arrCat.size();i++){                                            
                %>
                
                <option value="<%= arrCat.get(i).getId() %>">
                    <%= arrCat.get(i).getNombre() %>
                </option>
                
                <%}%>                
            </select>
            
            <a href="#" onclick="TraerLibrosPorCategoria();" >Buscar por Categoría</a>
            <br><br>    
        <table>
            <tr>
                <td>Seleccionar</td>
                <td>Nombre</td>
                <td>Categoría</td>
            </tr>            
            <%
                for(int i=0;i<arrLib.size();i++){
            %>
            <tr>
                <td><input type="checkbox" name="idLib" value="<%= arrLib.get(i).getId() %>" /></td>
                <td><%= arrLib.get(i).getNombre() %></td>
                <td><%= arrLib.get(i).getCat().getNombre() %></td>
            </tr>            
            <%}%>
        </table>
        <input type="submit" value="Eliminar" />
        </form>
    </body>
</html>
