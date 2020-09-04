#include<stdio.h>
#include<stdlib.h>
int main()
{
	int a[10];
	int i, j;
	int t;
	for(i=0; i<10; i++)
	{
		scanf("%d", &a[i]);	
	}
	for(i=0; i<10; i++)
		for(j=i; j<10; j++)
		{
			if(a[j] > a[i])
			{
				t = a[i];
				a[i] = a[j];
				a[j] = t;
			}
		}
	for(i=0; i<10; i++)
	{
		printf("%d ", a[i]);
	}
	system("pause");
}
