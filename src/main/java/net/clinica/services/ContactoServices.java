package net.clinica.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.clinica.dao.ContactoRepository;
import net.clinica.entity.Contacto;

@Service
public class ContactoServices {
	@Autowired
	private ContactoRepository repo;
	
	public Contacto registrar(Contacto m) {
		return repo.save(m);
	}
	public Contacto actualizar(Contacto m) {
		return repo.save(m);
	}
	public void eliminarPorID(Integer cod) {
		repo.deleteById(cod);
	}
	public Contacto buscarPorID(Integer cod) {
		return repo.findById(cod).orElse(null);
	}
	public List<Contacto> listarTodos(){
		return repo.findAll();
	}
}
