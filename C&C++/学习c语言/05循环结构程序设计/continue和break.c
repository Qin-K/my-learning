#include<stdio.h>
int main()
{
	int m,i,j=0;
	scanf("%d",&m);
	for(i=2;i<m;i++)
		if(m%i==0)
		{
			j=1;break;
		}
	if(j==1)
		printf("%d不是质数\n",m);
	else printf("%d是质数\n",m);

	for(i=1;i<m;i++)
		if(i%2==0)
			continue;
		else printf("%d ",i);
	
			
}