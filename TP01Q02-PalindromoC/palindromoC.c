/****************************************
 * 
 * @author Barbara Luciano Araujo
 * Matricula: 748190
 * TP01 - Questão 2 - Palíndromo em C
 * 
****************************************/

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <locale.h>
#include <stdbool.h>

// ---------- método para saber se a entrada chegou ao fim ----------

bool isFim(char* string)
{
    return (strlen(string) == 3 && string[0] == 'F' && string[1] == 'I' && string[2] == 'M');
}

// ------------------------------------------------------------------

// ---------- método para verificar se é ou não palíndromo ----------

bool palind(char* word)
{
    // ----- inicialização das variáveis ----- 
    bool resp = false;
    char inv[500], aux[500];
    int valor = 0;
    // ---------------------------------------

    strcpy(inv, word);

    int tam = strlen(inv);
    int dif;

    for (int j = 0; j < tam; j++)
    {
        dif = (tam - j - 1);
        aux[j] = inv[dif];
    }

    for (int j = 0; j < tam; j++)
    {
        inv[j] = aux[j];
    }

    valor = strcmp(inv, word);

    if (valor == 0)
    {
        resp = true;
    }

    return resp;
}

// ------------------------------------------------------------------

int main()
{
    setlocale(LC_ALL, "portuguese-brazilian"); // colocar em português

    // ---------- iniciaçizando as variáveis ----------

    char palavra[500];

    // ------------------------------------------------

    // ---------- do/while para ler o arquivo de entrada ----------

    while (isFim(palavra) == false)
    {

        fflush(stdin); 
        scanf(" %[^\n]s", palavra); // pegando a entrada

        bool answer = palind(palavra); // chamando a função
        
        // ----- condicional para imprimir sim se for palindromo e não se não for -----
        if (answer == true)
        {
            printf("SIM\n");
        }

        else
        {
            if (isFim(palavra)==true) {
                break;
            }
            else {
                printf("NAO\n");
            }
        }
        // ----------------------------------------------------------------------------

    } 

    // ------------------------------------------------------------

    return 0;
}