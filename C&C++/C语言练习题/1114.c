#include<stdio.h>

int main()
{
	int a[4];
	int i, j, k;
	for(i=0; i<4; i++)
	{
		scanf("%d", &a[i]);
	}
	for(i=0; i<4; i++)
		for(j=0; j<4; j++)
			for(k=0; k<4; k++)
			{
				if(a[i]!=a[j] && a[i]!=a[k] && a[j]!=a[k])
					printf("%d %d %d \n", a[i], a[j], a[k]);
			}
	return 0;
}