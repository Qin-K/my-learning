#include<stdio.h>
#include<stdlib.h>
int main()
{
	int a[4];
	int i, j;
	int t;
	for(i=0; i<4; i++)
	{
		scanf("%d", &a[i]);	
	}
	for(i=0; i<4; i++)
		for(j=i; j<4; j++)
		{
			if(a[j] < a[i])
			{
				t = a[i];
				a[i] = a[j];
				a[j] = t;
			}
		}
	for(i=0; i<4; i++)
	{
		printf("%d ", a[i]);
	}
	system("pause");
}
