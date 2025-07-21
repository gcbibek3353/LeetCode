function reverseWords(s: string): string {
    return s.trim().split(' ').map(word => word.trim()).filter(word => word !== "").reverse().join(' ');
};