#include <sys/shm.h>
#include <sys/ipc.h>
#include <stdio.h>

int main(){
	int shmid;
	int (*array)[3];
	key_t key = ftok("file",60);
	shmid = shmget(key,sizeof(int[3][3]),0666|IPC_CREAT);
	array = shmat(shmid,0,SHM_RDONLY);
	for(int i=0;i<3;i++){
		for(int j=0;j<3;j++){
			printf("%d ",array[i][j]);
		}
		printf("\n");
	}
	printf("\nRead to memory successful--\n");
	shmdt(array);
	shmctl(shmid,IPC_RMID,NULL);
	return 0;
}
