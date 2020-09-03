#include<stdio.h>
#include<stdlib.h>

int main(void)
{
	int len;
	int *a;
	int i, j;
	int t;
	printf("请输入数组长度:\n");
	scanf("%d", &len);
	a = (int *) malloc (len*sizeof(int));
	printf("请输入每个数组元素:\n");
	for(i=0; i<len; i++)
	{
		scanf("%d", &a[i]);
	}
	for(i=0; i<len; i++)
	{
		for(j=0; j<len-1-i; j++)
		{
			if (a[j] > a[j+1])
			{
				t = a[j];
				a[j] = a[j+1];
				a[j+1] = t;
			}
		}
	}
	for(i=0; i<len; i++)
	{
		printf("%d ", a[i]);
	} 
	getch();
	return 0;
} 
