package br.com.bongiolo.controller;

import br.com.bongiolo.dto.*;
import br.com.bongiolo.model.Pessoa;
import br.com.bongiolo.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/pessoas")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @PostMapping("/carregar")
    public ResponseEntity<List<Pessoa>> createPessoas(@RequestBody List<PessoaDTO> pessoasDTO) {
        List<Pessoa> savedPessoas = pessoaService.process(pessoasDTO);
        return ResponseEntity.ok(savedPessoas);
    }

    @GetMapping("/doador-por-estado-tipo")
    public ResponseEntity<List<DoadoresEstadoDTO>> getDoadoresEstadoETipo() {
        return ResponseEntity.ok(pessoaService.getDoadoresPorEstadoETipo());
    }

    @GetMapping("/doador-tipo-sanguineo-receptor")
    public ResponseEntity<List<DoadoresReceptoresDTO>> getDoadoresReceptiores() {
        return ResponseEntity.ok(pessoaService.getDoadoresReceptiores());
    }

    @GetMapping("/media-idade-doador-tipo-sanguineo")
    public ResponseEntity<List<DoadoresIdadeTipoDTO>> getMediaIdadeDoadorTipoSanguineo() {
        return ResponseEntity.ok(pessoaService.getMediaIdadePorTipoSanguineo());
    }

    @GetMapping("/doadores-faixa-etaria-imc")
    public ResponseEntity<List<DoadoresFaixaEtariaIMCMedioDTO>> getFaixaEtariaIMCMedio() {
        return ResponseEntity.ok(pessoaService.getFaixaEtariaIMCMedio());
    }

    @GetMapping("/obesos-por-genero")
    public ResponseEntity<Map<String, String>> getPercentualObesoPorGenero() {
        return ResponseEntity.ok(pessoaService.getPercentualObesoPorGenero());
    }

}