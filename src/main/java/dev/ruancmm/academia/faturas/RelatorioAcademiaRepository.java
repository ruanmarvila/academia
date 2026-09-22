package dev.ruancmm.academia.faturas;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import dev.ruancmm.academia.alunos.AlunosPorCidadeProjection;

public interface RelatorioAcademiaRepository extends Repository<FaturaMatricula, Long> {

    @Query(
        value = """
            SELECT TO_CHAR(data_vencimento, 'YYYY-MM') AS mes, SUM(valor) AS total
            FROM faturas_matriculas
            WHERE status = 'PAGA'
            GROUP BY TO_CHAR(data_vencimento, 'YYYY-MM')
            ORDER BY mes
        """,
        nativeQuery = true
    )
    List<FaturamentoMensalProjection> faturamentoMensal();

    @Query(
        value = """
            SELECT cidade, COUNT(*) AS quantidade
            FROM alunos
            GROUP BY cidade
            ORDER BY quantidade DESC
        """,
        nativeQuery = true
    )
    List<AlunosPorCidadeProjection> alunoaPorCidade();

    @Query(
        value = """
            SELECT m.id AS matriculaId, a.nome AS alunoNome, 
            f.data_vencimento AS dataVencimento, f.valor
            FROM faturas_matriculas f
            JOIN matriculas m ON m.id = f.matricula_id
            JOIN alunos a ON a.id = m.aluno_id
            WHERE f.status = 'ABERTA'
            ORDER BY f.data_vencimento DESC
        """,
        nativeQuery = true
    )
    List<FaturasEmAbertoProjection> faturasEmAberto();
}
