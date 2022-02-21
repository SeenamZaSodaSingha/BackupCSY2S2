#include <stdio.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/wait.h>s

int main(void){
    pid_t pid;
    int i, sum = 3;

    pid = fork();
    if(pid > 0) { //parent
        i = 1; sum += i;
        printf("my copy of i is %d\n", i);
    } else { // child
        i = 2; sum += i;
        // sleep(10);
        printf("my copy of i is %d\n", i)
    }
    printf("my sum = %d\n", sum);
    wait(NULL);
    return 0;
}
