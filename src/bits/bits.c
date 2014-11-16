
#include "bits.h"


/*
 * assumes two's complement
 */
int signbit(int v)
{
    return (0x80000000 & v) >> 31;
}
