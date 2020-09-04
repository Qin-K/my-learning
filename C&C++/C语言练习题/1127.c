#include<stdio.h>
#include<stdio.h>
int main()
{
	int n;
	int a, s;
	int i;
	scanf("%d", &n);
	a = n*n - n +1;
	s = n*n*n;
	printf("%d*%d*%d=%d=%d", n, n, n, s, a);
	for(i=1; i<n; i++)
	{
		a = a + 2;
		printf("+%d",a);
	}
}
