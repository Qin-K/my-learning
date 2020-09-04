#include<stdio.h>

#define PI 3.14//不带参数的宏
#define f(x) ((x)*(x))//带参数的宏
int main()
{
	int x;
	scanf("%d",&x);
	printf("The eara is:%f",PI*f(x));
}