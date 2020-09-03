#include<stdio.h>

int main()
{
	double s = 100;
	double k = 100;
	int N;
	int i;
	scanf("%d", &N);
	for(i=1; i<N; i++)
	{
		s += k;
		k = k/2;
	}
	printf("%.4lf", s);
	getch();
	return 0;
	
} 
