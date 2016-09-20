Para rodar o sistema SAR é necessário ter os seguintes requisitos:
1 - Criar na pasta raiz do sistema, um arquivo Config.txt.
2 - Criar na pasta raiz do sistema, um arquivo chamado Log.txt.
2 - O arquivo Config.txt deve conter em sua primeira linha, separados por espaço, dois
numeros inteiros d (numero de blocos) com d >= 4 e b (tamanho do bloco de disco).
3 - Em cada linha subsequente pode-se adicionar chamadas de sistemas a serem
realizadas, tais como: cria, destroi, varre, escreve e le.
4 - Para realizar as chamadas deve-se seguir os seguintes padrões:
* cria <nome do arquivo(texto)> <tamanho do arquivo(numero inteiro)>
* destroi <nome do arquivo(texto)>
* varre <nome do arquivo(texto)>
* escreve <nome do arquivo(texto)> <a partir dessa posição será escrito algo(numero
inteiro)> <texto a ser escrito(texto)>
* le <nome do arquivo(texto)> <a partir dessa posição será lido algo(numero
inteiro)> <quantidade de caracteres a serem lidos a partir da posição passada (numero
inteiro)>
5 - Salvar o arquivo Config com as devidas modificações realizadas, lembrando que
na primeira linha é feita a configuração do disco e em cada linha subsequente poderá
ser escrita somente 1 chamada aonde a separação de cada argumento deve ser feita por
espaço.
6 - Compilar o arquivo SAR.java da pasta main que está na raiz e executa-lo
7 - As ocorrências do sistema podem ser vistas com facilidade do arquivo Log.txt após
a execução do programa.
