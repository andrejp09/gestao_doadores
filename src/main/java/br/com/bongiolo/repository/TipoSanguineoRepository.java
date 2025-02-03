package br.com.bongiolo.repository;
import br.com.bongiolo.model.Pessoa;
import br.com.bongiolo.model.TipoSanguineo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoSanguineoRepository extends JpaRepository<TipoSanguineo, Long> {

}
