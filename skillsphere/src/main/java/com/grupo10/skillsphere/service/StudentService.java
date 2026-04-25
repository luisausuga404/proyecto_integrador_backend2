package com.grupo10.skillsphere.service;

import com.grupo10.skillsphere.model.entity.Student;
import com.grupo10.skillsphere.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    // Obtener todos los estudiantes
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    // Buscar un estudiante por ID
    public Optional<Student> findById(Long id) {
        return studentRepository.findById(id);
    }

    // Crear o guardar un estudiante
    public Student save(Student student) {
        return studentRepository.save(student);
    }

    // Actualizar un estudiante existente
    public Student update(Long id, Student studentDetails) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Estudiante no encontrado con id: " + id));

        student.setFirstName(studentDetails.getFirstName());
        student.setLastName(studentDetails.getLastName());
        student.setEmail(studentDetails.getEmail());
        student.setPhone(studentDetails.getPhone());
        student.setBirthDate(studentDetails.getBirthDate());
        student.setProgram(studentDetails.getProgram());

        return studentRepository.save(student);
    }

    // Eliminar un estudiante por ID
    public void deleteById(Long id) {
        studentRepository.deleteById(id);
    }
}
