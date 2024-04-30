package com.example.hackaton.services;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hackaton.DTO.UsuarioDTO;
import com.example.hackaton.modelo.Usuario;
import com.example.hackaton.modelo.Vuelo;
import com.example.hackaton.repositories.UsuarioRepository;
import com.example.hackaton.repositories.VueloRepository;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private VueloRepository vueloRepository;

    @Autowired
    ModelMapper modelMapper;

    public Usuario insertar(UsuarioDTO usuario){

        Usuario nuevoUsuario = new Usuario();

        nuevoUsuario.setNombre(usuario.getNombre());
        nuevoUsuario.setApellido(usuario.getApellido());
        nuevoUsuario.setCiudad(usuario.getCiudad());
        nuevoUsuario.setCelular(usuario.getCelular());
        nuevoUsuario.setContrasena(usuario.getContrasena());
        nuevoUsuario.setCorreo(usuario.getCorreo());

        return usuarioRepository.save(nuevoUsuario);
    }

    public boolean verificarUsuario(String correo, String password) {
        
        Usuario usuario = usuarioRepository.findByCorreoAndContrasena(correo, password);
        return usuario != null;

    }

    public Usuario conseguirUsuario(String correo, String password){
        Usuario usuario = usuarioRepository.findByCorreoAndContrasena(correo, password);
        return usuario;

    }

    public List<Vuelo> listarVuelosUsuario(Long numeroId){

        List<Vuelo> vuelosDelUsuario = vueloRepository.findByUsuarioId(numeroId);
        return vuelosDelUsuario;
    }
    
}
