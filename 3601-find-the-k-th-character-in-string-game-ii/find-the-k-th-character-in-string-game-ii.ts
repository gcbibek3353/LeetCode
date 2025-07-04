function kthCharacter(k: number, operations: number[]): string {
     let length = 1; // Initial length of "a"
    const lengths: number[] = [1];

    // First, simulate how long the string becomes after each operation
    for (let op of operations) {
        length *= 2; // Both op 0 and 1 double the length
        lengths.push(length);
    }

    let shiftCount = 0;
    // Now trace back from the last operation to the beginning
    for (let i = operations.length - 1; i >= 0; i--) {
        length /= 2;
        if (k > length) {
            k -= length;
            if (operations[i] === 1) {
                shiftCount++;
            }
        }
        // else: it's in the first half, do nothing
    }

    // The original string was just "a"
    let charCode = 'a'.charCodeAt(0);
    charCode = ((charCode - 97 + shiftCount) % 26) + 97;

    return String.fromCharCode(charCode);
};