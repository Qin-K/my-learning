 #include<stdio.h>
 
 int main()
 {
 	int a[100];
 	int i = 0, cnt = 0;
 	int t;
 	int max;
 	for(i=0;;i++) {
 		scanf("%d", &a[i]);
 		if(a[i] == -1)
 			break;
 		cnt++;
 	}
 	max = a[0];
 	for (i=0; i<cnt; i++) {
 		if(a[i] > max) {
 			max = a[i];
 		}
 	}
 	printf("%d", max);
 	getch();
 }
