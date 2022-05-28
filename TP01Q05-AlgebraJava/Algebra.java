/****************************************
 * 
 * @author Barbara Luciano Araujo
 * Matricula: 748190
 * TP01 - Questão 5 - Álgebra booleana em Java
 * 
****************************************/

import javax.management.StringValueExp;

// ---------- Início class ----------
  public class Algebra {


    // ---------- método para tirar os espaços da expressão ----------

     public static String space(String s)
     {
        s = s.replace(" ", ""); // troca o espaço por nada -> tira o espaço

        return s;
     }

    // ---------------------------------------------------------------

    // ---------- método para trocar as letras A pelo valor delas ----------

     public static String changeA(String s, String value)
     {
        s = s.replace("A", value);

        return s;
     }

    // ---------------------------------------------------------------------

    // ---------- método para trocar as letras B pelo valor delas ----------

     public static String changeB(String s, String value)
     {
        s = s.replace("B", value);

        return s;
     }

    // ---------------------------------------------------------------------

    // ---------- método para trocar as letras C pelo valor delas ----------

     public static String changeC(String s, String value)
     {
        s = s.replace("C", value);

        return s;
     }

    // ---------------------------------------------------------------------

    // ---------- método para resolver as operações de not ----------

     public static String not(String s)
     {
        s = s.replace("not(0)", "1"); // se o valor for 0, ele passa a ser 1
        s = s.replace("not(1)", "0"); // se o valor for 1, ele passa a ser 0

        return s;
     }

    // --------------------------------------------------------------

    // ---------- método para saber qual é a última operação ----------

     public static String lastOperation(String s)
     {
        String answer = " ";
        int a = s.lastIndexOf("and"); // última ocorrência do and
        int o = s.lastIndexOf("or"); // última ocorrência do or
        int n = s.lastIndexOf("not"); // última ocorrência do not

        // --- condicional para saber qual operação é a última ---
         if (a > o && a > n) 
         {
            answer = "and";
         }
         else if (o > a && o > n) 
         {
            answer = "or";
         }
         else if (n > a && n > o) 
         {
            answer = "not";
         }
        // -------------------------------------------------------

        return answer;
     } 

    // --------------------------------------------------------------

    // ---------- método para resolver as operações de and ----------

     public static String and(String s)
     {
        String and = " ";
        int a = s.lastIndexOf("and"); // última ocorrência da operação
        int bracket = s.indexOf(")", a); // primeiro ')' após o 'and'
        int resp = 1; // variável da resposta

        and = s.substring(a, bracket+1); // string será apenas a operação 'and' a ser resolvida

        // --- for loop para verificar se há o valor 0 na expressão ---

        for (int i = 0; i < and.length(); i++)
        {
            if (and.charAt(i) == '0') 
            {
                resp = 0;
            }
        }

        // ------------------------------------------------------------

        s = s.replace(and, String.valueOf(resp)); // substitui a operação pela resposta

       return s;
     }

    // --------------------------------------------------------------

    // ---------- método para resolver as operações de or ----------

     public static String or(String s)
     {
       String or = " ";
       int o = s.lastIndexOf("or"); // última ocorrência da operação
       int bracket = s.indexOf(")", o); // primeiro ')' após o 'or'
       int resp = 0; // variável da resposta

       or = s.substring(o, bracket+1); // string será apenas a operação 'or' a ser resolvida

       // --- for loop para verificar se há o valor 0 na expressão ---

       for (int i = 0; i < or.length(); i++)
       {
           if (or.charAt(i) == '1') 
           {
            resp = 1;
           }
       }

       // ------------------------------------------------------------

       s = s.replace(or, String.valueOf(resp)); // substitui a operação pela resposta

      return s;
     }

   // --------------------------------------------------------------




    // ---------- main ----------
     public static void main(String[] args) {

        // ----- inicialização das variáveis -----
         String expression = " ";
         String resposta = " ";
         int numeros = 0;
         numeros = MyIO.readInt();
        // ----------------------------------------

        // ---------- while loop para chamar a função que resolve a expressão ----------
         while (true) 
         {
            // --- condição de parada ---

             if (numeros == 0) 
             {
                break;
             }

            // --------------------------

            int valores[] = new int[numeros]; // array para guardar os valores das 'variáveis' A, B e C

            // --- for loop para ler todos os números da entrada ---
             for (int j = 0; j < numeros; j++)
             {
                valores[j] = MyIO.readInt();
             }
            // -----------------------------------------------------

            expression = MyIO.readLine();
            expression = space(expression); // tirando os espaços da expressão 

            // --- condicional para saber a quantidade de 'variáveis' da expressão (1, 2 ou 3) ---

             if (numeros == 1)
             {
                expression = changeA(expression, String.valueOf(valores[0])); // substituindo as 'variáveis' A pelo valor da entrada
             }
             else if (numeros == 2)
             {
                expression = changeA(expression, String.valueOf(valores[0])); // substituindo as 'variáveis' A pelo valor da entrada
                expression = changeB(expression, String.valueOf(valores[1])); // substituindo as 'variáveis' B pelo valor da entrada
             }
             else if (numeros == 3)
             {
                expression = changeA(expression, String.valueOf(valores[0])); // substituindo as 'variáveis' A pelo valor da entrada
                expression = changeB(expression, String.valueOf(valores[1])); // substituindo as 'variáveis' B pelo valor da entrada
                expression = changeC(expression, String.valueOf(valores[2])); // substituindo as 'variáveis' C pelo valor da entrada
             }

            // -----------------------------------------------------------------------------------

            // --- ordem da resolução das expressões ---

             // - not (não depende da posição) -
             expression = not(expression);

             // - última para primeira -
             while (expression.length() > 1)
             {
                 String last = lastOperation(expression);

                 if (last == "not") 
                 {
                    expression = not(expression);
                 }
                 else if (last == "and") 
                 {
                    expression = and(expression);
                 }
                 else if (last == "or") 
                 {
                    expression = or(expression);
                 }
             }

            // -----------------------------------------

            resposta = expression;

            MyIO.println(resposta); // imprimir na saída o resultado final

            numeros = MyIO.readInt();
            
         }
        // ---------------------------------------------------------------------------
        
     }

    // ---------------------------
 }
// ---------- FIM ----------