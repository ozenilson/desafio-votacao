package br.com.occ.desafiovotacao.v1.service;

import br.com.occ.desafiovotacao.config.exception.ServiceException;
import br.com.occ.desafiovotacao.v1.dto.PautaDto;
import br.com.occ.desafiovotacao.v1.model.Pauta;
import br.com.occ.desafiovotacao.v1.repository.PautaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class PautaService implements IPautaService{

    @Autowired
    PautaRepository repository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public Pauta findById(Long id) {
        Optional<Pauta> pautaOptional = repository.findById(id);
        return pautaOptional.orElseThrow(() -> new ServiceException("Pauta não encontrada",  HttpStatus.NOT_FOUND));
    }

    @Override
    public List<Pauta> findAll() {
        List<Pauta> pautas = repository.findAll();
        if (pautas.isEmpty())
            throw new ServiceException("Não existe pautas cadastradas", HttpStatus.BAD_REQUEST);
        return pautas;
    }

    @Override
    public Pauta save(PautaDto pauta) {
        return repository.save(pauta.toEntity(modelMapper, Pauta.class));
    }

    @Override
    public List<Pauta> findAllAtivas() {
        List<Pauta> pautas = repository.findAllPautasAtivas(LocalDateTime.now());
        if (pautas.isEmpty())
            throw new ServiceException("Não existe pautas ativas", HttpStatus.BAD_REQUEST);
        return pautas;
    }
}
