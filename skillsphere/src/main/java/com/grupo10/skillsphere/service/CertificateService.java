package com.grupo10.skillsphere.service;

import com.grupo10.skillsphere.model.entity.Certificate;
import com.grupo10.skillsphere.repository.CertificateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CertificateService {

    @Autowired
    private CertificateRepository certificateRepository;

    // Obtener todos los certificados
    public List<Certificate> findAll() {
        return certificateRepository.findAll();
    }

    // Buscar un certificado por ID
    public Optional<Certificate> findById(Long id) {
        return certificateRepository.findById(id);
    }

    // Crear o guardar un certificado
    public Certificate save(Certificate certificate) {
        return certificateRepository.save(certificate);
    }

    // Actualizar un certificado existente
    public Certificate update(Long id, Certificate certificateDetails) {
        Certificate certificate = certificateRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Certificado no encontrado con id: " + id));

        certificate.setName(certificateDetails.getName());
        certificate.setDescription(certificateDetails.getDescription());
        certificate.setIssueDate(certificateDetails.getIssueDate());
        certificate.setExpiryDate(certificateDetails.getExpiryDate());
        certificate.setStudent(certificateDetails.getStudent());
        certificate.setInstitution(certificateDetails.getInstitution());

        return certificateRepository.save(certificate);
    }

    // Eliminar un certificado por ID
    public void deleteById(Long id) {
        certificateRepository.deleteById(id);
    }
}
