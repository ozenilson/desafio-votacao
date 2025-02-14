package br.com.occ.desafiovotacao.v1.service;

import br.com.occ.desafiovotacao.v1.dto.SessaoDto;
import br.com.occ.desafiovotacao.v1.model.Pauta;
import br.com.occ.desafiovotacao.v1.model.Sessao;

import java.util.List;
import java.util.Optional;

public interface ISessaoService {
    Sessao findById(Long id);
    List<Sessao> findAll();
    Sessao save(SessaoDto sessao, Long idPauta);
    List<Sessao> findAllAtivas();

}
