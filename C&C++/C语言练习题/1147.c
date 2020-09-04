#include<stdio.h>
int fun1(int);
int fun2(int);
int main()
{
	int n;
	scanf("%d", &n);
	while(1)
	{
		if(n==1)
			break;
		n = fun2(n);
	}
	getch();
	return 0;
}
int fun1(int n)
{
	if(n%2 == 0)
		return 1;
	else return 0;
}
int fun2(int n)
{
	if(fun1(n))
	{
		printf("%d/2=%d\n",n, n/2);
		n = n/2;
	}
	else 
	{
		printf("%d*3+1=%d\n",n,n*3+1);
		n = n*3 + 1;
	}
	return n;
}
