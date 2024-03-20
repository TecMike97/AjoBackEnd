package org.generations.AjoDeBruja.service;

import java.util.ArrayList;

import org.generations.AjoDeBruja.model.Registros;
import org.springframework.stereotype.Service;

@Service
public class RegistrosService {
	public final ArrayList<Registros> list = new ArrayList<Registros>();

	public RegistrosService() {
		list.add(new Registros("José López Rodríguez", "5545990810", "joselo_01@gmail.com", "J%l910R^0"));
		list.add(new Registros("Enrique Becerril Navarrete", "5564602346", "becerriln.enrique@gmail.com", "P]597I>w"));
		list.add(new Registros("Joel Francisco Gómez Castro", "5530499196", "joelfcogomezc@gmail.com", "3>87%kFx"));
		list.add(new Registros("Glenda Valentín Robles", "5573261445", "glendavalentin25@gmail.com", "8<27gVr%"));
	}// constructor

	public ArrayList<Registros> getAllRegistros() {
		return list;
	}

	public Registros getRegistros(int regId) {
		Registros tmpProd = null;
		for (Registros registro : list) {
			if (registro.getId_registro() == regId)
				tmpProd = registro;
			break;
		} // forEach
		return tmpProd;
	}

	public Registros addRegistros(Registros registro) {
		Registros tmpProd = null;
		if (list.add(registro)) {
			tmpProd = registro;
		} // if
		return tmpProd;
	}

	public Registros deleteRegistros(int regId) {
		Registros tmpProd = null;
		for (Registros cliente : list) {
			if (cliente.getId_registro() == regId) {
				tmpProd = cliente;
				list.remove(cliente);// borrar el producto de la lista
				break;
			} // if ==
		} // forEach
		return tmpProd;
	}
}
