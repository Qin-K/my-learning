#include<stdio.h>

int main()
{
	int x, y , n = 0, i, a[5];
	scanf("%d", &x);
	y = x;
	for(i=0; y>0; i++)//�����Ǽ�λ��
	{
		y = y/10;
		n++;
	}
	printf("%d\n", n);
	for(i=0; i<n; i++)//��ÿλ�����浽a�����У�˳���෴
	{
		y = x%10;
		x = x/10;
		a[i] = y;
	}
	for(i=0; i<n; i++)//�������a����
	{
		printf("%d", a[n-1-i]);
		if(i != n-1)//�ж��Ƿ�Ϊ��󼸸���û�пո�
		printf(" ");
	}
	printf("\n");//˳�����a����
	for(i=0; i<n; i++)
		printf("%d", a[i]);
	return 0;
}