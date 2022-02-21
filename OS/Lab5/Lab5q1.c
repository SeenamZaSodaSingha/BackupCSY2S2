#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/wait.h>

int main()
{
   pid_t pid, gcpid;
    /* fork another process*/
    cpid = fork();
    if(cpid == 0){ /*child process*/
        gcpid = fork();
        if(gcpid == 0){
            printf("Can you see this3?\n");
            exit(0);
        }
        execlp("/bin/ls", "ls", NULL);//A
        printf("Can you see this2?\n");//B
    } else { //parent process will wait the child to complete
        printf("Can you see this one?\n"); //C
        wait(NULL); printf("receive child complete\n");
        exit(0);
    }
   return 0;
}