#include<stdio.h>
#include<stdlib.h>
typedef struct stu
{
	int num, score;
	struct stu *next;
}node;
#define m sizeof(node)
int main()
{
	node *a, *b, *p1, *p2;
	int N, M;
	int i, j;
	int n[100], s[100];
	int t;
	a = (node *) malloc (m);
	b = (node *) malloc (m);
	p1 = a;
	p2 = b;
	scanf("%d%d", &N, &M);
	for(i=1; i<N; i++)
	{
		scanf("%d%d", &p1->num, &p1->score);
		p1->next = (node *) malloc (m);
		p1 = p1->next;
	}
	scanf("%d%d", &p1->num, &p1->score);
	p1->next = NULL;
	for(i=1; i<M; i++)
	{
		scanf("%d%d", &p2->num, &p2->score);
		p2->next = (node *) malloc (m);
		p2 = p2->next;
	}
	scanf("%d%d", &p2->num, &p2->score);
	p2->next = NULL;
	p1->next = b;
	for(i=0; i<N+M; i++)
	{
		n[i] = a->num;
		s[i] = a->score;
		a = a->next;
	}
    for(i=0; i<N+M; i++)
	{
		for(j=i; j<N+M; j++)
		{
			if(n[j] < n[i])
			{
				t = n[i];
				n[i] = n[j];
				n[j] = t;
				t = s[i];
				s[i] = s[j];
				s[j] = t;
			}
		}
	}
	for(i=0; i<N+M; i++)
	{
		printf("%d %d\n",n[i], s[i]); 
	}
	return 0;
}