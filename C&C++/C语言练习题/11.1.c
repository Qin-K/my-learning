#include<stdio.h>
int main()
{
	struct date
	{
		int y, m, d;
	}s;
	int i, t = 0, m[12] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	scanf("%d%d%d", &s.y, &s.m, &s.d);
	if((s.y%4==0 && s.y%100!=0) || s.y%400==0)
		m[1] = 29;
	for(i=0; i<s.m-1; i++)
		t = t + m[i];
	t = t + s.d;
	printf("%d", t);
	return 0;
}