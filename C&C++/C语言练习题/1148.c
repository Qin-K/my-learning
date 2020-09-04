#include<stdio.h>

int wo(int a[],int len,int n);

int main()

{

    int i,len;

    int a[10000];

    a[0]=1;

    len=1;

    for(i=2;i<=1977;i++)

    {

        len=wo(a,len,i);

    }

    for(i=len-1;i>=0;i--)

    {

        printf("%d",a[i]);

    }
    getch();

}

int wo(int a[],int len,int n)

{

    int i,rem;

    rem=0;

    for(i=0;i<len;i++)

    {

        rem=rem+a[i]*n;

        a[i]=rem%10;

        rem=rem/10;

    }

    if(rem>0)

    {

        while(rem!=0)

        {

            a[len++]=rem%10;

            rem=rem/10;

        }

    }

    return len;

}
