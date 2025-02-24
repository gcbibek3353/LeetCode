function strStr(haystack: string, needle: string): number {
    if (needle.length === 0) return 0; // Edge case: empty needle
    if (needle.length > haystack.length) return -1; // Needle longer than haystack

    for (let i = 0; i <= haystack.length - needle.length; i++) {
        let match = true;
        for (let j = 0; j < needle.length; j++) {
            if (haystack[i + j] !== needle[j]) {
                match = false;
                break;
            }
        }
        if (match) {
            return i; // Return the starting index of the match
        }
    }

    return -1; // No match found
}