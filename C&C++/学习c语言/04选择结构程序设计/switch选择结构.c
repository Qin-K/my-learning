#include<stdio.h>
int main()
{

	int x;
	scanf("%d",&x);
	switch(x)
	{
	case -2:printf("x=-2");break;
	case -1:printf("x=-1");break;
	case 0:printf("x=0");break;
	case 1:printf("x=1");break;
	case 2:printf("x=2");break;
	default:printf("error");
	}
}
