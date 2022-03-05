for file in $(find *.c)
do 
    prog_name=`echo $file | cut -d'/' -f2 | cut -d'.' -f1`
    gcc -o $prog_name $file 2>/dev/null
    if [ -f $prog_name ]
    then
        prog_ans=$(./$prog_name)
        if [ $prog_ans -eq 20 ]
        then 
            printf "%s.c \t 10\n" $prog_name
        else
            printf "%s.c \t 7\n" $prog_name
        fi
    else
        printf "%s.c \t 5\n" $prog_name
    fi
done