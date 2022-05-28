/****************************************
 *
 * @author Barbara Luciano Araujo
 *         Matricula: 748190
 *         TP01 - Questão 6 - Is em Java
 *
 ****************************************/

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <locale.h>
#include <stdbool.h>

// ---------- método para saber se a entrada chegou ao fim ----------

bool isFim(char *string)
{
    return (strlen(string) == 3 && string[0] == 'F' && string[1] == 'I' && string[2] == 'M');
}

// ------------------------------------------------------------------

// ---------- método para verificar se a string possui somente vogais ----------

bool isVogal(char *s)
{
    bool resp = false;
    int tam = strlen(s);
    int qtdVogais = 0;

    for (int i = 0; i < tam; i++)
    {
        if (s[i] == 'a' || s[i] == 'e' || s[i] == 'i' || s[i] == 'o' || s[i] == 'u' || s[i] == 'A' || s[i] == 'E' || s[i] == 'I' || s[i] == 'O' || s[i] == 'U')
        {
            qtdVogais++;
        }
    }

    if (qtdVogais == tam)
        resp = true;

    return resp;
}

// -----------------------------------------------------------------------------

// ---------- método para verificar se a string possui somente consoantes ----------

bool isConsoante(char *s)
{
    bool resp = false;
    int tam = strlen(s);
    int qtdConsoantes = 0;

    for (int i = 0; i < tam; i++)
    {
        if (((s[i] <= 'a' && s[i] >= 'z') || (s[i] <= 'A' && s[i] >= 'Z')) && (!(s[i] == 'a' || s[i] == 'e' || s[i] == 'i' || s[i] == 'o' || s[i] == 'u' || s[i] == 'A' || s[i] == 'E' || s[i] == 'I' || s[i] == 'O' || s[i] == 'U')))
        {
            qtdConsoantes++;
        }
    }

    if (qtdConsoantes == tam)
        resp = true;

    return resp;
}

// -----------------------------------------------------------------------------

// ---------- método para verificar se a string é um número inteiro ----------

bool isInt(char *s)
{
    bool resp = false;
    int tam = strlen(s);
    int qtdInt = 0;

    for (int i = 0; i < tam; i++)
    {
        if (s[i] <= 48 && s[i] >= 57)
            qtdInt++;
    }

    if (qtdInt == tam)
        resp = true;

    return resp;
}

// -----------------------------------------------------------------------------

// ---------- método para verificar se a string é um número real ----------

bool isReal(char *s)
{
    bool resp = false;
    int tam = strlen(s);
    int ponto = 0, num = 0;

    for (int i = 0; i < tam; i++)
    {
        if (s[i] == '.')
            ponto++;
        else if (s[i] <= 48 && s[i] >= 57)
            num++;
    }

    if (ponto + num == tam)
        resp = true;
    else
        resp = false;

    return resp;
}

// -----------------------------------------------------------------------------

int main()
{
    setlocale(LC_ALL, "portuguese-brazilian"); // colocar em português

    // ---------- iniciaçizando as variáveis ----------

    char entrada[1000];

    // ------------------------------------------------

    // ---------- do/while para ler o arquivo de entrada ----------

    while (true)
    {
        if (isFim(entrada) == true)
        {
            break;
        }

        fflush(stdin);
        scanf("%[^\n]s", entrada); // pegando a entrada

        bool r1 = isVogal(entrada), r2 = isConsoante(entrada), r3 = isInt(entrada), r4 = isReal(entrada);

        if (r1 == true)
        {
            printf("SIM ");
        }

        else
        {
            printf("NAO ");
        }

        if (r2 == true)
        {
            printf("SIM ");
        }

        else
        {
            printf("NAO ");
        }

        if (r3 == true)
        {
            printf("SIM ");
        }

        else
        {
            printf("NAO ");
        }

        if (r4 == true)
        {
            printf("SIM\n");
        }

        else
        {
            printf("NAO\n");
        }

        scanf(" %[^\n]s", entrada); // pegando a entrada
        
    }

    // ------------------------------------------------------------

    return 0;
}