#include<stdio.h>
int fun(int n);
int main()
{
	int i;
	for(i=1000; i<10000; i++)
	{
		if(fun(i))
		{
			printf("%d ", i);
		}
	}
	getch();
	return 0;
} 
int fun(int n)
{
	int i, j;
	i = n/100;
	j = n%100;
	if((i+j)*(i+j) == n)
	{
		return 1;
	}
	else return 0;
}
