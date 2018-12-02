#include <sys/ipc.h>
#include <stdio.h>
#include <stdlib.h>
#include <sys/types.h>
#include <sys/wait.h>
#include <unistd.h>


int main(){
    int processPipe[6];
    char writemessage[3][100];
    char readmessage[100];
    //initializing pipe
    for(int i=0;i<3;i++){
        pipe(&processPipe[2*i]);
    }
    
    for (int i = 0; i < 3; i++) {
        if(fork()==0){
            printf("writing child process %d\n",i);
            int j=0;
            int counter=0;
            while(1){
                char in;
                if(in == '\n'){
                    counter++;
                    if(counter==2){
                        break;
                    }
                }else{
                    scanf("%c",&in);
                    writemessage[i][j]=in;
                    j++;
                }
            }
            write(processPipe[2*i+1],writemessage[i],sizeof(writemessage[i]));
            exit(0);
        }
    }
    for (int i = 0; i < 3; i++) {
        wait(NULL);
        read(processPipe[2*i],readmessage,sizeof(readmessage));
        printf("Message from child process %d Message: %s",i,readmessage);
    }
}
//final commit