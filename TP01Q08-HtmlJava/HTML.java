
/****************************************
 * 
 * @author Barbara Luciano Araujo
 * Matricula: 748190
 * TP01 - Questão 8 - Leitura de Página HTML em Java
 * 
****************************************/

import java.io.*;
import java.net.*;

// ---------- Início class ----------
public class HTML {

    // ---------- método para saber se a entrada chegou ao fim, com a palavra FIM
    // ----------

    public static boolean isFim(String s) {
        return (s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
    }

    // --------------------------------------------------------------------------------------

    public static String getHtml(String address) {
        URL url;
        InputStream is = null;
        BufferedReader br;
        String resp = "", line;

        try {
            url = new URL(address);
            is = url.openStream();
            br = new BufferedReader(new InputStreamReader(is));

            while ((line = br.readLine()) != null) {
                resp += line + "\n";
            }
        } catch (MalformedURLException mue) {
            mue.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        try {
            is.close();
        } catch (IOException ioe) {
            // nada
        }

        return resp;
    }

    // ---------- main ----------
    public static void main(String[] args) {

        MyIO.setCharset("UTF-8");

        // ----- inicialização das variáveis -----
        String endereco;
        String HTML;
        String nome;
        // ----------------------------------------

        // ---------- repetição do while para ler todas as linhas da entrada até chegar
        // na palavra FIM ----------

        /*
         * do {
         * s[qtd] = MyIO.readLine();
         * nome = MyIO.readLine();
         * } while (isFim(s[qtd++]) == false);
         * 
         */

        // ------------------------------------------------------------------------------------------------------

        nome = MyIO.readLine();
        endereco = MyIO.readLine();
        HTML = getHtml(endereco);

        while (true) {

            if (isFim(nome) == true) {
                break;
            }

            String resp1 = HTML;

            int qtdA = 0, qtdE = 0, qtdI = 0, qtdO = 0, qtdU = 0, qtdÁ = 0, qtdÉ = 0, qtdÍ = 0, qtdÓ = 0, qtdÚ = 0,
                    qtdÀ = 0, qtdÈ = 0, qtdÌ = 0, qtdÒ = 0, qtdÙ = 0, qtdÃ = 0, qtdÕ = 0, qtdÂ = 0, qtdÊ = 0,
                    qtdÎ = 0,
                    qtdÔ = 0, qtdÛ = 0, qtdConsoantes = 0, qtdBR = 0, qtdTABLE = 0;

            // ---------- for loop para chamar a função que verifica se é palindromo
            // ----------
            for (int j = 0; j < HTML.length(); j++) {

                // String resp2 = "";

                if (resp1.charAt(j) == 'a')
                    qtdA++;
                else if (resp1.charAt(j) == 'e')
                    qtdE++;
                else if (resp1.charAt(j) == 'i')
                    qtdI++;
                else if (resp1.charAt(j) == 'o')
                    qtdO++;
                else if (resp1.charAt(j) == 'u')
                    qtdU++;

                else if (resp1.charAt(j) == 'á')
                    qtdÁ++;
                else if (resp1.charAt(j) == 'é')
                    qtdÉ++;
                else if (resp1.charAt(j) == 'í')
                    qtdÍ++;
                else if (resp1.charAt(j) == 'ó')
                    qtdÓ++;
                else if (resp1.charAt(j) == 'ú')
                    qtdÚ++;

                else if (resp1.charAt(j) == 'à')
                    qtdÀ++;
                else if (resp1.charAt(j) == 'è')
                    qtdÈ++;
                else if (resp1.charAt(j) == 'ì')
                    qtdÌ++;
                else if (resp1.charAt(j) == 'ò')
                    qtdÒ++;
                else if (resp1.charAt(j) == 'ù')
                    qtdÙ++;

                else if (resp1.charAt(j) == 'ã')
                    qtdÃ++;
                else if (resp1.charAt(j) == 'õ')
                    qtdÕ++;

                else if (resp1.charAt(j) == 'â')
                    qtdÂ++;
                else if (resp1.charAt(j) == 'ê')
                    qtdÊ++;
                else if (resp1.charAt(j) == 'ê')
                    qtdÎ++;
                else if (resp1.charAt(j) == 'ô')
                    qtdÔ++;
                else if (resp1.charAt(j) == 'û')
                    qtdÛ++;

                else if (resp1.charAt(j) == 'b' || resp1.charAt(j) == 'c' || resp1.charAt(j) == 'd'
                        || resp1.charAt(j) == 'f' || resp1.charAt(j) == 'g' || resp1.charAt(j) == 'h'
                        || resp1.charAt(j) == 'j' || resp1.charAt(j) == 'k' || resp1.charAt(j) == 'l'
                        || resp1.charAt(j) == 'm' || resp1.charAt(j) == 'n' || resp1.charAt(j) == 'p'
                        || resp1.charAt(j) == 'q' || resp1.charAt(j) == 'r' || resp1.charAt(j) == 's'
                        || resp1.charAt(j) == 't' || resp1.charAt(j) == 'v' || resp1.charAt(j) == 'w'
                        || resp1.charAt(j) == 'x' || resp1.charAt(j) == 'y' || resp1.charAt(j) == 'z')
                    qtdConsoantes++;

                else if (resp1.charAt(j) == '<' && resp1.charAt(j + 1) == 'b' && resp1.charAt(j + 2) == 'r'
                        && resp1.charAt(j + 3) == '>')
                    qtdBR++;

                else if (resp1.charAt(j) == '<' && resp1.charAt(j + 1) == 't' && resp1.charAt(j + 2) == 'a'
                        && resp1.charAt(j + 3) == 'b' && resp1.charAt(j + 4) == 'l' && resp1.charAt(j + 5) == 'e'
                        && resp1.charAt(j + 6) == '>')
                    qtdTABLE++;

                // resp2 = nome;

            }

            qtdA -= qtdTABLE;
            qtdE -= qtdTABLE;
            qtdConsoantes -= 3 * (qtdTABLE);
            qtdConsoantes -= 2 * (qtdBR);

            MyIO.print("a(" + qtdA + ") ");
            MyIO.print("e(" + qtdE + ") ");
            MyIO.print("i(" + qtdI + ") ");
            MyIO.print("o(" + qtdO + ") ");
            MyIO.print("u(" + qtdU + ") ");

            MyIO.print("á(" + qtdÁ + ") ");
            MyIO.print("é(" + qtdÉ + ") ");
            MyIO.print("í(" + qtdÍ + ") ");
            MyIO.print("ó(" + qtdÓ + ") ");
            MyIO.print("ú(" + qtdÚ + ") ");

            MyIO.print("à(" + qtdÀ + ") ");
            MyIO.print("è(" + qtdÈ + ") ");
            MyIO.print("ì(" + qtdÌ + ") ");
            MyIO.print("ò(" + qtdÒ + ") ");
            MyIO.print("ù(" + qtdÙ + ") ");

            MyIO.print("ã(" + qtdÃ + ") ");
            MyIO.print("õ(" + qtdÕ + ") ");

            MyIO.print("â(" + qtdÂ + ") ");
            MyIO.print("ê(" + qtdÊ + ") ");
            MyIO.print("î(" + qtdÎ + ") ");
            MyIO.print("ô(" + qtdÔ + ") ");
            MyIO.print("û(" + qtdÛ + ") ");

            MyIO.print("consoante(" + qtdConsoantes + ") ");

            MyIO.print("<br>(" + qtdBR + ") ");

            MyIO.print("<table>(" + qtdTABLE + ") ");

            MyIO.println(nome);

            nome = MyIO.readLine();

            if (isFim(nome) == true) {
                break;
            }

            endereco = MyIO.readLine();
            HTML = getHtml(endereco);

        }

        // ---------------------------------------------------------------------------------

    }

}

// ---------------------------

// ---------- FIM ----------