#include<stdio.h>
#define PI 3.14159
int main()
{
	float area;
	float r;
	scanf("%f", &r);
	area = PI*r*r;
	printf("%.2f", area);
}
