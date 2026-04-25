package com.grupo10.skillsphere.controller;

import com.grupo10.skillsphere.model.entity.Certificate;
import com.grupo10.skillsphere.service.CertificateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/certificates")
public class CertificateController {

    @Autowired
    private CertificateService certificateService;

    // GET /api/certificates → Listar todos los certificados
    @GetMapping
    public List<Certificate> getAllCertificates() {
        return certificateService.findAll();
    }

    // GET /api/certificates/{id} → Buscar certificado por ID
    @GetMapping("/{id}")
    public ResponseEntity<Certificate> getCertificateById(@PathVariable Long id) {
        return certificateService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // POST /api/certificates → Crear un nuevo certificado
    @PostMapping
    public Certificate createCertificate(@RequestBody Certificate certificate) {
        return certificateService.save(certificate);
    }

    // PUT /api/certificates/{id} → Actualizar un certificado
    @PutMapping("/{id}")
    public ResponseEntity<Certificate> updateCertificate(@PathVariable Long id, @RequestBody Certificate certificateDetails) {
        try {
            Certificate updatedCertificate = certificateService.update(id, certificateDetails);
            return ResponseEntity.ok(updatedCertificate);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // DELETE /api/certificates/{id} → Eliminar un certificado
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCertificate(@PathVariable Long id) {
        certificateService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
