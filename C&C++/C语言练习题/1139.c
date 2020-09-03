#include<stdio.h>

int main()
{
	int n;
	int i,j;
	int flag;
	scanf("%d", &n);
	for(i=2; i<=n; i++)
	{
		flag = 1;
		for(j=2; j<i; j++)
		{
			if(i%j == 0)
			{
				flag = 0;
				break;
			}
		}
		if(flag)
		{
			printf("%d ", i);
		}
	}
	getch();
	return 0;
}
