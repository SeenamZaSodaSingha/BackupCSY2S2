#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/wait.h>

int main()
{
    char userChoice = 'z';
    pid_t cpid;
    // cpid = fork();
    while (userChoice != 'q')
    {
        // print menu
        printf("a: ls \n");
        printf("b: ps \n");
        printf("c: who am i \n");
        printf("q for quit \n");
        scanf(" %c", &userChoice);
        cpid = fork();

        /* child begin*/
        if (cpid == 0)
        {
            switch (userChoice)
            {
            case 'a':
                /* code */
                execlp("/bin/ls", "ls", NULL);
                break;
            case 'b':
                /* code */
                execlp("/bin/ps", "ps", NULL);
                break;
            case 'c':
                /* code */
                execlp("whoami", "whoami", NULL);
                break;
            case 'q':
                break;
            default:
                printf("SYNTAX INVALID\n");
                break;
            }
            exit(0);
        }
        wait(NULL);
    }
    printf("----PARENT TERMINATE----\n");
    return 0;
}
