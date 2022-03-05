//Thammanit Chensintananan 63050144
#include <stdio.h>
int main()
{
    int input, sum=0, cnt=0;
    scanf("%d", &input);
    while(input > 0){
        sum += input;
        cnt++;
        scanf("%d",  &input);
        
    }
    printf("Summary = %d Mean = %.2f", sum, (double)sum/cnt);
    return 0;
}
