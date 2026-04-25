package com.grupo10.skillsphere.service;

import com.grupo10.skillsphere.model.entity.JobOffer;
import com.grupo10.skillsphere.repository.JobOfferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobOfferService {

    @Autowired
    private JobOfferRepository jobOfferRepository;

    // Obtener todas las ofertas laborales
    public List<JobOffer> findAll() {
        return jobOfferRepository.findAll();
    }

    // Buscar una oferta laboral por ID
    public Optional<JobOffer> findById(Long id) {
        return jobOfferRepository.findById(id);
    }

    // Crear o guardar una oferta laboral
    public JobOffer save(JobOffer jobOffer) {
        return jobOfferRepository.save(jobOffer);
    }

    // Actualizar una oferta laboral existente
    public JobOffer update(Long id, JobOffer jobOfferDetails) {
        JobOffer jobOffer = jobOfferRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Oferta laboral no encontrada con id: " + id));

        jobOffer.setTitle(jobOfferDetails.getTitle());
        jobOffer.setCompany(jobOfferDetails.getCompany());
        jobOffer.setDescription(jobOfferDetails.getDescription());
        jobOffer.setSalary(jobOfferDetails.getSalary());
        jobOffer.setSchedule(jobOfferDetails.getSchedule());
        jobOffer.setModality(jobOfferDetails.getModality());
        jobOffer.setActive(jobOfferDetails.getActive());

        return jobOfferRepository.save(jobOffer);
    }

    // Eliminar una oferta laboral por ID
    public void deleteById(Long id) {
        jobOfferRepository.deleteById(id);
    }
}
