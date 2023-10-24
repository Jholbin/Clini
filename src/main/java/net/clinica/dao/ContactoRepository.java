package net.clinica.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import net.clinica.entity.Contacto;

public interface ContactoRepository extends JpaRepository<Contacto, Integer>{
	
}
