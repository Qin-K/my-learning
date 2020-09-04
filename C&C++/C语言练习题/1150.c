#include<stdio.h>

int main()
{
	int i;
	int n;
	double sum = 0;
	scanf("%d", &n);
	for(i=1; i<=n; i++)
	{
		sum = sum + 1.0/i;
	}
	printf("%.6f", sum);
	getch();
}
