package com.example.demo.service;

import com.example.demo.dto.CamionDTO;
import com.example.demo.modelo.Camion;
import com.example.demo.modelo.EstadoCamion;
import com.example.demo.modelo.Usuario;
import com.example.demo.repository.CamionRepository;
import com.example.demo.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CamionService {

    @Autowired
    private CamionRepository camionRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Camion crearCamion(CamionDTO dto, String emailConductor) {
        // Buscamos al conductor
        Usuario conductor = usuarioRepository.findByEmail(emailConductor)
                .orElseThrow(() -> new RuntimeException("Conductor no encontrado"));

        // Creamos el camión
        Camion camion = new Camion();
        camion.setMatricula(dto.getMatricula());
        camion.setModelo(dto.getModelo());
        camion.setCapacidadKg(dto.getCapacidadKg());
        camion.setEstado(EstadoCamion.ACTIVO);
        camion.setConductor(conductor);

        return camionRepository.save(camion);
    }

    public List<Camion> obtenerMisCamiones(String emailConductor) {
        Usuario conductor = usuarioRepository.findByEmail(emailConductor)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        return camionRepository.findByConductor(conductor);
    }

    // Necesario para el admin o para listar todos sin filtro
    public List<Camion> listarTodos() {
        return camionRepository.findAll();
    }

    // Necesario para ver el detalle de UN solo camión
    public Camion obtenerPorId(String id) {
        return camionRepository.findById(id).orElse(null);
    }

    // Necesario para borrar un camión
    public void borrar(String id) {
        camionRepository.deleteById(id);
    }

    // Necesario para actualizar (PUT)
    public Camion guardar(Camion camion) {
        return camionRepository.save(camion);
    }
}

