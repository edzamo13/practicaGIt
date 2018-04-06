/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.empresa.dto;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author ezamora
 */
public class Usuario {

    @Getter
    @Setter
    private String usuario;

    @Getter
    @Setter
    private String Contrasenia;

    public Usuario() {
    }
    
    

    public Usuario(String usuario, String Contrasenia) {
        this.usuario = usuario;
        this.Contrasenia = Contrasenia;
    }
    
    

}
