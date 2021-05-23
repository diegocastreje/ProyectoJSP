<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="modal fade" id="agregarCancionModal">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header text-white" style="background: #19456b">
                <h5 class="modal-title">Agregar cancion</h5>
                <button class="close" data-dismiss="modal">
                    <span>&times;</span>
                </button>
            </div>
            
            <form action="${pageContext.request.contextPath}/ServletControlador?accion=insertarCancion"
                  method="POST" class="was-validated">
                <div class="modal-body">
                    <div class="form-group">
                        <label for="nombre">Nombre</label>
                        <input type="text" class="form-control" name="nombre" required>
                    </div>
                    <div class="form-group">
                        <label for="anho">Año</label>
                        <input type="number" class="form-control" name="anho">
                    </div>
                    <div class="form-group">
                        <label for="link">Link</label>
                        <input type="text" class="form-control" name="link">
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
                <div class="modal-footer">
                    <button class="btn text-white" style="background: #11698e" type="submit">Guardar</button>
                </div>    
            </form>
        </div>
    </div>
</div>