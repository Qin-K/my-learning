#include<stdio.h>
#include<math.h>

int main()
{
	double a, b, c;
	double t;
	double x1, x2;
	scanf("%lf%lf%lf", &a, &b, &c);
	t = b*b-4*a*c;
	if (t < 0)
		printf("error");
	else {
		x1 = -b/2*a + sqrt(t)/2*a;
		x2 = -b/2*a - sqrt(t)/2*a;
	}
	printf("%.2f %.2f", x1, x2);
}