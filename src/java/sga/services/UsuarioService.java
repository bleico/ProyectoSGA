package sga.services;

import sga.eis.dto.Usuario;
/**
 *
 * @author bleid
 */
public interface UsuarioService {
    
    public boolean usuarioExistente(Usuario usuario);
}
