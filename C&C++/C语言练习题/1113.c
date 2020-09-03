#include<stdio.h>
#include<string.h>

int main()
{
	char a[80], b[80];
	int len;
	int i, j;
	gets(a);
	len = strlen(a);
	for(i=0, j=0; i<len; i++)
	{
		if((a[i]>='a' && a[i]<='z') || (a[i]>='A' && a[i]<='Z'))
			b[j++] = a[i];
	}
	for(i=0; i<j; i++)
		printf("%c", b[i]);
	return 0;

}