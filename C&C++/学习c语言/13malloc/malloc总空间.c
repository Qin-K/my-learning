#include<stdio.h>
#include<stdlib.h>

int main(void)
{
	int *p;
	int cnt = 0;
	while (p = malloc (1024*1024))
	{
		cnt++;
	}
	printf("һ��������%dM", cnt);
	getch();
	return 0;
}
