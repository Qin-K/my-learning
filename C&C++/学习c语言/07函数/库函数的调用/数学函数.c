#include<stdio.h>
#include<math.h>
int main()
{
	int x,a;
	double m,n,a1,a2,a3,a4,a5,a6,a7;
	printf("������int\n");
	scanf("%d",&x);
	printf("����������double\n");
	scanf("%lf%lf",&m,&n);
	a=abs(x);
	a1=fabs(m);
	a2=pow(m,n);
	a3=sqrt(m);
	a4=sin(m);
	printf("%d %f %f %f %f",a,a1,a2,a3,a4);

}
