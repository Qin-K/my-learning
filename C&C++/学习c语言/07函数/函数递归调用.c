//Çón!
#include<stdio.h>
int fun(int n);
int main()
{
	int n,s;
	scanf("%d",&n);
	s=fun(n);
	printf("n!=%d",s);

}
int fun(int n)
{
	int s;
	if(n==0||n==1)
		s=1;
	else s=fun(n-1)*n;
	return s;
}