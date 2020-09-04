#include<stdio.h>
int fun(int x);
int main()
{
	int x;
	scanf("%d", &x);
	printf("%d", fun(x));
	getch();
	return 0;	
}
int fun(int x)
{
	if(x == 1)
		return 10;
	else return fun(x-1) + 2;
}
