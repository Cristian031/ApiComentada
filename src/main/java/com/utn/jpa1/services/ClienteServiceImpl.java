package com.utn.jpa1.services;

import com.utn.jpa1.DTOs.DTORankingClientes;
import com.utn.jpa1.entities.ClienteEntity;
import com.utn.jpa1.repositories.BaseRepository;
import com.utn.jpa1.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
@Service
public class ClienteServiceImpl extends BaseServiceImpl<ClienteEntity, Long> implements ClienteService {

    @Autowired
    private final ClienteRepository clienteRepository;
    public ClienteServiceImpl(BaseRepository<ClienteEntity, Long> baseRepository, ClienteRepository clienteRepository) {
        super(baseRepository);
        this.clienteRepository = clienteRepository;
    }

    @Override
    public List<ClienteEntity> search(String filtro) throws Exception {
        try{
            List<ClienteEntity> clientes = clienteRepository.findByNombreContainingOrApellidoContaining(filtro, filtro);
            return clientes;
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Page<ClienteEntity> search(String filtro, Pageable pageable) throws Exception {
        try{
            Page<ClienteEntity> clientes = clienteRepository.findByNombreContainingOrApellidoContaining(filtro, filtro, pageable);
            return clientes;
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
    public List<DTORankingClientes> rankingClientes(String date1, String date2) throws Exception {
        try{
            //paso filtro fechas y idCliente
            List<ClienteEntity> clientes = clienteRepository.findAll();
            List<DTORankingClientes> dto = new ArrayList<>();
            System.out.println(dto.size()+" amDto");
//            for (int i = 0; i < clientes.size() ; i++) {
//                dto.add(i, null);
//            }
            for (int i = 0; i < clientes.size(); i++) {
                DTORankingClientes dtoRankingClientes = new DTORankingClientes();
                long id = clientes.get(i).getId();
                dtoRankingClientes.setClienteId(id);
                dtoRankingClientes.setNombre(clientes.get(i).getNombre());
                dtoRankingClientes.setApellido(clientes.get(i).getApellido());
                //seteo cantidad de pedidos con la query
                dtoRankingClientes.setCantidadPedidos(clienteRepository.searchClienteRanking(id, date1, date2));
                dto.add(dtoRankingClientes);
            }
            dto.sort(Comparator.comparingInt(DTORankingClientes::getCantidadPedidos));

            return dto;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

}
