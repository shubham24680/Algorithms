#include <stdio.h>
#include <conio.h>
#include <stdlib.h>
#define MAX 50

void insert();
void delete ();

int array[MAX];
int rear = -1;
int front = -1;
int add_item;

int main()
{
    int choice, i, check = 1;
    while (check)
    {
        printf("Enter your choice(1. Insert | 2. Delete | Any numeric Key. Final output) : ");
        scanf("%d", &choice);
        switch (choice)
        {
        case 1:
            insert();
            break;
        case 2:
            delete ();
            break;
        default:
            check = 0;
            break;
        }
    }

    if (front == -1)
        printf("Queue is empty.\n");
    else
    {
        printf("Queue is : ");
        for (i = front; i <= rear; i++)
            printf("%d ", *(array + i));
        printf("\n");
    }

    getch();
    return 0;
}
void insert()
{
    if (rear == MAX - 1)
        printf("Queue Overflow.\n");
    else
    {
        if (front == -1)
            front = 0;
        printf("Insert the element in queue : ");
        scanf("%d", &add_item);
        rear++;
        *(array + rear) = add_item;
    }
}

void delete ()
{
    if (front == -1 || front > rear)
    {
        printf("Queue Underflow \n");
        return;
    }
    else
    {
        printf("Element deleted from queue is : %d\n", *(array + front));
        front++;
    }
}