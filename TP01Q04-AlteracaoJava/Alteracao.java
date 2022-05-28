import java.util.Random;

/****************************************
 * 
 * @author Barbara Luciano Araujo
 * Matricula: 748190
 * TP01 - Questão 4 - Alteração Aleatória em Java
 * 
****************************************/

 // ---------- Início class ----------
 public class Alteracao {

    // ---------- método para saber se a entrada chegou ao fim, com a palavra FIM ----------

    public static boolean isFim(String s) {
        return (s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
    }

    // --------------------------------------------------------------------------------------


    // ---------- método para alterar uma letra aleatória por outra ----------

    public static String aleatorio (String s)
    {
        int tam = s.length(); // tamanho da string

        for (int i = 0; i < tam; i++) // for para percorrer todos os elementos da string
        {
            // --- inicializando variáveis para a escolha aleatória ---
            Random gerador = new Random();
            gerador.setSeed(4);
            char random1, random2;
            // --------------------------------------------------------

            // --- escolha aleatória das duas letras ---

            random1 = ((char) ('a' + (Math.abs(gerador.nextInt()) % 26)));

            random2 = ((char) ('a' + (Math.abs(gerador.nextInt()) % 26)));

            // -----------------------------------------

            s = s.replace(random1, random2); // substituindo a 1° letra escolhida pela 2°
        }

        return s; // retornar a string alterada
    }

    // --------------------------------------------------------------------------------------



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


        // ---------- for loop para chamar a função que altera a string ----------
        for (int i = 0; i < qtd; i++) 
        {
            MyIO.println(s[i]); // imprimir na saída
        }
        // ---------------------------------------------------------------------------------
        
    }

    // ---------------------------
}
 // ---------- FIM ----------