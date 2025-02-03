package br.com.bongiolo.service;

import br.com.bongiolo.dto.*;
import br.com.bongiolo.model.Pessoa;

import java.util.List;
import java.util.Map;


public interface PessoaService {
    List<Pessoa> process(List<PessoaDTO> pessoasDTO);
    List<DoadoresEstadoDTO> getDoadoresPorEstadoETipo();
    List<DoadoresReceptoresDTO> getDoadoresReceptiores();
    List<DoadoresIdadeTipoDTO> getMediaIdadePorTipoSanguineo();
    List<DoadoresFaixaEtariaIMCMedioDTO> getFaixaEtariaIMCMedio();
    Map<String, String> getPercentualObesoPorGenero();
}
