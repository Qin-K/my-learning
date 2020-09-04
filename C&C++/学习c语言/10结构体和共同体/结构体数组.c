#include<stdio.h>
#define N 80
int main()
{
	int i;
	struct student
	{
		char name[N];
		int age;
	};
	struct student student[5]=
	{
		{"QinKai",18},
		{"Liu junjie",19},
		{"Ma binqiang",19},
		{"Lu shuangquan",19},
		{"Luo xingzhuagn",20},
	};
	for(i=0;i<5;i++)
		printf("name:%s,age:%d\n",student[i].name,student[i].age);

}
