package org.generations.AjoDeBruja.service;

import java.util.List;

import org.generations.AjoDeBruja.model.Registros;
import org.generations.AjoDeBruja.repository.RegistrosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrosService {
	private final RegistrosRepository registrosRepository;
	@Autowired
	public RegistrosService(RegistrosRepository registrosRepository) {
		this.registrosRepository = registrosRepository;
	}//constructor
	
	public List<Registros> getAllRegistros() {
		return registrosRepository.findAll();
	}//getAllRegistros

	public Registros getRegistro(Long regId) {
		return registrosRepository.findById(regId).orElseThrow(
				()-> new IllegalArgumentException("El registro con el id ["
						+ regId + "] no existe.")
				);
	}//getRegistro

	public Registros addRegistro(Registros registro) {
		Registros tmpReg = null;
		if (registrosRepository.findByEmail(registro.getEmail()).isEmpty()) {
			tmpReg = registrosRepository.save(registro);
		}else {
			System.out.println("El registro con el email ["+
					registro.getEmail()+"] ya existe");
		}//if
		return tmpReg;
	}//addRegistro

	public Registros deleteRegistro(Long regId) {
		Registros registro = null;
		if(registrosRepository.existsById(regId)) {
			registro=registrosRepository.findById(regId).get();
			registrosRepository.deleteById(regId);
		}//if
		return registro;
	}//deleteRegistro
}
