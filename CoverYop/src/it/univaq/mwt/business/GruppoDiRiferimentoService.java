package it.univaq.mwt.business;

import it.univaq.mwt.business.model.GruppoDiRiferimento;

import java.util.List;




public interface GruppoDiRiferimentoService {
	
	public List<GruppoDiRiferimento> findAllGruppiDiRiferimento();
	public List<String> findAllGruppiDiRiferimentoTitoli();
	public GruppoDiRiferimento getGruppiDiRiferimentoById(int Id);
}
