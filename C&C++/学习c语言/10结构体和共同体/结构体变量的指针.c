#include<stdio.h>
#define N 80
struct student
{
	char name[N];
	int age;
};

int main()
{
	struct student student1,student2;
	struct student *p1,*p2;
	p1=&student1;
	p2=&student2;
	scanf("%s%s",student1.name,student2.name);
	student1.age=18;
	student2.age=19;
	printf("%s %d\n",(*p1).name,(*p1).age);
	printf("%s %d\n",p2->name,p2->age);

}