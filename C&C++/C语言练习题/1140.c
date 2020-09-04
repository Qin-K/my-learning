#include<stdio.h>

int main()
{
	int i;
	int a[5];
	for(i=95860;;i++)
	{
		a[0] = i/10000;
		a[1] = i/1000%10;
		a[2] = i/100%10;
		a[3] = i/10%10;
		a[4] = i%10;
		if(a[0]==a[4] && a[1]==a[3])
		{
			break;
		}
	}
	printf("%d", i);
	getch();
	return 0;
} 
