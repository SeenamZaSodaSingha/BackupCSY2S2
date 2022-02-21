#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/wait.h>

int main()
{
    pid_t pid, pidsub;
    int i, j;
    printf("Only parents before fork");
    for(i = 0; i < 5; i++){
        pid = fork();
        if(pid == 0){
            if((i %2 == 0)){
                printf("I am child number %d\n", i);
                int num_gc = 3; /*8.1*/
                for(j = 0; j < num_gc; j++){
                    pid sub =fork(); /*8.2*/
                    if(pid_sub == 0){
                        printf("I am grandchild num %d of even child number %d\n", j, i);
                        /*8.3*/
                    }
                } //for j
                while(wait(NULL) != -1); /*8.4*/
                exit(0);
            } else { // odd child
                printf("I am child number %d\n", i);
                int num_gc = 4; /*8.5*/
                for(j = 0; j < num_gc; j++){
                    pidsub = fork();
                    if(pid_sub == 0 /*8.6*/){
                        printf("I am grandchild num %d of even child number %d\n", j, i);
                        /*8.7*/
                    }
                } //for j
                while(wait(NULL) != -1);
                exit(0);
            }
            //exit(0) /*8.8*/
        }// if child
    }//i
    while(wait(NULL) != -1);
    return 0;
}
