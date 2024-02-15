package com.example.demo.service.interfaces;

import java.util.List;

import com.example.demo.entity.Alumno;

public interface AlumnoService {
	int create(Alumno a);
	int update(Alumno a);
	int delete(int id);
	Alumno read(int id);
	List<Alumno> readAll();
}
