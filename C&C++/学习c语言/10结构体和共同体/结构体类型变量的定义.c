#include<stdio.h>
#include<string.h>
#define N 80
int main()
{
	struct student
	{
		char name[N];
		char sex[N];
		int age;
		char num[N];
	}student1,student2;
	strcpy(student1.name,"QinKai");
	strcpy(student1.sex,"man");
	student1.age=18;
	strcpy(student1.num,"1620190317");
	printf("this is student1\nname:%s\nsex:%s\nage:%d\nnumber:%s\n",student1.name,student1.sex,student1.age,student1.num);
}