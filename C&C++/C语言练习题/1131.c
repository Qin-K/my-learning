#include<stdio.h>
int fun(int n);
int main()
{
	int a[40];
	int i;
	int n;
	scanf("%d", &n);
	for (i=0; i<n; i++) {
		a[i] = fun(i+1);
	}
	for(i=0; i<n; i++){
		printf("%d ", a[i]);
	}
	getch();
	return 0;
}
int fun(int n)
{
	if(n == 0)
		return 0;
	if(n == 1)
		return 1;
	return fun(n-1) + fun(n-2);
}
