#include<stdio.h>

int main()
{
	int A, B, C, D, E, F;
	for(A=0; A<2; A++)
		for(B=0; B<2; B++)
			for(C=0; C<2; C++)
				for(D=0; D<2; D++)
					for(E=0; E<2; E++)
						for(F=0; F<2; F++)
						{
							if(A+B>=1 && A+D<2 && A+E+F==2 && (B+C==2 || B+C==0) && C+D==1 && D+E==0)
							{

								if(A==1) printf("A,");
								if(B==1) printf("B,");
								if(C==1) printf("C,");
								if(D==1) printf("D,");
								if(E==1) printf("E,");
								if(F==1) printf("F,");
							}
						}

}

