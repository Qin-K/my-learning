#include<stdio.h>

int main()
{
	int i;
	int a[10];
	int n = 0;
	double s = 0, av;
	for (i=0; i<10; i++)
	{
		scanf("%d", &a[i]);
	}
	for (i=0; i<10; i++)
	{
		s = s + a[i];
	}
	av = s/10;
	for (i=0; i<10; i++)
	{
		if (a[i] > av)
			n++;
	}
	printf("%d", n);
	return 0;
}