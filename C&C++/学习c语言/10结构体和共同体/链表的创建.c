#include<stdio.h>
#include<stdlib.h>
#define N 80
#define LEN sizeof(struct student)
struct student
{
	char name[N];
	int age;
	struct student *next;
};
int main()
{
	struct student *creat(int *a);
	struct student *p,*head;
	int i;
	int a[N]={1,2,3,4,5};
	head=creat(a);
	p=head->next;
	for(i=0;i<5;i++)
	{
		printf("%d",p->age);
		p=p->next;
	}
}
struct student *creat(int *a)
{
	int i;
	struct student *head,*p1,*p2;
	head=(struct student *) malloc (sizeof(struct student));
	p2=head;
	for(i=0;i<5;i++)
	{
		p1=(struct student *) malloc (LEN);
		p1->age=a[i];
		p2->next=p1;
		p2=p1;
	}
	p2->next='\0';
	return head;
}