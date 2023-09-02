#include <stdio.h>
#include <string.h>

char encrypt(char c);
int key, gapLetters = 26;

int main(void)
{
   char stringInput[100];

   //Recebe a string
   printf("stringInput: ");
   scanf("%[^\n]", stringInput);

   //Verifica se é positivo
   do
   {
    printf("\nKey: ");
    scanf("%d", &key);
   } while(key < 0);

   //Tratamento da key
   if(key > gapLetters){
        key = key % gapLetters;
   }

   // Itera cada char da string
   for(int i = 0; stringInput[i] != '\0'; i++){
    stringInput[i] = encrypt(stringInput[i]);
    //imprime o char atual criptografado
    printf("%c", stringInput[i]);
   }
}

char encrypt(char charAtual){
 //filtro para minuscula
    if(charAtual > 96 && charAtual < 123)
    {
      charAtual -= key;
          if(charAtual < 97)
          {
              charAtual += gapLetters;
          }
          else if(charAtual > 122)
          {
              charAtual -= gapLetters;
          }
    }
    //filtro para maiuscula
    else if(charAtual > 64 && charAtual < 91)
      {
      charAtual -= key;
          if(charAtual < 65)
          {
              charAtual += gapLetters;
          }
         else if(charAtual > 90)
          {
              charAtual -= gapLetters;
          }
    }
}

