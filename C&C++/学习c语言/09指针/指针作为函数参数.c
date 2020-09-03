#include<stdio.h>
#include<math.h>
fun(int *p)
{
	*p=pow(*p,3);
}
int main()
{
	int x;
	scanf("%d",&x);
	fun(&x);
	printf("%d",x);
}