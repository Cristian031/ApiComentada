package com.utn.jpa1.services;

import com.utn.jpa1.entities.DetalleFacturaEntity;
import com.utn.jpa1.repositories.BaseRepository;
import com.utn.jpa1.repositories.DetalleFacturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetalleFacturaServiceImpl extends BaseServiceImpl<DetalleFacturaEntity, Long> implements DetalleFacturaService {
    @Autowired
    private DetalleFacturaRepository detalleFacturaRepository;
    public DetalleFacturaServiceImpl(BaseRepository<DetalleFacturaEntity, Long> baseRepository) {
        super(baseRepository);
    }

    @Override
    public List<DetalleFacturaEntity> search(String string) throws Exception {
        return null;
    }

    @Override
    public Page<DetalleFacturaEntity> search(String string, Pageable pageable) throws Exception {
        return null;
    }

}
