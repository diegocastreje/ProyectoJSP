<div class="modal fade" id="agregarGeneroModal">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header text-white" style="background: #19456b">
                <h5 class="modal-title">Agregar género</h5>
                <button class="close" data-dismiss="modal">
                    <span>&times;</span>
                </button>
            </div>
            
            <form action="${pageContext.request.contextPath}/ServletControlador?accion=insertarGenero"
                  method="POST" class="was-validated">
                <div class="modal-body">
                    <div class="form-group">
                        <label for="nombre">Nombre</label>
                        <input type="text" class="form-control" name="nombre" required>
                    </div>              
                </div>
                <div class="modal-footer">
                    <button class="btn text-white" style="background: #11698e" type="submit">Guardar</button>
                </div>    
            </form>
        </div>
    </div>
</div>