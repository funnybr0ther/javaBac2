public class Valley{
    public static void main(String[] args) {
        int[] val = { -1, -1, -1, 1, 1, 1, 1, 1, 1, -1, -1,-1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1 };
        System.out.println(valley(val)[1]);
    }

     public static int[] valley ( int[] array){
    int[] reponse = new int[2];
    int highestMoutain=0;
    int tempMountain=0;
    int tempDescent=0;
    boolean lookingForTop = (array[0]==1);
    boolean lookingForV = !lookingForTop;
    for (int i=0;i<array.length;i++){
        if (i==array.length-1){
            if (lookingForTop && array[i]==-1){
                highestMoutain=Math.max(1,highestMoutain);
            }
            else if(lookingForV){
                if (array[i]==-1){
                    System.out.println("Was here");
                    highestMoutain=Math.max(Math.min(tempDescent+1,tempMountain),highestMoutain);
                }
                else highestMoutain=Math.max(Math.min(tempDescent,tempMountain),highestMoutain);
                      }
            }

        else if (array[i]==1 && lookingForTop){
            tempMountain+=1;
        }
        else if (array[i]==-1 &&lookingForTop){
            lookingForV=true;
            lookingForTop=false;
            tempDescent=1;
        }
        else if(array[i]==1 && lookingForV){
            lookingForTop=true;
            lookingForV=false;
            highestMoutain=Math.max(Math.min(tempMountain,tempDescent),highestMoutain);
            tempMountain=1;
        }

        else if (array[i]==-1 && lookingForV){
            tempDescent+=1;
        }
    }
    reponse[1]=highestMoutain;
    for(int i =0;i<array.length;i++){
        array[i]=-array[i];
    }
          highestMoutain=0;
          tempMountain=0;
          tempDescent=0;
          lookingForTop = (array[0]==1);
          lookingForV = !lookingForTop;
         for (int i=0;i<array.length;i++){
             if (i==array.length-1){
                 if (lookingForTop && array[i]==-1){
                     highestMoutain=Math.max(1,highestMoutain);
                 }
                 else if(lookingForV){
                     if (array[i]==-1){
                         highestMoutain=Math.max(Math.min(tempDescent+1,tempMountain),highestMoutain);
                     }
                     else highestMoutain=Math.max(Math.min(tempDescent,tempMountain),highestMoutain);
                 }
             }

             else if (array[i]==1 && lookingForTop){
                 tempMountain+=1;
             }
             else if (array[i]==-1 &&lookingForTop){
                 lookingForV=true;
                 lookingForTop=false;
                 tempDescent=1;
             }
             else if(array[i]==1 && lookingForV){
                 lookingForTop=true;
                 lookingForV=false;
                 highestMoutain=Math.max(Math.min(tempMountain,tempDescent),highestMoutain);
                tempMountain=1;
             }

             else if (array[i]==-1 && lookingForV){
                 tempDescent+=1;
             }
         }
         reponse[0]=highestMoutain;
         return reponse;
    }
}
