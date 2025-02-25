function canConstruct(ransomNote: string, magazine: string): boolean {
    if (ransomNote.length > magazine.length) return false;

    const array: string[] = magazine.split("");

    for (const char of ransomNote) {
        const index: number = array.indexOf(char);
        if (index === -1) return false;

        array[index] = "";
    };

    return true;
};