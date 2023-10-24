package net.clinica.controller;

import java.time.LocalDate;
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
import net.clinica.entity.Medicamento;
import net.clinica.services.MedicamentoServices;

@RestController
@RequestMapping("/medicamento")
public class MedicamentoController {
	@Autowired
	private MedicamentoServices serMed;
	
	@GetMapping("/lista")
	public List<Medicamento> index() {
		return serMed.listarTodos();
	}
	@PostMapping("/registrar")
	public ResponseEntity<Medicamento> registrar(@RequestBody Medicamento bean) {
		Medicamento obj=serMed.registrar(bean);
		return new ResponseEntity<>(obj,HttpStatus.CREATED);
	}
	@PutMapping("/actualizar")
	public ResponseEntity<Medicamento> actualizar(@RequestBody Medicamento bean) {
		Medicamento obj=serMed.actualizar(bean);
		return new ResponseEntity<>(obj,HttpStatus.CREATED);
	}	
	@DeleteMapping("/eliminar/{codigo}")
	public ResponseEntity<Void> eliminar(@PathVariable("codigo") Integer cod){
		serMed.eliminarPorID(cod);		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}


















