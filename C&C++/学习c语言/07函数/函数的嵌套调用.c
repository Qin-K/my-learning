/*k次方之和*/
#include<stdio.h>
#include<math.h>
int fun1(int m,int n);//求m的n次方
int fun2();//k次方之和
int main()
{
	int i,j,s;
	scanf("%d%d",&i,&j);
	s=fun2(i,j);
	printf("f(%d,%d)=%d",i,j,s);
}
int fun1(int m,int n)
{
	int s;
	s=pow(n,m);
	return s;
}
int fun2(int m,int n)
{
	int i,sum=0;
	for(i=1;i<=n;i++)
		sum=sum+fun1(m,i);
	return sum;
}
