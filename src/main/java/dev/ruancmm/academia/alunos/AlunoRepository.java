package dev.ruancmm.academia.alunos;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
    boolean existsByEmail(String email);
}
