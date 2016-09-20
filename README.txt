Para rodar o sistema SAR � necess�rio ter os seguintes requisitos:
1 - Criar na pasta raiz do sistema, um arquivo Config.txt.
2 - Criar na pasta raiz do sistema, um arquivo chamado Log.txt.
2 - O arquivo Config.txt deve conter em sua primeira linha, separados por espa�o, dois
numeros inteiros d (numero de blocos) com d >= 4 e b (tamanho do bloco de disco).
3 - Em cada linha subsequente pode-se adicionar chamadas de sistemas a serem
realizadas, tais como: cria, destroi, varre, escreve e le.
4 - Para realizar as chamadas deve-se seguir os seguintes padr�es:
* cria <nome do arquivo(texto)> <tamanho do arquivo(numero inteiro)>
* destroi <nome do arquivo(texto)>
* varre <nome do arquivo(texto)>
* escreve <nome do arquivo(texto)> <a partir dessa posi��o ser� escrito algo(numero
inteiro)> <texto a ser escrito(texto)>
* le <nome do arquivo(texto)> <a partir dessa posi��o ser� lido algo(numero
inteiro)> <quantidade de caracteres a serem lidos a partir da posi��o passada (numero
inteiro)>
5 - Salvar o arquivo Config com as devidas modifica��es realizadas, lembrando que
na primeira linha � feita a configura��o do disco e em cada linha subsequente poder�
ser escrita somente 1 chamada aonde a separa��o de cada argumento deve ser feita por
espa�o.
6 - Compilar o arquivo SAR.java da pasta main que est� na raiz e executa-lo
7 - As ocorr�ncias do sistema podem ser vistas com facilidade do arquivo Log.txt ap�s
a execu��o do programa.
