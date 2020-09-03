#include<stdio.h>

int main()
{
	int N;
	int i;
	int sum = 0;
	scanf("%d", &N);
	for(i=1; i<=N; i++)
	{
		if(i%2 == 1)
		{
			sum = sum + i;
		}
	}
	printf("%d", sum);
	getch();
}
