#include<stdio.h>

int main()
{
	int x, y , n = 0, i, a[5];
	scanf("%d", &x);
	y = x;
	for(i=0; y>0; i++)//求它是几位数
	{
		y = y/10;
		n++;
	}
	printf("%d\n", n);
	for(i=0; i<n; i++)//将每位数保存到a数组中，顺序相反
	{
		y = x%10;
		x = x/10;
		a[i] = y;
	}
	for(i=0; i<n; i++)//逆序输出a数组
	{
		printf("%d", a[n-1-i]);
		if(i != n-1)//判断是否为最后几个，没有空格
		printf(" ");
	}
	printf("\n");//顺序输出a数组
	for(i=0; i<n; i++)
		printf("%d", a[i]);
	return 0;
}