#include<stdio.h>
int main()
{
	int i=1,n=0;
	while(i<=100)
	{
		while(i%3==0)
		{
			printf("%d\n",i);
			break;
		}

		i++;
	}
}