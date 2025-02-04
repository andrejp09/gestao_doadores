package br.com.bongiolo.service;

import br.com.bongiolo.dto.*;
import br.com.bongiolo.model.Pessoa;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;


public interface PessoaService {
    List<Pessoa> process(MultipartFile file);
    List<DoadoresEstadoDTO> getDoadoresPorEstadoETipo();
    List<DoadoresReceptoresDTO> getDoadoresReceptiores();
    List<DoadoresIdadeTipoDTO> getMediaIdadePorTipoSanguineo();
    List<DoadoresFaixaEtariaIMCMedioDTO> getFaixaEtariaIMCMedio();
    Map<String, String> getPercentualObesoPorGenero();
}
