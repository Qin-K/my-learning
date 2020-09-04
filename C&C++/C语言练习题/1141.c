#include<stdio.h>

int main()
{
	int i, j, k;
	for(i=0; i<=20; i++)
		for(j=0; j<=33; j++)
			for(k=0; k<=300; k++)
			{
				if(5*i+3*j+k/3==100 && k%3==0 && i+j+k==100) 
				{
					printf("cock=%d,hen=%d,chicken=%d\n", i,j,k);
				}
			}
	getch();
	return 0;
}
