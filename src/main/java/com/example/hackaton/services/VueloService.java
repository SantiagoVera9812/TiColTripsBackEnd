package com.example.hackaton.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hackaton.DTO.VueloDTO;
import com.example.hackaton.modelo.Parada;
import com.example.hackaton.modelo.Precio;
import com.example.hackaton.modelo.Usuario;
import com.example.hackaton.modelo.Vuelo;
import com.example.hackaton.repositories.UsuarioRepository;
import com.example.hackaton.repositories.VueloRepository;

@Service
public class VueloService {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private VueloRepository vueloRepository;

    @Autowired
    ModelMapper modelMapper;

    public Vuelo insertar(VueloDTO vueloDTO){

        Vuelo nuevoVuelo = new Vuelo();
        System.out.println(vueloDTO.getLastTicketingDate());
        nuevoVuelo.setLastTicketingDate(vueloDTO.getLastTicketingDate());
        System.out.println(vueloDTO.getLastTicketingDate());
        nuevoVuelo.setNumberOfBookableSeats(vueloDTO.getNumberOfBookableSeats());
        System.out.println(vueloDTO.getNumberOfBookableSeats());
        nuevoVuelo.setValidatingAirLineCodes(vueloDTO.getValidatingAirLineCodes());
        System.out.println(vueloDTO.getValidatingAirLineCodes());
        nuevoVuelo.setNumeroDeParadas(vueloDTO.getNumeroDeParadas());
        System.out.println(vueloDTO.getNumeroDeParadas());

        Precio precio = new Precio();
        precio.setPrecio(vueloDTO.getPrecio().getPrecio());
        precio.setCurrency(vueloDTO.getPrecio().getCurrency());
        nuevoVuelo.setPrecio(precio);

        
        if(vueloDTO.getParadas() != null){
            List<Parada> paradas = vueloDTO.getParadas().stream()
            .map(paradaDTO -> modelMapper.map(paradaDTO, Parada.class))
            .collect(Collectors.toList());

            System.out.println("Contents of 'paradas': " + paradas);


            nuevoVuelo.setParadas(paradas);

            
        }else{
            System.out.println("paradas empty");
        }

        if(vueloDTO.getUsuarios() != null){
           List<Usuario> usuarios = vueloDTO.getUsuarios().stream()
           .map(usuarioDTO -> modelMapper.map(usuarioDTO, Usuario.class))
           .collect(Collectors.toList());

           
           for (Usuario usuario : usuarios) {
            Usuario usuarioEncontrado = usuarioService.conseguirUsuario(usuario.getCorreo(), usuario.getContrasena());

            if (usuarioEncontrado != null) {
                usuarioEncontrado.getVuelos().add(nuevoVuelo);
                usuarioRepository.save(usuarioEncontrado);
            }

        }

           System.out.println("Contents of 'usuarios': " + usuarios.get(0).getNombre());

           nuevoVuelo.setUsuarios(usuarios);

        }else{
            System.out.println("usuarios empty");
        }

        return vueloRepository.save(nuevoVuelo);
    }
    
}
