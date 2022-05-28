/****************************************
 * 
 * @author Barbara Luciano Araujo
 * Matricula: 748190
 * TP01 - Questão 1 - Palíndromo em Java
 * 
****************************************/

 // ---------- Início class ----------
 public class PalindromoJ {

    // ---------- método para saber se a entrada chegou ao fim, com a palavra FIM ----------

    public static boolean isFim(String s) {
        return (s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
    }

    // --------------------------------------------------------------------------------------



    // ---------- método para saber se a palavra/frase é palindromo ----------

    public static boolean EhPalindromo(String word[]) { // recebe a string da linha lida como parâmetro
        
        // ----- inicialização das variáveis -----
        boolean resp = false;
        String inv[] = new String[1000];
        String aux[] = new String[1000];
        int tam = word.length;
        // ---------------------------------------


        // ----- copiando a string em uma outra auxiliar -----

        for (int i = 0; i < tam; i++)
        {
            aux[i] = word[i];
        }

        // ---------------------------------------------


        // ----- invertendo a string em uma outra -----

        for (int i = 0; i < tam; i++)
        {
            int dif = tam - i - 1;
            inv[i] = aux[dif];
        }

        // ---------------------------------------------

        // ----- conferindo se as string são iguais -----

        for (int j = 0; j < tam/2; j++)
        {
            if (word[j] == inv[j]) resp = true;
        }

        // ----------------------------------------------

        return resp;

    }

    // -----------------------------------------------------------------------



    // ---------- main ----------
    public static void main(String[] args) {

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
            boolean resposta = EhPalindromo(s);// função retorna um booleano, então é guardada em uma variável do tipo booleana

            // ---------- condicional para saber se o método retornou true ou false ----------
            if (resposta == true)
                MyIO.println("SIM");
            else
                MyIO.println("NAO");
            // --------------------------------------------------------------------------------
        }
        // ---------------------------------------------------------------------------------
        
    }

    // ---------------------------
}
 // ---------- FIM ----------