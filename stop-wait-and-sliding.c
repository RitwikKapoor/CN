//stop-wait program
#include<stdio.h>
int main(){
        int framesize, sent = 0, ack, i;
        printf("Enter number of frames\n");
        scanf("%d", &framesize);
        while(1){
                for(i = 0; i < framesize; i++){
                        printf("frame %d has been transmitted.\n", sent);
                        sent++;
                        if(sent == framesize){
                                break;
                        }
                }

                printf("\n Enter the last acknowlegement received\n");
                scanf("%d", &ack);
                if(ack >= framesize){
                        break;
                }else{
                        sent = ack;
                }
        }

        return 0;
}

//sliding-window
#include<stdio.h>
int main(){
        int w,i,f,frames[50];
        printf("enter window size: ");
        scanf("%d", &w);
        printf("Enter number of frames to transmit: ");
        scanf("%d", &f);
        printf("\n enter %d frames: ",f);
        for(i = 1; i <=f; i++){
                scanf("%d", &frames[i]);
        }
        for(i = 1; i <=f; i++){
                if(i % w == 0){
                        printf("%d\n", frames[i]);
                        printf("acknowledgment of above frames sent is received by sender\n\n");
                }else{
                        printf("%d\n", frames[i]);
                }
        }

        if(f % w != 0){
                printf("acknowledgment of above frames sent is received by sender\n\n");
        }
}
                                                                                                
