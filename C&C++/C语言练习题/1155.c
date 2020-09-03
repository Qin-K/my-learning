#include<stdio.h>
int fun(int);
int main()
{
	int i;
	for(i=1; i<=100000; i++)
	{
		if(fun(i))
			printf("%d ", i);
	}
	getch();
}
int fun(int n)
{
	int sum = 0;
	int m;
	int i;
	int j;
	int k;
	m = n;
	while(1)
	{
		k = 1;
		j = m%10;
		m = m/10;
		for(i=1; i<=j; i++)
		{
			k = k*i;
		}
		sum = sum + k;
		if(m == 0)
			break;
	}
	if(sum == n)
		return 1;
	else return 0;
}

