package com.example.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import com.example.demo.entity.Alumno;
import com.example.demo.service.interfaces.AlumnoService;

@RestController
@RequestMapping(value="/alumno")
public class AlumnoController {

	@Autowired
	private AlumnoService alumnoService;
	
		
	@GetMapping
	public ResponseEntity<List<Alumno>>listarAlumno(){
		try {
		      List<Alumno> alumnos = alumnoService.readAll();

		      if (alumnos.isEmpty()) {
		        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		      }
		      return new ResponseEntity<>(alumnos, HttpStatus.OK);
		    } catch (Exception e) {
		      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		    }		
	}
	 @PostMapping
	  public ResponseEntity<String> createAlumno(@RequestBody Alumno alumno) {
	    try {
	      alumnoService.create(new Alumno(alumno.getNombres(), alumno.getApellidos(), alumno.getCorreo(),alumno.getTelefono()));
	      return new ResponseEntity<>("Alumno was created successfully.", HttpStatus.CREATED);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }

	  @PutMapping("/{id}")
	  public ResponseEntity<String> updateAlumno(@PathVariable("id") int id, @RequestBody Alumno alumno) {
	    Alumno _alumno = alumnoService.read(id);

	    if (_alumno != null) {
	      _alumno.setIdalumno(id);
	      _alumno.setNombres(alumno.getNombres());
	      _alumno.setApellidos(alumno.getApellidos());
	      _alumno.setCorreo(alumno.getCorreo());
	      _alumno.setTelefono(alumno.getTelefono());
	      alumnoService.update(_alumno);
	      return new ResponseEntity<>("Alumno was updated successfully.", HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>("Cannot find Alumno with id=" + id, HttpStatus.NOT_FOUND);
	    }
	  }
	  @GetMapping("/{id}")
	  public ResponseEntity<Alumno> getAlumno(@PathVariable("id") int id) {
	    Alumno _alumno = alumnoService.read(id);

	    if (_alumno!= null) {
	      return new ResponseEntity<>(_alumno, HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }
	  @DeleteMapping("/{id}")
	  public ResponseEntity<String> deleteAlumno(@PathVariable("id") int id) {
	    try {
	      int result = alumnoService.delete(id);
	      if (result == 0) {
	        return new ResponseEntity<>("Cannot find Alumno with id=" + id, HttpStatus.OK);
	      }
	      return new ResponseEntity<>("Alumno was deleted successfully.", HttpStatus.OK);
	    } catch (Exception e) {
	      return new ResponseEntity<>("Cannot delete Alumno.", HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
}
