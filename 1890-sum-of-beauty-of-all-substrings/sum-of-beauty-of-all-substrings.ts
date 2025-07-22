function beautySum(s: string): number {
    const n = s.length;
    let sum = 0;

    for (let i = 0; i < n; i++) {
        const freqMap: Map<string, number> = new Map();

        for (let j = i; j < n; j++) {
            const ch = s[j];
            freqMap.set(ch, (freqMap.get(ch) || 0) + 1);

            let maxFreq = -Infinity;
            let minFreq = Infinity;

            for (const count of freqMap.values()) {
                minFreq = Math.min(minFreq, count);
                maxFreq = Math.max(maxFreq, count);
            }

            sum += (maxFreq - minFreq);
        }
    }

    return sum;
}
