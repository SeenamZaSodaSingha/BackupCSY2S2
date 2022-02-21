#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/types.h>
#include <pthread.h>

void *runner(void *param);
int csum = 0, msum = 0; // remove msum later
int main(int argc, char  *argv[])
{
    pthread_t tid;
    pthread_attr_t attr;
    pthread_attr_init(&attr);
    pthread_create(&tid, &attr, runner, argv[1]);
    int upper = atoi(argv[1]);
    // lazy for do the checker
    if (upper > 0)
    {
        for (int i = 0; i <= upper; i++)
            msum += i;
    }
    pthread_join(tid, NULL); // AKA: Wait

    printf("CSUM is: %d\n", csum);
    printf("MSUM is: %d\n", msum);
    printf("DIFF is: %d", csum - msum);
    return 0;
}

void *runner(void *param)
{
    int upper = atoi(param) * 2;
    if (upper > 0)
    {
        for (int i = 0; i <= upper; i++)
            csum += i;
    }
    pthread_exit(0);
}
