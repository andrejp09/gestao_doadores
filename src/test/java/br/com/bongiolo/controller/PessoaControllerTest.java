package br.com.bongiolo.controller;

import br.com.bongiolo.dto.PessoaDTO;
import br.com.bongiolo.model.Pessoa;
import br.com.bongiolo.service.PessoaService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.multipart.MultipartFile;

import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
class PessoaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private PessoaService pessoaService;

    private final ObjectMapper objectMapper = new ObjectMapper();

    private List<PessoaDTO> pessoasDTO;
    private List<Pessoa> pessoas;

    @BeforeEach
    public void setUp() {
        PessoaDTO pessoaDTO = createPessoaDTO();
        Pessoa pessoa = createPessoa();
        pessoasDTO = List.of(pessoaDTO);
        pessoas = Collections.singletonList(pessoa);
    }

    @Test
    public void deveriaProcessarDadosDePessoa() throws Exception {
        MockMultipartFile file = new MockMultipartFile("file", "pessoas.json", "application/json", "conteudo do arquivo".getBytes());

        when(pessoaService.process(any(MultipartFile.class))).thenReturn(pessoas);
        mockMvc.perform(multipart("/api/pessoas/carregar")
                        .file(file)
                        .contentType(MediaType.MULTIPART_FORM_DATA))
                .andExpect(status().isOk());
        verify(pessoaService, times(1)).process(any(MultipartFile.class));
    }


    @Test
    public void deveriaRetornarStaus200AoBuscarDoadoresPorEstadoETipo() throws Exception {

        mockMvc.perform(get("/api/pessoas/doador-por-estado-tipo")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        verify(pessoaService, times(1)).getDoadoresPorEstadoETipo();
    }

    @Test
    public void deveriaRetornaStatus200AoBuscarDoadoresPorTipoSanguineReceptor() throws Exception {

        mockMvc.perform(get("/api/pessoas/doador-tipo-sanguineo-receptor")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        verify(pessoaService, times(1)).getDoadoresReceptiores();
    }

    @Test
    public void deveriaRetornaStatus200AoBuscarDoadorPorMediaIdade() throws Exception {

        mockMvc.perform(get("/api/pessoas/media-idade-doador-tipo-sanguineo")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        verify(pessoaService, times(1)).getMediaIdadePorTipoSanguineo();
    }

    @Test
    public void deveriaRetornaStatus200AoBuscarDoadorPorFaixaEtaria() throws Exception {

        mockMvc.perform(get("/api/pessoas/doadores-faixa-etaria-imc")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        verify(pessoaService, times(1)).getFaixaEtariaIMCMedio();
    }
    @Test
    public void deveriaRetornaStatus200AoBuscarDoadoresObesosPorGenero() throws Exception {

        mockMvc.perform(get("/api/pessoas/obesos-por-genero")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        verify(pessoaService, times(1)).getPercentualObesoPorGenero();
    }


    private PessoaDTO createPessoaDTO(){
        PessoaDTO pessoaDTO = new PessoaDTO();
        pessoaDTO.setNome("Pessoa 1");
        return pessoaDTO;
    }
    private Pessoa createPessoa(){
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Pessoa 1");
        return pessoa;
    }
}