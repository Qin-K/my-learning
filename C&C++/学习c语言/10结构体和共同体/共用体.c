#include<stdio.h>
#include<string.h>
#define N 80
int main()
{
	union student
	{
		char name[N];
		int age;
	};
	union  student student1;
	strcpy(student1.name,"Qinkai");
	student1.age=19;
	printf("%s %d",student1.name,student1.age);

}