#include<stdio.h>
int fun(int);
int main()
{
	int i;
	for(i=2; i<1000; i++)
	{
		if(fun(i))
		{
			printf("%d  ", i);
		}
	}
	getch();
} 
int fun(n)
{
	int t = 1;
	int i;
	int k = n;
	int a[4];
	int s = 0;
	while (k/10 != 0)
	{
		k = k/10;
		t++;
	}
	k = n;
	for(i=0; i<t; i++)
	{
		a[i] = k%10;
		k = k/10;
		s = s + a[i]*a[i]*a[i];
	}
	if(s == n)
		return 1;
	else return 0;
}
