#include<stdio.h>
int main()
{
	int x;
	scanf("%d",&x);
	/*1if */
	if(x>0)
		printf("%d>0\n",x);
	/*2 if else */
	if(x==0)
		printf("%d=0\n",x);
	else printf("%d!=0\n",x);
	/*3 if else if...else*/
	if(x>0)
		printf("%d>0\n",x);
	else if(x<0)
		printf("%d<0\n",x);
	else printf("%d=0\n",x);
	/*4 if��Ƕ��*/
	if(x>0)
		if(x%5==0)
			printf("%dΪ5�ı���\n",x);
}