#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
int main()

{
    int pfd[2];
    int pid;
    int nread, SIZE = 1024;
    char buf[SIZE];
    char inbuf[SIZE * 2];

    FILE *file_desc = fopen("aaa.txt", "w");
    //"w" write mode
    int fd = fileno(file_desc);
    // obtain file descriptor
    printf("current file descriptor id is %d\n", fd);
    // after mapping to stdout, texts to be displayed
    // will be redirected to aaa.txt instead
    /* ans2.1 */
    pipe(pfd);
    pid = fork();
    if (pid == 0) // child
    {
        close(pfd[1]); // tidy unused end
        // read until end of stream
        while ((nread = read(pfd[0], buf, SIZE)) != 0)
        {
            fprintf(file_desc, "%s\n", buf);
            printf("avoid overflow no conversion %s.\n", buf);
        }
        close(pfd[0]); // properly close unused resource
    }
    else
    { // parents
        close(pfd[0]); // tidy unused end
        // strcpy(inbuf,"1200"); //equiv "1200\0"
        dup2(pfd[1], 1); // no worry on \0
        // write(pfd[1], inbuf, strlen(buf) + 1); // sending 12 digit string
        //+1 for padding end of string character (\0)
        close(pfd[1]);
        execlp("ls", "ls", "-l", NULL);
        // close and wait for child to complete
    }
    /* to aaa.txt instead of screen */
    printf("please read this line in aaa.txt\n");
    close(fd);
    return 0;
}
