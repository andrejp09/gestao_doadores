package br.com.bongiolo.repository;
import br.com.bongiolo.model.Pessoa;
import br.com.bongiolo.projection.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
    @Query(value = "SELECT COUNT(p.id) AS total, e.estado " +
            "FROM pessoa p " +
            "JOIN tipo_sanguineo ts ON p.tipo_sanguineo_id = ts.id " +
            "JOIN endereco e ON p.endereco_id = e.id " +
            "where TIMESTAMPDIFF(YEAR, p.data_nascimento, CURDATE()) BETWEEN 16 AND 69 " +
            "AND p.peso > 50 " +
            "GROUP BY e.estado", nativeQuery = true)
    Optional<List<DoadoresEstadoProjection>> findTotalDoadorPorEstado();
    @Query(value = "SELECT ts.tipo AS tipoReceptor, COUNT(p.id) AS quantidadeDoadores " +
            "FROM pessoa p " +
            "JOIN tipo_sanguineo ts ON p.tipo_sanguineo_id = ts.id " +
            "JOIN compatibilidade c ON ts.id = c.tipo_receptor " +
            "WHERE p.tipo_sanguineo_id = c.tipo_doador " +
            "AND TIMESTAMPDIFF(YEAR, p.data_nascimento, CURDATE()) BETWEEN 16 AND 69 " +
            "AND p.peso > 50 " +
            "GROUP BY ts.tipo", nativeQuery = true)
    Optional<List<DoadoresReceptoresProjection>> findAllTotalDoadoresReceptores();


    @Query(value = "SELECT ts.tipo, ROUND(AVG(TIMESTAMPDIFF(YEAR, p.data_nascimento, CURDATE())), 2) AS mediaIdade " +
            "FROM pessoa p " +
            "JOIN tipo_sanguineo ts ON p.tipo_sanguineo_id = ts.id " +
            "where TIMESTAMPDIFF(YEAR, p.data_nascimento, CURDATE()) BETWEEN 16 AND 69 " +
            "AND p.peso > 50 " +
            "GROUP BY ts.tipo ", nativeQuery = true)
    Optional<List<DoadoresIdadeTipoProjection>> findAllMediaIdadeDoadoresTipo();

    @Query(value = "SELECT " +
            "    CASE " +
            "        WHEN TIMESTAMPDIFF(YEAR, p.data_nascimento, CURDATE()) BETWEEN 16 AND 20 THEN '16-20' " +
            "        WHEN TIMESTAMPDIFF(YEAR, p.data_nascimento, CURDATE()) BETWEEN 21 AND 30 THEN '21-30' " +
            "        WHEN TIMESTAMPDIFF(YEAR, p.data_nascimento, CURDATE()) BETWEEN 31 AND 40 THEN '31-40' " +
            "        WHEN TIMESTAMPDIFF(YEAR, p.data_nascimento, CURDATE()) BETWEEN 41 AND 50 THEN '41-50' " +
            "        WHEN TIMESTAMPDIFF(YEAR, p.data_nascimento, CURDATE()) BETWEEN 51 AND 60 THEN '51-60' " +
            "        WHEN TIMESTAMPDIFF(YEAR, p.data_nascimento, CURDATE()) BETWEEN 61 AND 69 THEN '61-69' " +
            "    END AS faixaEtaria, " +
            "    ROUND(AVG(p.peso / (p.altura * p.altura)), 2) AS imcMedio " +
            "FROM pessoa p " +
            "WHERE TIMESTAMPDIFF(YEAR, p.data_nascimento, CURDATE()) BETWEEN 16 AND 69 " +
            "GROUP BY faixaEtaria " +
            "ORDER BY faixaEtaria", nativeQuery = true)
    Optional<List<DoadoresFaixaEtariaIMCMedioProjection>> findAllFaixaEtariaIMCMedio();
    @Query(value = "SELECT sexo, " +
            "ROUND((SUM(CASE WHEN (peso / (altura * altura)) > 30 THEN 1 ELSE 0 END) / COUNT(*)) * 100, 2) AS percentual " +
            "FROM pessoa GROUP BY sexo", nativeQuery = true)
    Optional<List<ObesosProjection>> findPercentualObesoPorGenero();
}

