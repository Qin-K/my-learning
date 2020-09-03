#include<stdio.h>

int main()
{
	int a[10][10];
	int N;
	int i, j;
	int sum = 0;
	scanf("%d", &N);
	for(i=0; i<N; i++)
		for(j=0; j<N; j++)
		{
			scanf("%d", &a[i][j]);
		}
	for(i=0; i<N; i++)
		for(j=0; j<N; j++)
		{
			if(i==j || i+j+1==N)
			{
				sum += a[i][j];
			}
		}
	printf("%d", sum);
	getch();
	return 0;
}
