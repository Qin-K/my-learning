#include<stdio.h>
#define N 80
int main()
{
	int i;
	char *fp;
	char ch1[N],ch2[N];
	gets(ch1);
	fp=fopen("file.text","w");
	fputs(ch1,fp);
	fclose(fp);
	fp=fopen("file.text","r");
	fgets(ch2,N,fp);
	printf("%s",ch2);
	fclose(fp);


	
}