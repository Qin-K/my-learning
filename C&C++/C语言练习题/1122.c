#include<stdio.h>

int main()
{
	int a, b;
	int m[10], n[10];
	int s1, s2;
	int i, j = 0, k;
	for(a=1; a<3000; a++)
	{
		for(b=1; b<3000; b++)
		{
			s1 = 0, s2 = 0;
			for(i=1; i<=a/2; i++)
			{
				if(a%i == 0)
					s1 = s1 + i;
			}
			for(i=1; i<=b/2; i++)
			{
				if(b%i == 0)
					s2 = s2 + i;
			}
			if(s1==b && s2==a && (a != b))
			{
				m[j] = a;
				n[j] = b;
				j++;
			}

		}
	}
	for(i=0; i<j; i++)
		printf("(%d, %d)", m[i], n[i]);
}