#include<stdio.h>
#define N 80
struct student
{
	char name[N];
	int score;
};
int main()
{
	int i;
	struct student student[5];
	struct student *p;
	p=student;
	for(i=0;i<5;i++)
		scanf("%s%d",&(p+i)->name,&(p+i)->score);
	for(i=0;i<5;i++)
		printf("%s %d\n",(p+i)->name,(p+i)->score);
}