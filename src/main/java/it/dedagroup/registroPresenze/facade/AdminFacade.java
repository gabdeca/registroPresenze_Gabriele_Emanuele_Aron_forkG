package it.dedagroup.registroPresenze.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.dedagroup.registroPresenze.DTO.ResponseUtenteDTO;
import it.dedagroup.registroPresenze.mapper.UtenteMapper;
import it.dedagroup.registroPresenze.model.Utente;
import it.dedagroup.registroPresenze.service.model.AdminService;

@Service
public class AdminFacade {

	@Autowired
	AdminService admin;
	@Autowired
	UtenteMapper mapperA;
	
	public List<ResponseUtenteDTO> getUtenti(){
		List<Utente> listaU=admin.getUtenti();
		return listaU.stream().map(mapperA::toUtenteDTO).toList();
	}
	
	public  ResponseUtenteDTO getUtenteById(long id) {
		return mapperA.toUtenteDTO(admin.getUtenteById(id));
	}
	
	public  ResponseUtenteDTO getUtenteByUsername(String username) {
		return mapperA.toUtenteDTO(admin.getUtenteByUsername(username));
	}
}