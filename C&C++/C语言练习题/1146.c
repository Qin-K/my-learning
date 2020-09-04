#include<stdio.h>
#include<math.h>
int main()
{
	double s = 0;
	int i;
	double k = 1;
	for(i=0; i<64; i++)
	{
		s = s + k;
		k = k*2;
	}
	printf("%.0lld", s);
	getch();
	return 0;
}

