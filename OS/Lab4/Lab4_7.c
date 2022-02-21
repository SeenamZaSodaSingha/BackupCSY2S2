#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/wait.h>

int main()
{
    pid_t pid;
    int i = 0, sum = 0, num;
    printf("Enter positive number: ");
    scanf("%d", &num);
    if (num <= 0) {
        printf("you didnt enter positive number!\n");
        exit(1);
    }
    if (pid = fork() > 0){
        for(i = 1; i <= num; i++)
            sum += i;
        wait(NULL);
        printf("I am parent my sum = %d\n", sum);
    } else {
        for(i = 1; i <= 2 * num; i++)
            sum += i;
        printf("I am child my sum = %d\n", sum);
    }
    return 0;
}
