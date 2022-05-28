/****************************************
 * 
 * @author Barbara Luciano Araujo
 * Matricula: 748190
 * TP01 - Questão 3 - Ciframento de César em Java
 * 
****************************************/

class Cifra {

    public static boolean isFim(String x)
    {
        return (x.length() == 3 && x.charAt(0) == 'F' && x.charAt(1) == 'I' && x.charAt(2) == 'M');
    }

    public static String ciframento(String s)
    {
        int tam = s.length();
        char[] letra = s.toCharArray();

        for (int i = 0; i < tam; i++)
        {
            letra[i] += 3;            
        }

        return String.valueOf(letra);

    }
    public static void main (String[] args) {

        // ----- inicialização das variáveis -----
        String[] s = new String[1000];
        int qtd = 0;
        // ----------------------------------------


        // ---------- repetição do while para ler todas as linhas da entrada até chegar na palavra FIM ----------

        do {
            s[qtd] = MyIO.readLine();
        } while (isFim(s[qtd++]) == false);

        // ------------------------------------------------------------------------------------------------------


        qtd--; // diminuir a quantidade de elementos da string em cada linha lida


        // ---------- for loop para chamar a função que verifica se é palindromo ----------
        for (int i = 0; i < qtd; i++) {
            String resposta = ciframento(s[i]);// função retorna um booleano, então é guardada em uma variável do tipo booleana

            MyIO.println(resposta);
        }
        // ---------------------------------------------------------------------------------
        

    }
}