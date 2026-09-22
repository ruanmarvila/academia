package dev.ruancmm.academia.alunos;

public record AlunoFilterRequest(
    String nome,
    String email,
    String celular,
    String cidade,
    String estado
) {
}
