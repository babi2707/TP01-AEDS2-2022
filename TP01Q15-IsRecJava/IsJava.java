/****************************************
 * 
 * @author Barbara Luciano Araujo
 *         Matricula: 748190
 *         TP01 - Questão 6 - Is em Java
 * 
 ****************************************/

// ---------- Início class ----------
public class IsJava {

    // ---------- método para saber se a entrada chegou ao fim, com a palavra FIM ----------

    public static boolean isFim(String s) {
        return (s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
    }

    // --------------------------------------------------------------------------------------

    // ---------- método para verificar se a string possui somente vogais ----------

    public static boolean isVogal(String s) {
        boolean resp = false;
        int tam = s.length();
        int qtdVogais = 0;

        for (int i = 0; i < tam; i++) {
            if (s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'i' || s.charAt(i) == 'o'
                    || s.charAt(i) == 'u' || s.charAt(i) == 'A' || s.charAt(i) == 'E' || s.charAt(i) == 'I'
                    || s.charAt(i) == 'O' || s.charAt(i) == 'U') {
                qtdVogais++;
            }
        }

        if (qtdVogais == tam)
            resp = true;

        return resp;
    }

    // -----------------------------------------------------------------------------

    // ---------- método para verificar se a string possui somente consoantes ----------

    public static boolean isConsoante(String s) {
        boolean resp = false;
        int tam = s.length();
        int qtdConsoantes = 0;

        for (int i = 0; i < tam; i++) {
            if (((s.charAt(i) <= 'a' && s.charAt(i) >= 'z') || (s.charAt(i) <= 'A' && s.charAt(i) >= 'Z'))
                    && (!(s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'i' || s.charAt(i) == 'o'
                            || s.charAt(i) == 'u' || s.charAt(i) == 'A' || s.charAt(i) == 'E' || s.charAt(i) == 'I'
                            || s.charAt(i) == 'O' || s.charAt(i) == 'U'))) {
                qtdConsoantes++;
            }
        }

        if (qtdConsoantes == tam)
            resp = true;

        return resp;
    }

    // -----------------------------------------------------------------------------

    // ---------- método para verificar se a string é um número inteiro ----------

    public static boolean isInt(String s) {
        boolean resp = false;
        int tam = s.length();
        int qtdInt = 0;

        for (int i = 0; i < tam; i++) {
            if (s.charAt(i) <= 48 && s.charAt(i) >= 57)
                qtdInt++;
        }

        if (qtdInt == tam)
            resp = true;

        return resp;
    }

    // -----------------------------------------------------------------------------

    // ---------- método para verificar se a string é um número real ----------

    public static boolean isReal(String s) {
        boolean resp = false;
        int tam = s.length();
        int ponto = 0, num = 0;

        for (int i = 0; i < tam; i++) {
            if (s.charAt(i) == '.') ponto++;
            else if (s.charAt(i) <= 48 && s.charAt(i) >= 57) num++;
        }

        if (ponto + num == tam) resp = true;
        else resp = false;

        return resp;
    }

    // -----------------------------------------------------------------------------

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

        // ---------- for loop para chamar as funções ----------
        for (int i = 0; i < qtd; i++) {
            boolean r1 = isVogal(s[i]), r2 = isConsoante(s[i]), r3 = isInt(s[i]), r4 = isReal(s[i]);

            if (r1 == true) MyIO.print("SIM ");
            else MyIO.print("NAO ");

            if (r2 == true) MyIO.print("SIM ");
            else MyIO.print("NAO ");

            if (r3 == true) MyIO.print("SIM ");
            else MyIO.print("NAO ");

            if (r4 == true) MyIO.println("SIM");
            else MyIO.println("NAO");

        }
        // ---------------------------------------------------------------------------------

    }

    // ---------------------------
}
// ---------- FIM ----------