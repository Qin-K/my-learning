#include<stdio.h>
#define N 80
int main()
{
	FILE *fp1;
	char ch1,ch[N];
	int i;
	fp1=fopen("f.txt","w");
	for(i=1;i<=9;i++)
		fputc('H',fp1);
	fclose(fp1);
	fp1=fopen("f.txt","r");
	for(i=0;i<9;i++)
		ch[i]=fgetc(fp1);
	for(i=0;i<9;i++)
		printf("%c",ch[i]);
	fclose(fp1);

}