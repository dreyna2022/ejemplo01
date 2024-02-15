package com.example.demo.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.interfaces.AlumnoDao;
import com.example.demo.entity.Alumno;
import com.example.demo.service.interfaces.AlumnoService;
@Service
public class AlumnoServiceImpl implements AlumnoService{
	
	@Autowired
	private AlumnoDao alumnoDao;

	@Override
	public int create(Alumno a) {
		// TODO Auto-generated method stub
		return alumnoDao.create(a);
	}

	@Override
	public int update(Alumno a) {
		// TODO Auto-generated method stub
		return alumnoDao.update(a);
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return alumnoDao.delete(id);
	}

	@Override
	public Alumno read(int id) {
		// TODO Auto-generated method stub
		return alumnoDao.read(id);
	}

	@Override
	public List<Alumno> readAll() {
		// TODO Auto-generated method stub
		return alumnoDao.readAll();
	}


}
