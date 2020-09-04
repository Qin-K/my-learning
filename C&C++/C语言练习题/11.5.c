#include<stdio.h>

int main()
{
	int N, i, j, t, av1 = 0, av2 = 0, av3 = 0 , ss = 0, smax;
	struct stu
	{
		char num[10];
		char name[10];
		int score[3];
	}s[80];
	scanf("%d", &N);
	for(i=0; i<N; i++)
		scanf("%s%s%d%d%d", s[i].num, s[i].name, &s[i].score[0], &s[i].score[1], &s[i].score[2]);
	for(i=0; i<N; i++)
	{
		av1 = av1 + s[i].score[0]/N;
		av2 = av2 + s[i].score[1]/N;
		av3 = av3 + s[i].score[2]/N;
	}
	smax = s[0].score[0] + s[0].score[1] + s[0].score[2];
	t = 0;
	for(i=0; i<N; i++)
	{	
		ss = 0;
		for(j=0; j<3; j++)
			ss = ss + s[i].score[j];
		if(ss > smax)
		{
			smax = ss;
			t = i;
		}
	}
	printf("%d %d %d\n%s %s %d %d %d", av1, av2, av3, s[t].num, s[t].name, s[t].score[0], s[t].score[1], s[t].score[2]);
	return 0;
}