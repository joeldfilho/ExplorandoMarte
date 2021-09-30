<b>1: Como executar</b>

Para executar esse serviço, o código deve ser baixado para a máquina, e em seguida, na pasta onde foi baixado e/ou descompactado, deve ser usado o comando <i>mvn install</i> a partir de um terminal de comando.

Assim as dependências serão baixadas e uma pasta <b>target</b> será criada.

Dentro dessa pasta estará o executável <b><i>.jar</b></i>

Pela linha de comando executar através do comando <i> java .jar </i>.

Isso irá subir a aplicação no ambiente local, utilizando por padrão do Tomcat a porta 8080.

É necessário um JDK 11 ou superior para compilar o programa.

<b>2: Como usar o endpoint</b>

Uma vez que a aplicação esteja rodando, seu endpoint estará disponível para consumo.

Foi criado apenas um endpoint para essa aplicação, que recebe os parâmetros de entrada e devolve a saída.


<b>POST <i>/explorar_marte</b></i>


Esse é o endpoint que irá atuar recebendo os dados sobre o plano e as sondas que devem ser criados e executará os 
códigos para que o movimento correto seja feito.

A entrada é em texto puro e deverá seguir o padrão:

1ª linha: dois números inteiros separados por espaço simples.

2ª linha e todas as linhas pares seguintes: Deverão conter as informações de localização inicial e direção inicial 
da sonda. São aceitos apenas números entre 0 e o tamanho máximo do plano, e as direções "N", "S", "E", "W".

3ª linha e todas as linhas ímpares seguintes: Deverão conter as informações de comandos que a sonda especificada na 
linha anterior deverá seguir.

A resposta desse endpoint será um texto simples também, contendo as informações de posição e direção final de cada 
sonda que foi enviada na entrada.

####Exemplo de entrada:
```
5 5
1 2 N
LMLMLMLMM
3 3 E
MMRMMRMRRM
```

#### Saída esperada:
```
1 3 N
5 1 E
```



---

Essa aplicação roda em memória, ela apenas executa as ações e não as guarda em nenhum banco de dados.
Alguns possíveis próximos passos para esse projeto seriam salvar cada planeta com um ID e as Sondas dentro dele em 
um banco, podendo assim revisitar um planeta já visitado, incluir validações para que duas sondas não ocupem o mesmo 
espaço ao mesmo tempo e uma marcação para cada ponto do plano visitado.