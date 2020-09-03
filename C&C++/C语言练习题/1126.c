#include<stdio.h>
#include<string.h>

int main()
{
	char s[100], t[50];
	int len;
	int i, j;
	gets(s);
	len = strlen(s);
	for(i=len-1, j=0; i>=0; i--)
	{
		t[j++] = s[i];
	}
	strcat(s, t);
	printf("%s", s);
	getchar();
}
