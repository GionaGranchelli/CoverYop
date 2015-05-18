package it.univaq.mwt.business;

import it.univaq.mwt.business.model.GruppoDiRiferimento;

import java.util.List;




public interface GruppoDiRiferimentoService {
	
	List<GruppoDiRiferimento> findAllGruppiDiRiferimento();
	List<String> findAllGruppiDiRiferimentoTitoli();
	GruppoDiRiferimento getGruppiDiRiferimentoById(int Id);
}
