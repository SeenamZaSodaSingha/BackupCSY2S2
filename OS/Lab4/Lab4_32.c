#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/wait.h>

int main(void){
    pid_t pid;
    int i; int sum = 3;
    for(int i = 0; i < 3; i++){
        pid = fork();
        if(pid == 0){ //child
        printf("my copy of i is %d\n", i);
        exit(0);
        printf("should not be excuted\n");
        }
    }
    while(wait(NULL) != -1); // empty loop
    printf("bye form main \n", sum);
    return 0;
}
