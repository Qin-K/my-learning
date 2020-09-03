#include<stdio.h>
#include<string.h>
int main()
{
	int i;
	char s[10];
	char ch[]={'h','e','l','l','o'};
	gets(s);
	puts(s);
	for(i=0;ch[i]!='\0';i++)
		printf("%c",ch[i]);

}