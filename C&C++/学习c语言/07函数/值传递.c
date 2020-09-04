#include<stdio.h>

fun(int n)
{
	int i;
	int sum=0;
	for(i=1;i<=n;i++)
		sum=sum+i;
	return sum;
}

int main()
{
	int x,s;
	scanf("%d",&x);
	s=fun(x);
	printf("ÓÉ1¼Óµ½%d=%d",x,s);
}