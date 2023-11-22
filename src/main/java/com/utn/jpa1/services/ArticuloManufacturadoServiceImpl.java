package com.utn.jpa1.services;

import com.utn.jpa1.ennumerations.EstadoBasico;
import com.utn.jpa1.entities.ArticuloManufacturadoEntity;
import com.utn.jpa1.entities.TipoArticulo;
import com.utn.jpa1.repositories.ArticuloInsumoRepository;
import com.utn.jpa1.repositories.ArticuloManufacturadoRepository;
import com.utn.jpa1.repositories.BaseRepository;
import com.utn.jpa1.repositories.TipoArticuloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ArticuloManufacturadoServiceImpl extends BaseServiceImpl<ArticuloManufacturadoEntity, Long> implements ArticuloManufacturadoService {
    @Autowired
    ArticuloManufacturadoRepository articuloManufacturadoRepository;
    @Autowired
    TipoArticuloRepository tipoArticuloRepository;

    @Autowired
    private ArticuloInsumoRepository articuloInsumoRepository;
    public ArticuloManufacturadoServiceImpl(BaseRepository<ArticuloManufacturadoEntity, Long> baseRepository) {
        super(baseRepository);
    }


    @Override
    public List<ArticuloManufacturadoEntity> search(String string) throws Exception {
        return null;
    }

    @Override
    public Page<ArticuloManufacturadoEntity> search(String string, Pageable pageable) throws Exception {
        return null;
    }



    @Override
    public List<ArticuloManufacturadoEntity> searchByTipo(String filtro) throws Exception {
        try{
            TipoArticulo tipoArticulo = tipoArticuloRepository.searchTipo(filtro);
            List<ArticuloManufacturadoEntity> articulos = new ArrayList<>();
            List<ArticuloManufacturadoEntity> articulosCandidatos = new ArrayList<>();
            articulosCandidatos = articuloManufacturadoRepository.findAll();
            for (int i = 0; i < articulosCandidatos.size() ; i++) {
                if (articulosCandidatos.get(i).getTipoArticulo() == tipoArticulo){
                    articulos.add(articulosCandidatos.get(i));
                }
            }
            return articulos;
        }catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public ArticuloManufacturadoEntity cambiarEstado(Long artId, EstadoBasico estado) throws Exception{
        try{
            ArticuloManufacturadoEntity articuloManufacturado = articuloManufacturadoRepository.getById(artId);
            articuloManufacturado.setEstado(estado);
            articuloManufacturadoRepository.save(articuloManufacturado);
            return articuloManufacturado;
        }catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
