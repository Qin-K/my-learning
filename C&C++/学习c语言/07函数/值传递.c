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
	printf("��1�ӵ�%d=%d",x,s);
}