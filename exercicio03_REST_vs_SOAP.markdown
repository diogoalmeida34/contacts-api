# Exercício 3 - REST e SOAP

## Qual a principal diferença entre REST e SOAP?

**REST (Representational State Transfer)** é uma arquitetura baseada em HTTP, que utiliza métodos padrão de HTTP (GET, POST, PUT, DELETE) para manipulação de recursos. As respostas da API podem ser em formatos como JSON ou XML, sendo mais leve e flexível.

**SOAP (Simple Object Access Protocol)** é um protocolo de comunicação baseado em XML para formatar mensagens, exigindo uma camada adicional de segurança, transações e protocolos, o que o torna mais rígido e complexo.

**Principais diferenças:**
- **REST**: Mais simples, flexível, suporta múltiplos formatos de dados (JSON, XML, etc.).
- **SOAP**: Mais complexo, rígido, utiliza exclusivamente XML.

## Em quais cenários SOAP ainda é utilizado?

- **Sistemas Legados**: Empresas com sistemas baseados em SOAP mantêm seu uso para compatibilidade.
- **Bancos e Instituições Financeiras**: Para transações críticas, como transferências bancárias e processamento de pagamentos, onde segurança e confiabilidade são cruciais.
- **Sistemas Corporativos e Governamentais**: Utilizado em sistemas que exigem alto nível de segurança e transações complexas, aproveitando o suporte a padrões como WS-Security.

## Quais são as vantagens e desvantagens de usar REST ao invés de SOAP?

### Vantagens do REST:
- Simplicidade na implementação e configuração.
- Flexibilidade com múltiplos formatos de resposta (JSON, XML, HTML, etc.).
- Menor sobrecarga de comunicação, devido à ausência de cabeçalhos e estruturas complexas.

### Desvantagens do REST:
- Menos rigor em padrões de segurança e transações, o que pode ser um problema em sistemas críticos.

### Vantagens do SOAP:
- Maior segurança com suporte a transações complexas via WS-Security.
- Suporte robusto para operações e transações atômicas.

### Desvantagens do SOAP:
- Complexidade na configuração e manutenção.
- Desempenho inferior ao REST devido ao uso exclusivo de XML.

## O que é WS-Security e como ele se compara à segurança em APIs REST?

**WS-Security** é um conjunto de padrões para garantir a segurança de mensagens SOAP, implementando autenticação, criptografia, assinatura e integridade de mensagens.

**Segurança em APIs REST** é geralmente implementada com OAuth 2.0, JWT (JSON Web Tokens) ou HTTPS, oferecendo soluções mais simples, porém com menos recursos avançados em comparação ao WS-Security. REST prioriza simplicidade, enquanto SOAP oferece maior robustez para segurança.

## Explique o modelo de maturidade de Richardson.

O **modelo de maturidade de Richardson** avalia como uma API REST adere aos princípios REST, sendo dividido em 4 níveis:

- **Nível 0**: A API não utiliza métodos HTTP corretamente, geralmente com uma única URL para todas as operações (ex.: apenas POST).
- **Nível 1**: Utiliza diferentes URLs para diferentes operações, mas ainda não usa métodos HTTP adequadamente (ex.: operações com POST).
- **Nível 2**: Usa métodos HTTP corretos (GET, POST, PUT, DELETE) para manipulação de recursos.
- **Nível 3**: Segue boas práticas REST, incluindo **HATEOAS** (Hypermedia as the Engine of Application State), permitindo navegação dinâmica pelos recursos com links.

## O que é GraphQL?

**GraphQL** é uma alternativa ao REST para APIs, permitindo que o cliente especifique exatamente os dados desejados, evitando **over-fetching** (buscar dados desnecessários) e **under-fetching** (não buscar dados suficientes).

- Possui um único endpoint para consultas, ao invés de múltiplos endpoints como no REST.
- É útil em sistemas complexos, otimizando requisições ao permitir que o cliente obtenha dados de várias fontes de forma eficiente.