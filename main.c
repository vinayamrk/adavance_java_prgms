#include <stdio.h>
#include <stdlib.h>
#include<string.h>
# define MAX 6
#define MAX_CART 2


void DISPLAY_STOCK();
void shopping_operation(void);
void ADD_ITEM (int cart_item[][MAX_CART] );
void DELETE_ITEM (int cart_item[][MAX_CART]);
void DISPLAY_ITEM (int cart_item[][MAX_CART]);
void BILLING (int cart_item[][MAX_CART]);

  int estore_item[6][3] ={
                        {0,10,1000},
                        {1,20,600},
                        {2,25,650},
                        {3,50,800},
                        {4,56,2500},
                        {5,60,5000}
                       };
  char item[][10]={"shirt","shoes","belt","trouse","wallet","mobile"};
    int n=0;

    int main(int argc,char *argv[])
    {

    int cart_item[10][MAX_CART]={{0}};
    int choice;
    do
    {
        DISPLAY_STOCK(estore_item);
        shopping_operation();
        printf("Enter a choice for shopping:");
        scanf("%d",&choice);
        switch(choice)
        {
            case 1:ADD_ITEM(cart_item);
            break;
            case 2:DELETE_ITEM(cart_item);
            break;
            case 3:BILLING (cart_item);
                   printf("\nPress any key to exit");
                   DISPLAY_ITEM (cart_item);
                   choice=5;
            break;
            case 4: DISPLAY_ITEM (cart_item);
            case 5:exit(0);

        }
    }while(choice!=5);
        return 0;
    }



void DISPLAY_STOCK ()
{


    printf("\t\tstock items in estore\n");
    printf("Item_name\titem_code\tquantity\tunit_price\n");
    int i,j;
    for(i=0;i<MAX;i++)
    {
     printf("%d\t\t",estore_item[i][1]);

    for(j=0;j<3;j++)
        printf("%d\t\t",estore_item[i][j]);
        printf("\n\n");

}
}

void shopping_operation(void)
{
    printf("\n**********Shopping Operation***********\n");
    printf("1.  ADD an item to shopping cart\n");
    printf("2.  DELETE an item from shopping cart\n");
    printf("3.  BILL the item from shopping cart\n");
    printf("4.  DISPLAY an item from shopping cart\n");
    printf("5.  EXIT from shopping operation");
    printf("****************\n");

}
 void ADD_ITEM(int cart_item[][MAX_CART])
 {
     int code,qty;
     printf("enter an item :");
     scanf("%d",&code);
     printf("enter an quantity :");
     scanf("%d",&qty);
     if(cart_item[code][1]==0 && (estore_item[code][1]>qty))n++;
        if(estore_item[code][1]>=qty)
        cart_item[code][1]+=qty;
     else
        printf("out of stock");
 }

void DELETE_ITEM (int cart_item[][MAX_CART])
{
  int code,qty;
  printf("enter an item :");
     scanf("%d",&code);
     printf("enter an quantity :");
     scanf("%d",&qty);
     if(qty==cart_item[code][1])n--;
     if(cart_item[code][1]>=qty)
        cart_item[code][1]-=qty;
     else
        printf("item cannot be deleted");

}

void DISPLAY_ITEM (int cart_item[][MAX_CART])
{
    int i;
     printf("\nDetails of items in the shopping\n\n");
     for(i=0;i<MAX;i++)
     {
         if(cart_item[i][1]!=0)
         {
             printf("\t%s\titems are",item[i]);
             printf("%d\t\n",cart_item[i][1]);
         }
     }
     printf("\ntotal number of items in the cart are %d\t",n);
}

void BILLING (int cart_item[][MAX_CART])
{
    int total=0,i,amt;
    printf("\n\tBILLING details:");
    printf("ITEM_NAME\titem_code\tquantity\tunit_price\n");
    for(i=0;i<MAX;i++)
    {
        if(cart_item[i][1]!=0)
        {
            amt=cart_item[i][2]*estore_item[i][2];
            estore_item[i][1]-=cart_item[i][1];
            total+=amt;
            printf("%s\t",item[i]);
            printf("\t%d\t\t%d\t\t",i,cart_item[i][1]);
            printf("RS.%d\t\tRs.%d\n",estore_item[i][2],amt);

        }
    }
   printf("\n number of items in the shopping cart are:%d\n",n);
   printf("total bill amount for the items in shooping cart:Rs.%d",amt);

}


