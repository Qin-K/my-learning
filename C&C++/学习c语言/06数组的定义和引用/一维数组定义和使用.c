#include<stdio.h>
int main()
{
	int i,j;
	int a[5]={1,2,3,4,5};
	int b[5];
	for(i=0;i<5;i++)
		printf("%d\n",a[i]);
	for(j=0;j<5;j++)
		scanf("%d",b);
	for(j=0;j<5;j++)
	printf("%d\n",a[j]);
	
}