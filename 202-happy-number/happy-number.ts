function isHappy(n: number): boolean {
    let seen = new Set<number>();  // HashSet for O(1) lookups

    while (n !== 1 && !seen.has(n)) {
        seen.add(n);
        n = get_sum(n);
    }

    return n === 1;
}

const get_sum = (num: number): number => {
    let sum = 0;
    while (num > 0) {
        let digit = num % 10;
        sum += digit ** 2;
        num = Math.floor(num / 10);
    }
    return sum;
};
