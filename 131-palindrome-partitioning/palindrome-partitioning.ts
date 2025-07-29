function partition(s: string): string[][] {
    const res: string[][] = [];
    const path: string[] = [];

    function isPalindrome(str: string, start: number, end: number): boolean {
        while (start <= end) {
            if (str[start] !== str[end]) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    function partitionHelper(index: number): void {
        if (index === s.length) {
            res.push([...path]);
            return;
        }

        for (let i = index; i < s.length; i++) {
            if (isPalindrome(s, index, i)) {
                path.push(s.substring(index, i + 1));
                partitionHelper(i + 1);
                path.pop();
            }
        }
    }

    partitionHelper(0);
    return res;
}
