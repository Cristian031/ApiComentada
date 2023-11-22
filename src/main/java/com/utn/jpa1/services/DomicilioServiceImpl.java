package com.utn.jpa1.services;

import com.utn.jpa1.entities.DomicilioEntity;
import com.utn.jpa1.repositories.BaseRepository;
import com.utn.jpa1.repositories.DomicilioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DomicilioServiceImpl extends BaseServiceImpl<DomicilioEntity, Long> implements DomicilioService {
    @Autowired
    private final DomicilioRepository domicilioRepository;
    public DomicilioServiceImpl(BaseRepository<DomicilioEntity, Long> baseRepository, DomicilioRepository domicilioRepository) {
        super(baseRepository);
        this.domicilioRepository = domicilioRepository;
    }

    @Override
    public List<DomicilioEntity> search(String string) throws Exception {
        return null;
    }

    @Override
    public Page<DomicilioEntity> search(String string, Pageable pageable) throws Exception {
        return null;
    }
}

