<div class="modal fade" id="agregarGrupoModal">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header text-white" style="background: #19456b">
                <h5 class="modal-title">Agregar grupo</h5>
                <button class="close" data-dismiss="modal">
                    <span>&times;</span>
                </button>
            </div>
            
            <form action="${pageContext.request.contextPath}/ServletControlador?accion=insertarGrupo"
                  method="POST" class="was-validated">
                <div class="modal-body">
                    <div class="form-group">
                        <label for="nombre">Nombre</label>
                        <input type="text" class="form-control" name="nombre" required>
                    </div>
                    <div class="form-group">
                        <label for="miembros">Miembros</label>
                        <input type="number" class="form-control" name="miembros">
                    </div>               
                </div>
                <div class="modal-footer">
                    <button class="btn text-white" style="background: #11698e" type="submit">Guardar</button>
                </div>    
            </form>
        </div>
    </div>
</div>