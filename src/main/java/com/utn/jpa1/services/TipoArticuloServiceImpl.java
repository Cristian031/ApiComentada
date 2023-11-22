package com.utn.jpa1.services;

import com.utn.jpa1.entities.TipoArticulo;
import com.utn.jpa1.repositories.BaseRepository;
import com.utn.jpa1.repositories.TipoArticuloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TipoArticuloServiceImpl extends BaseServiceImpl<TipoArticulo, Long> implements TipoArticuloService {

    @Autowired
    private TipoArticuloRepository tipoPedidoRepository;
    public TipoArticuloServiceImpl(BaseRepository<TipoArticulo, Long> baseRepository) {
        super(baseRepository);
    }
    @Override
    public List<TipoArticulo> search(String string) throws Exception {
        return null;
    }

    @Override
    public Page<TipoArticulo> search(String string, Pageable pageable) throws Exception {
        return null;
    }
}
