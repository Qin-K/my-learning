#include<stdio.h> 
#include<math.h>
int main()
{
	double PI;
	int i = 1;
	double k;
	double sum = 0;
	while(1)
	{
		k = pow(-1, i+1)*1.0/(2*i-1);
		if(fabs(k) < pow(10,-6))
			break;
		sum = sum + k;
		i++;
	}
	PI = 4*sum;
	printf("%.6f", PI);
	getch();
	return 0;
}
