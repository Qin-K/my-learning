#include<stdio.h>
int main()
{
	int x;
	scanf("%d",&x);
	if(x>0)
		switch(x)
	{
		case 1:printf("x=1");break;
		case 2:printf("x=2");break;
		case 3:printf("x=3");break;
		case 4:printf("x=5");break;
		case 5:printf("x=6");break;
		default:printf("x>5");
	}
	else if(x==0)
		printf("x=0");
	else	printf("x<0");

}