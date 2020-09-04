#include<stdio.h>
#include<math.h>
fun(double *p,char *s)
{
	int i;
	*p=sqrt(*p);
	for(i=0;s[i]!='\0';i++)
		if('a'<=s[i]&&s[i]<='z')
			s[i]=s[i]-32;

}
int main()
{

	double n;
	char s[80]="hello";
	scanf("%lf",&n);
	fun(&n,s);
	printf("%f\n",n);
	printf("%s\n",s);
}