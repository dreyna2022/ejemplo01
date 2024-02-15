package com.example.demo.dao.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.example.demo.dao.interfaces.AlumnoDao;
import com.example.demo.entity.Alumno;
@Component
public class AlumnoDaoImpl implements AlumnoDao{
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public int create(Alumno a) {
		// TODO Auto-generated method stub
		return jdbcTemplate.update("INSERT INTO alumno (nombres, apellidos, correo, telefono) VALUES(?,?,?,?)",
		        new Object[] { a.getNombres(), a.getApellidos(), a.getCorreo(), a.getTelefono() });
	}

	@Override
	public int update(Alumno a) {
		// TODO Auto-generated method stub
		return jdbcTemplate.update("UPDATE alumno SET nombres=?, apellidos=?, correo=?, telefono=? WHERE idalumno=?",
		        new Object[] { a.getNombres(), a.getApellidos(), a.getCorreo(), a.getTelefono(), a.getIdalumno() });
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return jdbcTemplate.update("DELETE FROM alumno WHERE idalumno=?", id);
	}

	@Override
	public Alumno read(int id) {
		// TODO Auto-generated method stub
		try {
		      Alumno alumno = jdbcTemplate.queryForObject("SELECT * FROM alumno WHERE idalumno=?",
		          BeanPropertyRowMapper.newInstance(Alumno.class), id);
		      return alumno;
		    } catch (IncorrectResultSizeDataAccessException e) {
		      return null;
		    }
	}

	@Override
	public List<Alumno> readAll() {
		// TODO Auto-generated method stub
		return jdbcTemplate.query("select *from alumno", BeanPropertyRowMapper.newInstance(Alumno.class));
	}

}
