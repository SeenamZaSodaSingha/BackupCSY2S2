#include <stdio.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/wait.h>

int main(int argc, char const *argv[])
{
    pid_t pid;
    int i;

    pid = fork();
    if(pid > 0) { //parent
        i = 1;
        printf("my copy of i is %d\n", i);
    } else { // child
        i = 2; 
        printf("my copy of i is %d\n", i)
    }
    return 0;;
}
