#include<stdio.h>
#include<math.h>
int fun(int t);
int main()
{
	int i, j;
	int h[80];
	int n = 0;
	int t;
	for(i=100, j=0; i<1000; i++)
	{
		if (fun(i))
		{
			h[j++] = i;
			n++;
		}
	}
	for(i=0; i<n; i++)
		for(j=i; j<n; j++)
		{
			if(h[j] < h[i])
			{
				t = h[i];
				h[i] = h[j];
				h[j] = t;
			}
		}
	for(i=0; i<n; i++)
		printf("%d\n", h[i]);
	return 0;
	
}
int fun(int t)
{
	int a, b, c, s;
	a = t/100;
	b = t/10%10;
	c = t%10;
	s = pow(a, 3) + pow(b, 3) + pow(c, 3);
	if(t == s)
		return 1;
	else return 0;
}