
#include <stdint.h>

/*
 * Assuming v is stored in two's complement, return v's sign bit
 * I.e., 1 for negative, 0 for nonnegative
 */
int signbit(int v);


/*
 * Given v return the number of bits set in v. Return via param c
 * the binary string representation of v
 *
 * 16+1 for '\0'
 */
int nsetbits(uint16_t v, char bits[17]);
