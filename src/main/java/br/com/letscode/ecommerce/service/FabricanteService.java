package br.com.letscode.ecommerce.service;

import br.com.letscode.ecommerce.model.entity.FabricanteEntity;
import br.com.letscode.ecommerce.model.exchange.FabricanteRequest;
import br.com.letscode.ecommerce.repository.FabricanteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class FabricanteService {

    private FabricanteRepository fabricanteRepository;

    public FabricanteEntity criar(FabricanteRequest request){
        return fabricanteRepository.save(request.toEntity());
    }
}
