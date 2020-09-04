#include<stdio.h>

int main()
{
	double t = 1;
	int m;
	int i;
	scanf("%d", &m);
	for(i=2; i<=m; i++)
	{
		t = t-1.0/(i*i);
	}
	printf("%.6f",t);
	getch();
	
}
