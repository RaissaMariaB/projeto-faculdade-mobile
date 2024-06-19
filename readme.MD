# Projeto Ciclo de vida de uma Activity
Olá!
Somos um grupo de alunos da Faculdade Nova Roma Campus Recife :))

Estamos criando esse projeto com intuito de destrinchar, explicar e exemplificar o conceito de maior
base em uma aplicação android 
<br/>
:star A Activity e seu ciclo de vida :star

Ela se destaca como um pilar central, desempenhando um papel crucial na criação de interfaces de 
usuário interativas. <br/>

## SUMÁRIO:

1. Introdução 
2. Diagramas e estados do ciclo de vida 
3. Métodos do ciclo de vida 
4. Como ocorre o gerenciamento de estados em uma activity - salvando e restaurando esse estado
5. Navegação entre activities 
6. Melhores práticas - Uso de Fragments para uma gestão flexível de UI
7. Vídeo gravado pelos alunos com monitoramento via LogCat da sobrescrita dos métodos do ciclo de vida para análise em um aplicativo real
8. Conclusão
9. Referências de estudo

<br>

## Apresentação

### Quem Somos nós?

Este grupo é composto pelos alunos:

Raissa Maria Silva Barata Pereira :spark
- E-mail: raissaamria.sb@gmail.com
- [LinkedIn](https://www.linkedin.com/in/raissa-barata-pereira)
- [GitHub](https://github.com/RaissaMariaB)
<br>

Laila Maria Silva Pereira :spark
- E-mail: raissaamria.sb@gmail.com
- [LinkedIn](https://www.linkedin.com/in/raissa-barata-pereira)
- [GitHub](https://github.com/RaissaMariaB)
<br>

Dyeggo Bezerra :spark
- E-mail: raissaamria.sb@gmail.com
- [LinkedIn](https://www.linkedin.com/in/raissa-barata-pereira)
- [GitHub](https://github.com/RaissaMariaB)
  <br>


## Introdução

Se fossemos trazer de uma forma muito resumida, poderíamos dizer que uma activity é uma tela,
onde temos os componentes de texto, botões, menus, entre outros.

Mas para uma activity estar completa ela precisa ser composta por uma classe Kotlin de um arquivo Kotlin,
que é class MainActivity e um arquivo XML.
A combinação desses dois forma uma activity nós usamos essa tela, essa "atividade" para fazer algo:
A pesar de ser possível criar um arquivo sem o outro, não é algo rotineiro nem usual de ser feito.
<br/>
<img src='./assets/activity1.png '>
<br/>
Dica! Como boas prática na nomenclatura de uma activity, colocamos o nome activity ao fim. 
Ex: detalhesActivity

Um aplicativo pode ter várias Activities para diferentes propósitos, como criar um email ou ler um email.
E apesar de operarem de forma independente, elas trabalham juntas para formar a experiência do usuário.
O gerenciamento eficaz do ciclo de vida de uma Activity permite que os aplicativos se comportem de
maneira previsível durante eventos como rotações de tela, garantindo que o
estado do aplicativo seja mantido de forma consistente.

#### Quais configurações podemos colocar quando criamos uma activity?

<img src='./assets/configurations.png '>

- O primeiro campo Define o nome da sua activity, que como foi citado anteriormente temos como
prática manter o nome activity no fim.
- A primeira marcação de checkBox indica que vamos criar nosso arquivo de layout XML em conjunto
- O campo layout name indica o nome desse arquivo de layout que está sendo criado
- O segundo checkBox com "Launcher Activity" em questão, indica que essa será a primiera activity 
chamada para a abertura do seu aplicativo.
- No dropdown de package name podemos selecionar o local do dosso projeto onde aquela activity será criada
- A campo de source language permite a escolha da linguagem a ser utilizada, que como sabemos, pode ser kotlin ou java.


## Imagem com diagrama, detalhes e  estados do ciclo de vida de uma acitvity

O ciclo de vida de uma Activity no Android é um conjunto de estados pelos quais a Activity passa 
desde o momento de sua criação até sua destruição. Esses estados são gerenciados por callbacks que 
o sistema chama, permitindo que o desenvolvedor saiba que estado a Activity está e prepare a 
aplicação para executar certas ações.



## Métodos do ciclo de vida

  ```
     onCreate() -> onStart() -> onResume() -> Activity em execução
        ^            |             |              |
        |            |             |              |
        |            v             v              v
        |          onStop() <- onPause() <- Activity pausada
        |              |                          |
        |              |                          |
        |              v                          |
        |          onRestart() -------------------
        |              |
        v              v
    onDestroy() <- Activity sendo finalizada

   ```

####  Lista com nomes dos métodos em cada etapa de forma sucinta

- onCreate(): Inicializa uma activity
- onStart(): Torna a activity visível para o usuário 
- onResume(): Coloca uma Activity em primiero plano e interativa
- onPause(): Preparação para pausar uma activity
- onStop(): Activity não mais visível
- onRestart(): Preparando para retomar uma activity
- onDestroy(): Limpeza final de uma activity


## Informações gerais sobre o projeto

- Nós temos básica de apenas duas telas 
- Este projeto tem como objetivo mostrar a linha do tempo que a execução dos métodos do ciclo de 
vida de uma activity ocorrem.
- Essa verificação ocorre com a sobrescrita dos métodos do ciclo de vida que executan Info logs.
- Você pode baixar e executar tranquilamente na sua máquina, verificando esses ciclos.


## Como ocorre o gerenciamento de estados em uma activity - salvando e restaurando esse estado

- O gerenciamento de estado em uma Activity no Android é crucial para preservar e restaurar o estado da interface do usuário quando ocorrem eventos como rotações de tela ou mudanças de configuração.
- Uma mudança na configuração (por exemplo, rotação do dispositivo) pode causar a destruição e reconstrução da Activity, o que requer o uso de métodos como onSaveInstanceState() para manter o estado.
- Para dados mais complexos ou persistentes, considere o uso de bancos de dados locais (como Room para SQLite) ou SharedPreferences.

Essas práticas ajudam a garantir uma experiência consistente para o usuário, preservando o estado da interface do usuário mesmo quando ocorrem eventos que afetam a vida da Activity.

### Principais métodos e técnicas utilizadas para realizar esse gerenciamento:

Salvando Estado

1. onSaveInstanceState(Bundle outState)

- Este método é chamado antes da Activity ser destruída, dando a oportunidade de salvar informações importantes para um Bundle.
- Bundle é um dicionário para armazenar e transmitir informações de estado e objetos entre Activity.
- Você pode usar put métodos no Bundle para salvar dados primitivos ou objetos serializáveis.

Restaurando Estado

2. onCreate(Bundle savedInstanceState)

- Quando a Activity é recriada após uma mudança de configuração, o Bundle savedInstanceState é fornecido para restaurar o estado anterior.
- Verifique se savedInstanceState não é nulo antes de tentar restaurar valores, para evitar NullPointerException.

Ciclo de Vida

3. onRestoreInstanceState(Bundle savedInstanceState)

- Este método é chamado depois de onStart() quando existe um estado salvo para ser restaurado, mas não é amplamente usado porque a restauração geralmente é feita dentro de onCreate().

## Navegação entre activities
