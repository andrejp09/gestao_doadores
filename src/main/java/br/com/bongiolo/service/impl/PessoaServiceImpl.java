package br.com.bongiolo.service.impl;

import br.com.bongiolo.dto.*;
import br.com.bongiolo.model.Endereco;
import br.com.bongiolo.model.Pessoa;
import br.com.bongiolo.model.TipoSanguineo;
import br.com.bongiolo.projection.*;
import br.com.bongiolo.repository.PessoaRepository;
import br.com.bongiolo.repository.TipoSanguineoRepository;
import br.com.bongiolo.service.PessoaService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class PessoaServiceImpl implements PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private TipoSanguineoRepository tipoSanguineoRepository;

    @Autowired
    private ModelMapper modelMapper;
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public List<Pessoa> process(MultipartFile file) {
        try {
            String content = new String(file.getBytes());
            List<PessoaDTO> pessoasDTO = objectMapper.readValue(content, new TypeReference<List<PessoaDTO>>() {
            });
            List<Pessoa> pessoas = pessoasDTO.stream().map(this::convertToEntity).toList();
            return pessoaRepository.saveAll(pessoas);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<DoadoresEstadoDTO> getDoadoresPorEstadoETipo() {
        Optional<List<DoadoresEstadoProjection>> byTotalDoadorPorEstado = pessoaRepository.findTotalDoadorPorEstado();
        return byTotalDoadorPorEstado.map(pessoas -> pessoas.stream().map(
                        doador -> modelMapper.map(doador, DoadoresEstadoDTO.class)
                ).toList())
                .orElse(List.of());
    }

    @Override
    public List<DoadoresReceptoresDTO> getDoadoresReceptiores() {
        Optional<List<DoadoresReceptoresProjection>> byTotalDoadorPorEstado = pessoaRepository.findAllTotalDoadoresReceptores();
        return byTotalDoadorPorEstado.map(pessoas -> pessoas.stream().map(
                        doador -> modelMapper.map(doador, DoadoresReceptoresDTO.class)
                ).toList())
                .orElse(List.of());
    }

    @Override
    public List<DoadoresIdadeTipoDTO> getMediaIdadePorTipoSanguineo() {
        Optional<List<DoadoresIdadeTipoProjection>> byTotalDoadorPorEstado = pessoaRepository.findAllMediaIdadeDoadoresTipo();
        return byTotalDoadorPorEstado.map(pessoas -> pessoas.stream().map(
                        doador -> modelMapper.map(doador, DoadoresIdadeTipoDTO.class)
                ).toList())
                .orElse(List.of());
    }

    @Override
    public List<DoadoresFaixaEtariaIMCMedioDTO> getFaixaEtariaIMCMedio() {
        Optional<List<DoadoresFaixaEtariaIMCMedioProjection>> byTotalDoadorPorEstado = pessoaRepository.findAllFaixaEtariaIMCMedio();
        return byTotalDoadorPorEstado.map(pessoas -> pessoas.stream().map(
                        doador -> modelMapper.map(doador, DoadoresFaixaEtariaIMCMedioDTO.class)
                ).toList())
                .orElse(List.of());
    }

    @Override
    public Map<String, String> getPercentualObesoPorGenero() {
        List<ObesosProjection> obesosProjections = pessoaRepository.findPercentualObesoPorGenero()
                .orElse(null);
        HashMap<String, String> obesos = new HashMap<>();
        if (obesosProjections != null) {
            obesosProjections.forEach(obeso -> obesos.put(obeso.getSexo(), obeso.getPercentual().toString()));
            return obesos;
        }
        return obesos;
    }


    private Pessoa convertToEntity(PessoaDTO pessoaDTO) {
        List<TipoSanguineo> tipos = tipoSanguineoRepository.findAll();
        Endereco endereco = new Endereco(
                pessoaDTO.getCep(),
                pessoaDTO.getEndereco(),
                pessoaDTO.getNumero(),
                pessoaDTO.getBairro(),
                pessoaDTO.getCidade(),
                pessoaDTO.getEstado()
        );
        Pessoa pessoa = new Pessoa(
                pessoaDTO.getNome(),
                pessoaDTO.getCpf(),
                pessoaDTO.getRg(),
                pessoaDTO.getDataNascimento(),
                pessoaDTO.getSexo(),
                pessoaDTO.getMae(),
                pessoaDTO.getPai(),
                pessoaDTO.getEmail(),
                pessoaDTO.getTelefoneFixo(),
                pessoaDTO.getCelular(),
                pessoaDTO.getAltura(),
                pessoaDTO.getPeso(),
                endereco
        );
        tipos.stream().filter(tipoSanguineo -> tipoSanguineo.getTipo().equalsIgnoreCase(pessoaDTO.getTipoSanguineo())).findFirst()
                .ifPresent(pessoa::setTipoSanguineo);
        return pessoa;
    }
}
