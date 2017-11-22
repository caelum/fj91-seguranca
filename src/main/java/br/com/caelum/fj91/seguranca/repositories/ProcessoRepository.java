package br.com.caelum.fj91.seguranca.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.caelum.fj91.seguranca.models.Processo;

@Repository
public interface ProcessoRepository extends JpaRepository<Processo, Long> {

}
