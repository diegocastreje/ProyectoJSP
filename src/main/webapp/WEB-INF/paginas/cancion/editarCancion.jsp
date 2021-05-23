<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        
        <!-- Bootstrap CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
        <script src="https://kit.fontawesome.com/1c2acb75dc.js" crossorigin="anonymous"></script>   
        
        <title>Editar Cancion</title>     
    </head>
    <body>
        <jsp:include page="/WEB-INF/paginas/comunes/encabezado.jsp"/>
        <form action="${pageContext.request.contextPath}/ServletControlador?accion=modificarCancion&id_cancion=${cancion.id_cancion}"
              method="POST" class="was-validated">
            <section id="details">
                <div class="container">
                    <div class="row">
                        <div class="col">
                            <div class="card">
                                <div class="card-header">
                                    <h4>Editar</h4>
                                </div>
                                <div class="card-body">
                                    <div class="form-group">
                                        <label for="nombre">Nombre</label>
                                        <input type="text" class="form-control" name="nombre" required value="${cancion.nombre}">
                                    </div>
                                    <div class="form-group">
                                        <label for="anho">Año</label>
                                        <input type="number" class="form-control" name="anho" required value="${cancion.anho}">
                                    </div>
                                    <div class="form-group">
                                        <label for="link">Link</label>
                                        <input type="text" class="form-control" name="link" required value="${cancion.link}">
                                    </div>
                                    <div class="form-group">
                                        <label for="grupo">Grupo</label>
                                        <select class="form-select" size="3" aria-label="size 3 select example" name="grupo" required>
                                            <c:forEach items="${grupos}" var="grupo">
                                                <option value="${grupo.id_grupo}">${grupo.nombre}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                    <div class="form-group">
                                        <label for="genero">Genero</label>
                                        <select class="form-select" size="3" aria-label="size 3 select example" name="genero" required>
                                            <c:forEach items="${generos}" var="genero">
                                                <option value="${genero.id_genero}">${genero.nombre}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
            
            <jsp:include page="/WEB-INF/paginas/comunes/botonesNavegacionEditar.jsp"/>
        </form>        
        <jsp:include page="/WEB-INF/paginas/comunes/footer.jsp"/>
        <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
    </body>
</html> 