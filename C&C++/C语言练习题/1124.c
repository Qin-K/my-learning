#include<stdio.h>
#include<string.h>

int main()
{
	char s[100];
	int len;
	int i;
	len = strlen(s);
	gets(s);
	for(i=0; i<len; i++)
	{
		if(s[i] >='A' && s[i] <= 'Z')
			s[i] = s[i] + 32;
	}
	puts(s);
	return 0;

}