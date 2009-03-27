Projecto de PPROG
=================

A. Enunciado
------------

Construa uma aplicação de gestão de um Sistema de Mensagens de Texto. O
objectivo da aplicação é permitir a troca de mensagens de texto entre os utilizadores
registados no sistema. Cada utilizador deve possuir uma caixa de mensagens onde são
guardadas as mensagens recebidas.
A aplicação deve permitir, entre outras funcionalidades, as seguintes:  
+ Registo de utilizadores. O utilizador indica o username pretendido, e se ainda
não está atribuído, a aplicação gera aleatoriamente uma password de 4
caracteres.  
+ Autenticação de utilizadores através de username e password. As operações
descritas a seguir só podem ser realizadas por utilizadores autenticados.  
+ Listagem dos utilizadores do sistema.  
+ Envio de uma mensagem de um utilizador para outro utilizador, para vários
utilizadores ou para todos os utilizadores do sistema.  
+ Listagem das mensagens recebidas.  
+ Leitura das mensagens recebidas.  
+ Remoção de mensagem ou mensagens recebidas.

__notas__  
1. O programa deve recusar informações incoerentes, impondo ao utilizador a
devida correcção, informando-o explicitamente do problema.  
2. No desenvolvimento da aplicação tome especial cuidado com a utilização
dos quatro princípios da Programação Orientada a Objectos: Abstracção,
Encapsulamento, Herança e Polimorfismo.

B. Entrega
----------

Este trabalho deve ser efectuado individualmente ou em grupo (máximo 2 alunos) e
entregue através do Moodle em duas fases:  
􀂃 A 1.ª parte consistindo numa aplicação com interface em modo de texto, sem
ficheiros para guardar dados. Sempre que a aplicação é inicializada é necessário
criar utilizadores. Quando termina perdem-se todos os dados.

Note que as classes devem compilar e a sua interacção tem que estar correcta.
Para testar as funcionalidades dos objectos das classes e interacções com
objectos de outras classes construa uma classe “Teste” contendo apenas o
método “main” no qual, sem menus, executa uma demonstração da aplicação
correspondente a uma sessão de utilização.

O programa, acompanhado por um pequeno relatório destinado a facilitar a
compreensão da solução apresentada, deve ser entregue até às 23h59m do dia 4
de Abril de 2009.

􀂃 A 2.ª parte deverá ser constituída por uma qualquer das seguintes alternativas:

a) Duas versões da aplicação correspondentes a dois modos de interacção com
o utilizador: modo de texto e modo gráfico.

Cada versão da aplicação deverá ser constituída por duas camadas distintas e
a desenvolver em separado: A camada de “Interface com o Utilizador” e a
camada de “Sistema de Mensagens”. Em nenhuma parte da camada “Sistema
de Mensagens” deverá existir interacção com o exterior que não seja através
de métodos e parâmetros. A camada de “Sistema de Mensagens”, deverá ser
comum às 2 versões (modo de texto e modo gráfico), e implementada
através de uma class library.

As aplicações devem permitir a continuação da sua execução numa sessão
diferente usando ficheiros para armazenar o estado.

b) Uma aplicação Cliente Servidor. A aplicação cliente possuirá uma interface
gráfica para a interacção do utilizador. O servidor conterá as caixas de
correio e permitirá a troca de mensagens entre os utilizadores. Todas as
comunicações entre os clientes e o servidor serão efectuadas por meio de
sockets.

A aplicação deve permitir a continuação da sua execução numa sessão
diferente usando ficheiros para armazenar o estado.
O programa deve ser entregue até às 23h59 do dia 17 de Maio de 2009.
O Relatório Final correspondente à 2.ª parte deve conter:  
+ Identificação (do autor ou autores).  
+ Objectivo (do trabalho).  
+ Estrutura do programa: divisão em módulos e inter-relações entre os diversos
módulos que constituem o programa; descrição resumida das classes e
serviços que a classe realiza para os seus clientes e justificação da escolha da
estrutura e serviços.  
+ Ambiente de desenvolvimento: máquina, sistema operativo e compilador.  
+ Resultados da execução do programa: sequência de saídas produzidas numa
sessão de utilização do programa.  
+ Conclusões.  
+ Melhoramentos (opcional): que funcionalidades adicionais deveria ter ou
como poderia aumentar a eficiência do programa.  
+ Manual do utilizador: Funcionalidades (conjunto de tarefas) que o programa
disponibiliza, sequência correcta de operações para utilizar o programa para
todas as funcionalidades disponibilizadas, justificação de erros que o
programa possa informar o utilizador.

A Apresentação será efectuada na última semana de actividades lectivas do 2.º
Semestre, em data a combinar com o professor da turma prática.