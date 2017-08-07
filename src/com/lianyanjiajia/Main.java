package com.lianyanjiajia;


import java.lang.annotation.Target;

class Top10In10000
{
    public static void main(String args[])
{
    int a[]=new int[20];
    for(int i=0;i<20;i++)
    {
        a[i]=i;
    }
    int b[]=topX(a,10);
    for(int i=0;i<b.length;i++)
        System.out.println(b[i]);
}
  static int[] topX(int total[],int n)
  {
      int max[]=new int[n];
      for(int i=0;i<n;i++)
          max[i]=total[i];
      _quick_sort(max,0,max.length-1);
      for(int i=n;i<total.length;i++)
      {
          if(total[n]>max[0]) {
              int j;
              boolean m = false;
              boolean m1 = false;
              for (j = 1; j < max.length; j++) {
                  if (max[j] > total[n]) {
                      j--;
                      m = true;
                      break;
                  } else if (max[j] == total[n]) {
                      m1 = true;
                  }
              }
              if (!m && !m1)
              {
                  if(total[n]>max[max.length-1])
                  {
                      m=true;
                      j=max.length-1;
                  }
              }
              if(m&&!m1)
              {
                  for(int k=1;k<=j;k++)
                  {
                      max[k-1]=max[k];
                  }
                  max[j]= total[n];
              }
          }
      }
        return max;
  }
    private static void swap(int[] arrays, int i, int j) {
        int temp;
        temp = arrays[i];
        arrays[i] = arrays[j];
        arrays[j] = temp;
    }
    public static void _quick_sort(int[] arrays, int start, int end) {
        if(start>=end){
            return;
        }

        int i = start;
        int j = end;
        int value = arrays[i];
        boolean flag = true;
        while (i != j) {
            if (flag) {
                if (value > arrays[j]) {
                    swap(arrays, i, j);
                    flag=false;

                } else {
                    j--;
                }
            }else{
                if(value<arrays[i]){
                    swap(arrays, i, j);
                    flag=true;
                }else{
                    i++;
                }
            }
        }
        _quick_sort(arrays, start, j-1);
        _quick_sort(arrays, i+1, end);

    }
}