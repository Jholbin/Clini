package net.clinica.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import net.clinica.entity.Contacto;
import net.clinica.services.ContactoServices;

@RestController
@RequestMapping("/contacto")
public class ContactoController {
	@Autowired
	private ContactoServices serMed;
	
	@GetMapping("/lista")
	public List<Contacto> index() {
		return serMed.listarTodos();
	}
	@PostMapping("/registrar")
	public ResponseEntity<Contacto> registrar(@RequestBody Contacto bean) {
		Contacto obj=serMed.registrar(bean);
		return new ResponseEntity<>(obj,HttpStatus.CREATED);
	}
	@PutMapping("/actualizar")
	public ResponseEntity<Contacto> actualizar(@RequestBody Contacto bean) {
		Contacto obj=serMed.actualizar(bean);
		return new ResponseEntity<>(obj,HttpStatus.CREATED);
	}	
	@DeleteMapping("/eliminar/{codigo}")
	public ResponseEntity<Void> eliminar(@PathVariable("codigo") Integer cod){
		serMed.eliminarPorID(cod);		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}


















