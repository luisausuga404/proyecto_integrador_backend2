package com.grupo10.skillsphere.controller;

import com.grupo10.skillsphere.model.entity.JobOffer;
import com.grupo10.skillsphere.service.JobOfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/job-offers")
public class JobOfferController {

    @Autowired
    private JobOfferService jobOfferService;

    // GET /api/job-offers → Listar todas las ofertas laborales
    @GetMapping
    public List<JobOffer> getAllJobOffers() {
        return jobOfferService.findAll();
    }

    // GET /api/job-offers/{id} → Buscar oferta laboral por ID
    @GetMapping("/{id}")
    public ResponseEntity<JobOffer> getJobOfferById(@PathVariable Long id) {
        return jobOfferService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // POST /api/job-offers → Crear una nueva oferta laboral
    @PostMapping
    public JobOffer createJobOffer(@RequestBody JobOffer jobOffer) {
        return jobOfferService.save(jobOffer);
    }

    // PUT /api/job-offers/{id} → Actualizar una oferta laboral
    @PutMapping("/{id}")
    public ResponseEntity<JobOffer> updateJobOffer(@PathVariable Long id, @RequestBody JobOffer jobOfferDetails) {
        try {
            JobOffer updatedJobOffer = jobOfferService.update(id, jobOfferDetails);
            return ResponseEntity.ok(updatedJobOffer);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // DELETE /api/job-offers/{id} → Eliminar una oferta laboral
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteJobOffer(@PathVariable Long id) {
        jobOfferService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
