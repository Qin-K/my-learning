#include<stdio.h>
#define N 80
int main()
{
	int i;
	FILE *fp;
	struct stu
	{
		char name[N];
		int age;
	}stu1[2],stu2[2],*p1,*p2;
	p1=stu1;
	p2=stu2;
	for(i=0;i<2;i++)
		scanf("%s %d",(p1+i)->name,&(p1+i)->age);
	fp=fopen("file.txt","wb+");
	for(i=0;i<2;i++)
		fprintf(fp,"%s %d ",(p1+i)->name,(p1+i)->age);
	rewind(fp);
	for(i=0;i<2;i++)
		fscanf(fp,"%s %d",(p2+i)->name,&(p2+i)->age);
	for (i=0;i<2;i++)
		printf("%s %d\n",(p2+i)->name,(p2+i)->age);

	fclose(fp);
}