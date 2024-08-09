#include <stdio.h>
#include <string.h>

int main() {
    FILE *fptr;
    fptr = fopen("startup-profit.csv", "r");
    char filecontents[2046];
    int cuentarenglon = 0;

    while (fgets(filecontents, 2046, fptr)) {
        for (int i = 0; filecontents[i] != '\0'; i++) {
           if (filecontents[i] == '\n') {
                cuentarenglon++;
           } 
        }
    }

    printf("%i", cuentarenglon);
    

    return 0;
}
