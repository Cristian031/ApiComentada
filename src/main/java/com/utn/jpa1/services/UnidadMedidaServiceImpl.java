package com.utn.jpa1.services;

import com.utn.jpa1.entities.UnidadMedida;
import com.utn.jpa1.repositories.BaseRepository;
import com.utn.jpa1.repositories.UnidadMedidaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UnidadMedidaServiceImpl extends BaseServiceImpl<UnidadMedida, Long> implements UnidadMedidaService{

    @Autowired
    private UnidadMedidaRepository unidadMedidaRepository;

    public UnidadMedidaServiceImpl(BaseRepository<UnidadMedida, Long> baseRepository) {
        super(baseRepository);
    }

    @Override
    public List<UnidadMedida> search(String string) throws Exception {
        return null;
    }

    @Override
    public Page<UnidadMedida> search(String string, Pageable pageable) throws Exception {
        return null;
    }
}
