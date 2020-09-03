#include<stdio.h>

int main()
{
	int i;
	for(i=1; i<40; i++)
	{
		if(i%2!=0 && i%5!=0)
			printf("%d/40,", i);
	}
	return 0;
}