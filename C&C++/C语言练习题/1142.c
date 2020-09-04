#include<stdio.h>

int main()
{
	int i;
	int s = 0;
	int n;
	scanf("%d", &n);
	for(i=1; ;i++)
	{
		s += i*i*i;
		if(s > n)
			break;
	}
	printf("%d", i-1);
	getch();
	return 0;
}
