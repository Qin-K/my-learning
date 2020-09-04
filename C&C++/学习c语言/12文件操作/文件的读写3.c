#include<stdio.h>
#define N 18
int main()
{
	FILE *fp;
	struct student
	{
		char name[N];
		int age;
	}*p1,*p2;
	struct student stu2[2];
	struct student stu1[2]=
	{
		{"qinkai",19},
		{"lushuangquan",20},
	};
	p1=stu1;
	p2=stu2;
	fp=fopen("file.txt","w");
	fwrite(p1,sizeof(struct student),2,fp);
	fclose(fp);
	fp=fopen("file.txt","r");
	fread(p2,sizeof(struct student),2,fp);
	printf("%s\n%d",p2->name,p2->age);
	fclose(fp);

}