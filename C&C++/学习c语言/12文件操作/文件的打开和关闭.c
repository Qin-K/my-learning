#include<stdio.h>
int main()
{
	FILE *fp;
	fp=fopen("f.txt","w");
	fclose(fp);
}
