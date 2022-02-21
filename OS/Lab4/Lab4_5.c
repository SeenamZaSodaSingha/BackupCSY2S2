#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/wait.h>

int main()
{   
    pid_t pid;
    int i, sum = 0;
    if((pid = fork()) > 0){
        i = 1;
        sum += i;
        printf("I am parent. My id is %d\n", getpid());
    } else {
        i = 2;
        sum += i;
        printf("I am child, my id is %d\n", getpid());
        printf("my parent id is %d\n", getppid());
        exit(0);
    }
    wait(NULL);
    printf("(parent) sum = %d\n", sum);
    return 0;
}
