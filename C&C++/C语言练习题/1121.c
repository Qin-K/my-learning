#include<stdio.h>

int main()
{
	int x = 0;
	while(1)
	{
		if (x%8==1 && x/8%8==1 && x/8/8%8==7)
			if (x%17==4 && x/17%17==15)
				if (2*(x/8/8/8) == x/17/17)
				{	
					printf("%d", x);
					break;
				}
		x++;
	}
}