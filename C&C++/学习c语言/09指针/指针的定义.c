#include<stdio.h>

#define N 80
int main()
{
	int a;
	int b[N]={1,2,3,4};
	int c[2][3]={{1,2,3},{2,2,3}};
	char s[N]="hello";
	int *p;
	int *p1;
	int (*p2)[3];
	char *p3;
	p=&a;
	p1=b;
	p2=c;
	p3=s;
	printf("%d\n",(*(p2+1))[2]);
	printf("%c\n",*p3);
}