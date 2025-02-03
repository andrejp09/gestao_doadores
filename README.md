# Projeto de Gestão de Doadores

## Descrição
Este projeto foi desenvolvido com Java 21 e Maven. Ele tem como objetivo receber um JSON com dados de doadores, processar essas informações e disponibilizar diversos relatórios e estatísticas através de endpoints REST.

## Endpoints Disponíveis

### 1. Total de Candidatos por Estado
**Endpoint:** `GET /api/pessoas/doador-por-estado-tipo`

**Descrição:** Retorna o total de doadores por estado e tipo sanguíneo.

**Exemplo de Resposta:**
```json
[
    {
        "estado": "SP",
        "total": 150
    },
    {
        "estado": "RJ",
        "total": 75
    }
]
```

### 2. IMC Médio por Faixa Etária
**Endpoint:** `GET /api/pessoas/doadores-faixa-etaria-imc`

**Descrição:** Retorna o IMC médio dos doadores por faixa etária.

**Exemplo de Resposta:**
```json
[
    {
        "faixaEtaria": "18-25",
        "imcMedio": 22.5
    },
    {
        "faixaEtaria": "26-35",
        "imcMedio": 24.0
    }
]
```

### 3. Percentual de Obesos entre Homens e Mulheres
**Endpoint:** `GET /api/pessoas/obesos-por-genero`

**Descrição:** Retorna o percentual de doadores obesos entre homens e mulheres.

**Exemplo de Resposta:**
```json
{
    "homens": 20.5,
    "mulheres": 18.3
}
```

### 4. Média de Idade para Cada Tipo Sanguíneo
**Endpoint:** `GET /api/pessoas/media-idade-doador-tipo-sanguineo`

**Descrição:** Retorna a média de idade dos doadores para cada tipo sanguíneo.

**Exemplo de Resposta:**
```json
[
    {
        "tipoSanguineo": "A+",
        "mediaIdade": 30
    },
    {
        "tipoSanguineo": "O-",
        "mediaIdade": 28
    }
]
```

### 5. Possíveis Doadores para Cada Receptor
**Endpoint:** `GET /api/pessoas/doador-tipo-sanguineo-receptor`

**Descrição:** Retorna uma lista de possíveis doadores para cada tipo sanguíneo de receptor.

**Exemplo de Resposta:**
```json
[
    {
        "tipoReceptor": "A+",
        "possiveisDoadores": ["A+", "A-", "O+", "O-"]
    },
    {
        "tipoReceptor": "B+",
        "possiveisDoadores": ["B+", "B-", "O+", "O-"]
    }
]
```

## Tecnologias Utilizadas
- **Java 21**
- **Maven**
- **Spring Boot**
- **JUnit 5** para testes unitários
- **Mockito** para mocks nos testes

## Como Executar o Projeto
1. Clone o repositório.
2. Navegue até o diretório do projeto.
3. Execute o comando `mvn clean install` para compilar o projeto.
4. Execute o comando `mvn spring-boot:run` para iniciar a aplicação.

## Como Executar os Testes
1. Navegue até o diretório do projeto.
2. Execute o comando `mvn test` para rodar os testes.
```