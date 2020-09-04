#include<stdio.h>

struct student
{
	char num[10];
	char name[10];
	int score[3];
}s[100];
int main()
{
	void input( struct student s[], int N);
	void print(struct student s[], int N);
	int N;
	scanf("%d", &N);
	input(s, N);
	print(s, N);
}
void input( struct student s[], int N)
{
	int i;
	for(i=0; i<N; i++)
		scanf("%s%s%d%d%d", s[i].num, s[i].name, &s[i].score[0], &s[i].score[1], &s[i].score[2]);
}
void print(struct student s[], int N)
{
	int i;
	for(i=0; i<N; i++)
	{
		printf("%s,%s,%d,%d,%d", s[i].num, s[i].name, s[i].score[0], s[i].score[1], s[i].score[2]);	
		printf("\n");
	}
}