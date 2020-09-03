#include<stdio.h>

int main()
{
	int n;
	int i;
	scanf("%d", &n);
	for(i=2; i<n; i++)
	{
		if(n%i == 0)
			break;
	}
	if(i==n)
		printf("1");
	else printf("0");
	getch();
	return 0;
}
