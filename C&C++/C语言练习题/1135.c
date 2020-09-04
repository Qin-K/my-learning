#include<stdio.h>
#include<math.h>
int fun(int, int);
int main()
{
	int a, n;
	int i;
	int sum = 0;
	scanf("%d%d", &a, &n);
	for(i=1; i<=n; i++)
	{
		sum = sum + fun(a, i);
	}
	printf("%d", sum);
	getch();
	return 0;
}
int fun(int a, int i)
{
	int j;
	int k=0;
	for(j=0; j<i; j++)
	{
		k = k + a*pow(10,j);
	}
	return k;
}
