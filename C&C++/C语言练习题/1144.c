#include<stdio.h>
#include<math.h>

int fun(long long n);
int main()
{
	long long i;
	for(i=0; i<=200000; i++)
	{
		if(fun(i))
		{
			printf("%lld ",i);
		}
	}
	getch();
	return 0;
}
int fun(long long n)
{
	int i;
	int len;
	int m;
	m = n;
	for(i=1,len=1; ; i++,len++)
	{
		if(m/10 == 0)
			break;
		m = m/10;
	}
	if(n*n%((int)pow(10,len)) == n)
		return 1;
	else return 0;
}
