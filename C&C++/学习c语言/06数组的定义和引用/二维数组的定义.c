#include<stdio.h>
int main()
{
	int i,j;
	int a[2][3];
	printf(" ‰»Î:\n");
	for(i=0;i<2;i++)
		for(j=0;j<3;j++)
			scanf("%d",&a[i][j]);
	printf(" ‰≥ˆ:\n");
	for(i=0;i<2;i++)
	{
		printf("\n");
		for(j=0;j<3;j++)
			printf("%d ",a[i][j]);
	}
}
