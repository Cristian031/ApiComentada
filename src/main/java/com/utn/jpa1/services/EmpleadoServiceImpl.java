package com.utn.jpa1.services;

import com.utn.jpa1.entities.EmpleadoEntity;
import com.utn.jpa1.repositories.BaseRepository;
import com.utn.jpa1.repositories.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmpleadoServiceImpl extends BaseServiceImpl<EmpleadoEntity, Long> implements EmpleadoService {

    @Autowired
    private final EmpleadoRepository empleadoRepository;
    public EmpleadoServiceImpl(BaseRepository<EmpleadoEntity, Long> baseRepository, EmpleadoRepository empleadoRepository) {
        super(baseRepository);
        this.empleadoRepository = empleadoRepository;
    }

    @Override
    public List<EmpleadoEntity> search(String filtro) throws Exception {
        try{
            List<EmpleadoEntity> empleados = empleadoRepository.findByNombreContainingOrApellidoContaining(filtro, filtro);
            return empleados;
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Page<EmpleadoEntity> search(String filtro, Pageable pageable) throws Exception {
        try{
            Page<EmpleadoEntity> empleados = empleadoRepository.findByNombreContainingOrApellidoContaining(filtro, filtro, pageable);
            return empleados;
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
