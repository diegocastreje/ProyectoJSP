<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="es_ES"/>
<section id="generos">
    <div class="container">
        <div class="row">
            <div class="col-md-9">
                <div class="card">
                    <div class="card-header">
                        <ul class="nav nav-tabs card-header-tabs">
                            <li class="nav-item">
                              <a class="nav-link" style="color:black" href="${pageContext.request.contextPath}/ServletControlador?accion=goCanciones">Canciones</a>
                            </li>
                            <li class="nav-item">
                              <a class="nav-link" style="color:black" href="${pageContext.request.contextPath}/ServletControlador?accion=goGrupos">Grupos</a>
                            </li>
                            <li class="nav-item">
                              <a class="nav-link active" style="background: #dddddd" aria-current="true" href="${pageContext.request.contextPath}/ServletControlador?accion=goGeneros">Generos</a>
                            </li>
                        </ul>
                    </div>
                    <table class="table table-striped" style="background: #dddddd">
                        <thead class="thead-dark">
                            <tr>
                                <th>#</th>
                                <th>Nombre</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="genero" items="${generos}" varStatus="status">
                                <tr>
                                    <td>${genero.id_genero}</td>
                                    <td>${genero.nombre}</td>
                                    <td>
                                        <a href="${pageContext.request.contextPath}/ServletControlador?accion=editarGenero&id_genero=${genero.id_genero}"
                                           class="btn text-dark btn-outline-secondary">
                                            <i class="fas fa-angle-double-right"></i>Editar
                                        </a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
            <div class="col-md-3">               
                <div class="card text-center text-dark mb-3" style="background: #f8f1f1">
                    <div class="card-body">
                        <h3>Total Generos</h3>
                        <h4 class="display-4">
                            <i class="fas fa-drum"></i>${totalGeneros}
                        </h4>
                    </div>
                </div>         
            </div>
        </div>
    </div>
</section>
<jsp:include page="/WEB-INF/paginas/cancion/agregarCancion.jsp"/>
<jsp:include page="/WEB-INF/paginas/grupo/agregarGrupo.jsp"/>
<jsp:include page="/WEB-INF/paginas/genero/agregarGenero.jsp"/>  