#include<stdio.h>

int main()
{
	int n;
	int i;
	long long s = 1;
	long long k;
	scanf("%d", &n);
	for(i=1; i<=n; i++)
	{
		s = s*i;
	}
	printf("%lld", s);
	getch();
}
