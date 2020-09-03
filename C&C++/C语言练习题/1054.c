#include<stdio.h>

int main()
{
	int m, n;
	int i;
	int s = 0;
	scanf("%d%d", &m, &n);
	for (i=m; i<=n; i++)
	{
		if (isprime(i))
			s = s + i;
	}
	printf("%d", s);
}
int isprime(int x)
{
	int i;
	for(i=2; i<x; i++)
	{
		if (x%i == 0)
			break;
	}
	if (i == x)
		return 1;
	else return 0;
}