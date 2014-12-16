
#ifndef BITS_H_
#define BITS_H_

#include <stdint.h>

/*
 * Assuming v is stored in two's complement, return v's sign bit
 * I.e., 1 for negative, 0 for nonnegative
 */
int signbit(int v);


/*
 * Given v return the number of bits set in v. Return via param c
 * the binary string representation of v
 */
int nsetbits(uint16_t v, char bits[17]);  // 16+1 for '\0'


/*
 * Compute even parity of v, that is given an even number of set bits,
 * return 0, otherwise 1
 */
int parity(uint32_t v);

/*
 * Alternative implementation
 */
int parity_(uint32_t v);


/*
 * Return v with lowest bit set, clearing all others
 */
int lsb(uint32_t v);


/*
 * Return value of nth bit in v (0-based indexing)
 */
int getbit(uint64_t v, int n);


/*
 * Return v with nth bit set (0-based indexing)
 */
uint64_t setbit(uint64_t v, int n);


/*
 * Return v with nth bit cleared (0-based indexing)
 */
uint64_t clearbit(uint64_t v, int n);


/*
 * Return v with nth bit toggled (0-based indexing)
 */
uint64_t togglebit(uint64_t v, int n);


/*
 * Swap bits in v at `indices' i, j (0-based indexing)
 */
uint64_t swap64(uint64_t v, int i, int j);


#endif  /* #define BITS_H_ */
