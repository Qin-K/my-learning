#include<stdio.h>
int fun(int n);
int main(void)
{
	int n;
	int i, j;
	long long k;
	long long sum = 0;
	scanf("%d", &n);
	for(i=1; i<=n; i++) 
	{
		k = 1;
		for(j=1; j<=i; j++)
		{
			k = k*j;
		}
		sum = sum + k;
	}
	printf("%lld", sum);
	getch();
	return 0;	
} 

