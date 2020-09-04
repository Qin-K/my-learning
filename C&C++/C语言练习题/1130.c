#include<stdio.h>
int main()
{
	char s[100];
	int i = 0, cnt = 0;
	gets(s);
	while (s[i]) {
		if((s[i]>='a' && s[i]<='z') || (s[i]>='A' && s[i]<='Z'))
			cnt++;
		i++;
	}
	printf("%d", cnt);
	getch();
} 
