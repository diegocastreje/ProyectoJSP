<section id="actions" class="py-4 mb-4 bg-light">
    <div class="container">
        <div class="row">
            <div class="col-md-3">
                <a href="index.jsp" class="btn text-white btn-block" style="background: #11698e"
                    <i class="fas fa-arrow-left"></i> Regresar al inicio
                </a> 
            </div>
            <div class="col-md-3">
                <button type="submit" class="btn btn-success btn-block">
                    <i class="fas fa-check"></i> Guardar
                </button>
            </div>
            <div class="col-md-3">
                <a href="${pageContext.request.contextPath}/ServletControlador?accion=eliminar&id_cancion=${cancion.id_cancion}&id_grupo=${grupo.id_grupo}&id_genero=${genero.id_genero}"
                   class="btn btn-danger btn-block">
                    <i class="fas fa-trash"></i>Eliminar
                </a>
            </div>
        </div>
    </div>
</section>