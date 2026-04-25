package com.grupo10.skillsphere.service;

import com.grupo10.skillsphere.model.entity.Institution;
import com.grupo10.skillsphere.repository.InstitutionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InstitutionService {

    @Autowired
    private InstitutionRepository institutionRepository;

    // Obtener todas las instituciones
    public List<Institution> findAll() {
        return institutionRepository.findAll();
    }

    // Buscar una institución por ID
    public Optional<Institution> findById(Long id) {
        return institutionRepository.findById(id);
    }

    // Crear o guardar una institución
    public Institution save(Institution institution) {
        return institutionRepository.save(institution);
    }

    // Actualizar una institución existente
    public Institution update(Long id, Institution institutionDetails) {
        Institution institution = institutionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Institución no encontrada con id: " + id));

        institution.setName(institutionDetails.getName());
        institution.setCountry(institutionDetails.getCountry());
        institution.setWebsite(institutionDetails.getWebsite());
        institution.setType(institutionDetails.getType());

        return institutionRepository.save(institution);
    }

    // Eliminar una institución por ID
    public void deleteById(Long id) {
        institutionRepository.deleteById(id);
    }
}
