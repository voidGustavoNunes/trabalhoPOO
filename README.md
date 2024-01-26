### Primeiro Trabalho de POOII - SSPEVAR

- Este trabalho foi desenvolvido na disciplina de Programação Orientada a Objetos II 
- Licença Livre

  
### Contextualização:
O Ministério da Saúde diante da demanda constante de melhoria dos processos
gerenciais, de diagnóstico, etc. lhe contratou para desenvolver um Sistema de
Simulação de Saúde de um Paciente Enfermo por várias doenças, o SSPEVAR.

O SSPEVAR deve receber os dados de um paciente e as informações acerca de
cada um dos agentes patológicos atuantes sobre esse paciente. Ao final do processo o
sistema deve retornar uma de duas informações:

1. Se o paciente viver, em quantos dias ele vencerá os agentes patológicos e ficará
curado.

2. Se ele morrer, quantos dias lhe restam de vida.
   
Para fins de SSPEVAR um paciente morre quando um de seus tipos de célula
acaba (chega a 0).

Para o SSPEVAR os agentes patológicos irão atuar sempre da mesma forma
todos os dias.

Tanto as informações sobre o paciente quanto dos agentes patológicos serão
fornecidas via arquivo.

Basicamente devem ser lidos os dados de um paciente e os dados da lista de
agentes patológicos. Uma vez feito isso, a cada dia, todos os agentes patológicos irão
atacar o paciente. Quando todos os agentes promoveram seu ataque e o paciente
ainda não morreu conta-se mais um dia. A cada ataque de um agente patológico há o
contra-ataque do paciente (sistema imunológico do paciente). Se a energia (exceto
para o HIV) chegar a 0 o agente patológico deve ser excluído da lista de agentes
patológicos do paciente.

Desenvolvimento:
Para fins desse trabalho, um paciente pode ser caracterizado pelos seguintes atributos:
• Nome
• Peso
• Altura
• Idade
• Quantidade de leucócitos
• Quantidade de hemárcias
• Quantidade de células T
• Quantidade de células K

- Toda vez que as células do paciente atacam elas retiram (quantidade de
leucócitos)/(peso * altura * idade) de energia vital do agente patológico.
Todo agente patológico possui as seguintes informações:
• Identificação
• Energia Vital
• Classe Geral (vírus, bactéria, protozoário, fungos)
• Classe Específica

Os seguintes agentes patológicos (classes específicas) serão tratados pelo SSPEVAR:
Identificação: <definida via arquivo, basicamente é uma String que identifica de
forma única aquele agente patológico em específico (aquele indivíduo que está
infectando). Ex: HIV1XPTO >
Energia Vital: 0
Classe Geral: Vírus
Classe Específica: HIV
Quando ataca o HIV diminui a quantidade de leucócitos do paciente em 10 unidades,
de células K em 5 unidades e de células T em 3 unidades. A reação do paciente não os
afeta, ou seja, um HIV não morre quando sua energia vital chega a 0 (o paciente
sempre perde no caso de haver um agente patológico do tipo HIV).
Código classe específica: 1


Identificação: XXXXX
Energia Vital: 200
Classe Geral: Bactéria
Classe Específica: Estreptococos
Quando ataca, o Estreptococos diminui a quantidade de hemárcias do paciente em 10
unidades e de células K em 3 unidades. Imediatamente antes de seu ataque, se
houver um outro Estreptococos na sequência, na fila (próximo da fila), eles geram um
novo Estreptococos que é colocado no final da fila (vai atacar apenas no dia
seguinte). Esse novo Estreptococos gerado recebe Identificação feita a partir da
combinação da identificação de seus “pais”: <identificação do primeiro da fila>--
<identificação do segundo da fila>
Código classe específica: 2


Identificação: XXXXX
Energia Vital: 500
Classe Geral: Protozoário
Classe Específica: Giárdia
O ataque da Giárdia retira 8 células T e 9 células K. Se o número de hemárcias for 2
ou mais vezes o número de leucócitos a Giárdia recupera 50 unidades de energia
vital.
Código classe específica: 3


Identificação: XXXXX
Energia Vital: 100
Classe Geral: Virus
Classe Específica: COVID19
O COVID19 elimina 10 leucócitos, 2 células T e 15 hemárcias. Se o número de
hemárcias ficar menor que 200, o COVID19 promove um segundo ataque (antes de ir
para o final da fila). O procedimento de segundo ataque não é recursivo, ou seja, não
haverá um novo ataque depois do segundo ataque (notar que um segundo ataque
promove também um segundo contra-ataque do corpo do paciente).
Código classe específica: 4
Identificação: XXXXX


Energia Vital: 1000
Classe Geral: Fungo
Classe Específica: Histoplasma
O Histoplasma ataca apenas hemárcias, matando 50 hemárcias no ataque. Além
disso, se estiverem do lado de uma Bactéria na fila, essa é eliminada. Esse verificação
deve ser feita toda vez que um Histoplasma ataca e afeta a fila toda, ou seja, deve ser
feita uma varredura na lista verificando se antes ou depois de um histoplasma há uma
Bactéria, se houver, ela morre.
Código classe específica: 5
Identificação: XXXXX


Energia Vital: 64
Classe Geral: Bactéria
Classe Específica: Escherichia coli
Essa Bactéria mata apenas 1 unidade de cada uma das células (leucócitos, hemárcias,
celulas K e T). Mas possuem uma propriedade: Quando morrem, geram 2 filhas com
metade da energia vital original e as dispersam pela fila (as colocam em posições
aleatórias). Quando a energia vital inicial de uma Escherichia coli chega a 1 não
ocorre mais a divisão no momento da morte.
Código classe específica: 6



Faça um programa que leia um arquivo paciente.txt contendo as quantidades de cada
uma de suas células e leia o arquivo patologicos.txt contendo os dados de cada um
dos agentes patológicos. O programa deve exibir na sua saída (tela) as seguintes
informações:

a) (10 pontos) O tipo de agente patológico (classe geral) mais presente/criado
(Bactéria, Fungo, Vírus, Protozoário) no inicio da simulação. Não deve ser
perguntado para cada indíviduo sua classe. Se houver empate ambas classes
de Agentes Patológicos devem ser apresentadas.
Sugestão: Faça cada classe controlar a quantidade de indivíduos criados por
ela.

b) (10 pontos) Indique se o paciente vai viver ou morrer.

c) (10 pontos) Informe a quantidade de dias em que o paciente morre ou vence
os agentes patológicos.

d) (10 pontos) Informe o agente patológico que matou o paciente ou o último
agente patológico que morreu antes da cura do paciente.

Observação: Devem ser utilizados os conceitos de: Classe Abstrata, Herança e Polimorfismo. O
não uso de um desses recursos acarretará a perda significativa de pontos.
Formato de entrada de dados (exemplo):

patologicos.txt:

<código classe específica1> <identificação1>

<código classe específica2> <identificação2>

...

<código classe específican> <identificaçãon>

Exemplo:

1 HIV1XPTO

2 XAXA

3 FURLAN

2 TORK

6 XANA

5 LINKER

1 TORA

1 TEXTOX

3 TY

2 LANG

paciente.txt

Nome = <valor1> (ex: Pedro)

Peso = <valor2> (ex: 100)

Altura = <valor3> (ex: 1,90)

Idade = <valor4> (ex: 40)

Quantidade de leucócitos = <valor5> (ex: 5000)

Quantidade de hemárcias = <valor6> (ex: 4000)

Quantidade de células T = <valor7> (ex: 200)

Quantidade de células K = <valor8> (ex: 400)


Obs1. Para facilitar a leitura de dados, considere o arquivo paciente.txt sempre com essa ordem de
entrada, ou seja, por exemplo, o primeiro elemento lido é o nome e o último é a quantidade de
células k

Obs2. É importante notar que a quantidade de agentes patológicos é indeterminada, ou seja, posso
ter de 0 a quantos agentes patológicos forem informados no arquivo (no nosso exemplo são 10, mas
poderíamos, por exemplo, ter 100 agentes patológicos).

Formato da saída de dados (na tela):

a) As classes que mais aparecem – 3 indivíduos - são Fungo, Bactéria e Virus.

b) O paciente vai morrer (outra possibilidade: O paciente vai viver)

c) O paciente morre em 8 dias (outra possibilidade: O paciente fica curado em 8
dias).

d) O último agente patológico foi FURLAN.

