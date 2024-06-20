# Projeto Ciclo de vida de uma Activity 🤳
Olá!
Somos um grupo de alunos da Faculdade Nova Roma Campus Recife :))

Estamos criando esse projeto com intuito de destrinchar, explicar e exemplificar o conceito de maior
base em uma aplicação android 
<br/>
🌟 A Activity e seu ciclo de vida 🌟

Ela se destaca como um pilar central, desempenhando um papel crucial na criação de interfaces de 
usuário interativas. <br/>

## SUMÁRIO:

1. Introdução 
2. Métodos e estados do ciclo de vida 
3. Navegação entre activities 
4. Como ocorre o gerenciamento de estados em uma activity - salvando e restaurando esse estado
5. Melhores práticas - Uso de Fragments para uma gestão flexível de UI
6. Vídeo gravado pelos alunos com monitoramento via LogCat da sobrescrita dos métodos do ciclo de vida para análise em um aplicativo real
7. Conclusão
8. Referências de estudo

<br>

## Apresentação

### Quem Somos nós?

Este grupo é composto pelos alunos:

Raissa Maria Silva Barata Pereira ✨
- E-mail: raissaamria.sb@gmail.com
- [LinkedIn](https://www.linkedin.com/in/raissa-barata-pereira)
- [GitHub](https://github.com/RaissaMariaB)
<br>

Laila Maria Silva Pereira ✨
- E-mail: raissaamria.sb@gmail.com
- [LinkedIn](https://www.linkedin.com/in/raissa-barata-pereira)
- [GitHub](https://github.com/RaissaMariaB)
<br>

Dyeggo Bezerra ✨
- E-mail: raissaamria.sb@gmail.com
- [LinkedIn](https://www.linkedin.com/in/raissa-barata-pereira)
- [GitHub](https://github.com/RaissaMariaB)
  <br>


## Introdução

Se fossemos trazer de uma forma muito resumida, poderíamos dizer que uma activity é uma tela,
onde temos os componentes de texto, botões, menus, entre outros.

Mas para uma activity estar completa ela precisa ser composta pela combinação de uma classe Kotlin dentro de um arquivo Kotlin,
e também de um arquivo XML.
A combinação desses dois forma uma activity e nós usamos essa tela, (traduzindo livremente para "atividade") para fazer algo
que envolva a interação do usuário
A pesar de ser possível criar um arquivo sem o outro, não é algo rotineiro nem usual de ser feito.
<br/>
<img src='./assets/activity1.png '>
<br/>
👉 Dica! Como boas prática na nomenclatura de uma activity, colocamos o nome activity ao fim. 
Ex: DetalhesActivity

Um aplicativo pode ter várias Activities para diferentes propósitos, como por exemplo criar um email ou ler um email.
E apesar de operarem de forma independente, elas trabalham juntas para formar a experiência do usuário.
O gerenciamento eficaz do ciclo de vida de uma Activity permite que os aplicativos se comportem de
maneira previsível durante eventos como rotações de tela, garantindo que o
estado do aplicativo seja mantido de forma consistente.

#### Quais configurações podemos colocar quando criamos uma activity?


<img src='./assets/configurations.png '>


- O primeiro campo Define o nome da sua activity. Como foi citado anteriormente, temos como
prática manter o nome activity no fim.
- A primeira marcação de checkBox indica que vamos criar nosso arquivo de layout XML em conjunto.
- O campo "layout name" indica o nome desse arquivo de layout que está sendo criado.
- O segundo checkBox com "Launcher Activity", indica que essa será a primeira activity 
chamada para a abertura do seu aplicativo.
- No dropdown de "package name" podemos selecionar o local do dosso projeto onde aquela activity será criada.
- A campo de source language permite a escolha da linguagem a ser utilizada, pois em um projeto android, pode ser kotlin e/ou java.


## Métodos e estados do ciclo de vida
O ciclo de vida de uma Activity no Android é um conjunto de estados pelos quais a Activity passa 
desde o momento de sua criação até sua destruição. Esses estados são gerenciados por callbacks que 
o sistema chama, permitindo que o desenvolvedor saiba qual estado a Activity está e prepare a 
aplicação para executar certas ações. Entender como as Activities são criadas, pausadas, 
retomadas e destruídas é cruacial para criar uma navegação eficiente.


<img src='./assets/ciclodevida.png '>


#### Detalhando os métodos
- onCreate(): Inicializa uma activity
No primeiro momento quando abrimos uma aplicação, ocorre a execução do método onCreate que é chamado 
apenas uma vez durante seu ciclo de vida. Nesse momento a activity jecontra-se no estado de created,
onde ela foi criada mas ainda não se encontra visível para o usuário.

- onStart(): Torna a activity visível para o usuário 
Quando o método onStart é chamado a activity entra no estado de "Started", significa que ela pode 
estar visíviel para o usuário mas não necessariamente em primeiro plano.

- onResume(): Coloca uma Activity em primeiro plano e interativa
O estado da activity nesse momento é chamado de "Resumed", é a retomada de uma activity.
Ela permanece nesse estado enuqanto encontra-se ativa.

- onPause(): Preparação para pausar uma activity
Caso outra activity entre em primeiro plano,  o método onPause()  é chamado e a activity atual entra 
no estado de "Paused". Ela ainda continua visível, porém não se encontra mais no primeiro plano.

- onStop(): Activity não mais visível
A Activity entra no estado "Stopped", que significa que ela está completamente invisivel para
o usuário porém ainda viva no sistema.

- onRestart(): Preparando para retomar uma activity

- onDestroy(): Limpeza final de uma activity
Uma activity pode entrar nesse estado tanto pela chamada do método finish() ou pelo próprio sistema
para recuperar recursos, ea entra no modo de "Destroyed", logo após a chamada do método onDestroy().
Nesse momento ela é removida da memória, sendo totalmente destruída.


## Navegação entre activities

Um ponto importante sobre as activitys é saber como funciona o seu gerenciamento, que ocorre baseado no conceito
de computação chamado LIFO (last in first out) ou Pilha, em Português. Isso significa que a última

Quando uma nova Activity é iniciada, o sistema a coloca no topo da pilha de Activities do aplicativo.
Essa Activity se torna a Activity ativa - a Activity que o usuário pode interagir.
Quando o usuário pressiona o botão de voltar, a Activity atual é destruída e removida do topo da pilha,
fazendo com que a Activity anterior na pilha se torne a Activity ativa. Se o usuário continuar
pressionando o botão de voltar até que a pilha de Activities esteja vazia, o aplicativo é finalizado.

Nós usamos o método startActivity() para para abrir uma nova activity.
Esse método precisa receber uma Intent como parâmetro, que traduzindo ao pé da letra seria realmente 
uma intenção de resolver ou fazer algo.

<img src='./assets/navegacaometodo.png '>

O primeiro parâmetro corresponde a classe Intent que precisamos instanciar, que recebe um contexto,  
que é um ponto de acesso as informações globais do seu app e como segundo parâmetro recebe a classe
correspondente a tela que queremos navegar .


👉 Conceitos importantes sobre esse gerenciamento de Pilhas

- Task e Back Stack:
Uma task é um conjunto de activities,  qu eo usuário vai interagir para executar uma ação e cada tem
sua própria pilha de activities, as back stacks.

- Multi-tarefa: O android permite que o usuário navegue entre tarefas, na prática isso quer dizer que 
o usuário pode sair de um aplicativo para iniciar ou retornar a outro e em seguida, voltar ao
aplicativo original, retomando a partir de onde parou. 

- Gerenciamneto de estado:
Os estado das Activities devem ser gerenciados adequadamente ao navegar entre as Activies,
especialmente considerando que o sistema pode destruir Activities em segundo plano para recuperar recursos.


## Como ocorre o gerenciamento de estados em uma activity - salvando e restaurando esse estado

- O gerenciamento de estado em uma Activity no Android é crucial para preservar e restaurar o estado 
da interface do usuário quando ocorrem eventos como rotações de tela ou mudanças de configuração.
- Uma mudança na configuração (por exemplo, rotação do dispositivo) pode causar a destruição e 
reconstrução da Activity, o que requer o uso de métodos como onSaveInstanceState() para manter o estado.
- Para dados mais complexos ou persistentes, considere o uso de bancos de dados locais 
(como Room para SQLite) ou SharedPreferences.

Essas práticas ajudam a garantir uma experiência consistente para o usuário, preservando o estado da
interface do usuário mesmo quando ocorrem eventos que afetam a vida da Activity.


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

- Este método é chamado depois de onStart() quando existe um estado salvo para ser restaurado, 
mas não é amplamente usado porque a restauração geralmente é feita dentro de onCreate().

## Melhores práticas - Uso de Fragments para uma gestão flexível de UI

## Conclusão

## Informações gerais sobre o projeto

- Nós realizamos o básico necessário para visualizar alguns contextos abordados neste ReadMe
- Para observar o ciclo de vida das activities realizamos a sobrescrita dos métodos chamados nesse processo 
executando apenas Info logs.
- Podemos observar também a execução e declaração do método necessário para navegação entre activities.
- Você pode baixar e executar tranquilamente na sua máquina, verificando os pontos acima.


## Referências de estudo

1. [Curso Udemy]https://www.udemy.com/course/desenvolvimento-android-completo/
2. [O que é uma activity?]https://www.youtube.com/watch?v=9Y2KBJFZLZs
3. [ciclo de vida de uma activity]https://www.youtube.com/watch?v=dJ1U6MzEwKA
4. [imagem do ciclo de vida]https://pt.slideshare.net/slideshow/ciclo-de-vida-de-uma-activity/16390547
5. [Documnetação oficial android]https://developer.android.com/codelabs/basic-android-kotlin-compose-activity-lifecycle?hl=pt-br#0