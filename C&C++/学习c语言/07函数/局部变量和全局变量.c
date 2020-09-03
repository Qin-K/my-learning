#include<stdio.h>
int a,b;
int main()
{
	int c=2;
	scanf("%d",&a);
	printf("%d/%d=%d",a,c,a/c);
	fun();
}
fun(void)
{
	int d=2;
	scanf("%d",&b);
	printf("%d/%d=%d",b,d,b/d);
}
