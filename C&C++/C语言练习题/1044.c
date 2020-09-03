#include<stdio.h>
#include<string.h>
#define N 80

int main()
{
    int i, j;
    char str[4][N], s[N];
    gets(str[0]);
    gets(str[1]);
    gets(str[2]);
    for(i=0; i<3; i++)
        for(j = i+1; j<3; j++)
            if(strcmp(str[i], str[j]) > 0)
            {
                strcpy(s, str[i]);
                strcpy(str[i], str[j]);
                strcpy(str[j], s);
            }
    for(i=0; i<3; i++)
        printf("%s\n", str[i]);
    return 0;
}