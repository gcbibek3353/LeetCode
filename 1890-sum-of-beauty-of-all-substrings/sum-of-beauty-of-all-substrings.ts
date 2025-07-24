function beautySum(s: string): number {
    const n = s.length;
    let totalSum = 0;

    for (let i = 0; i < n; i++) {
        const freq = new Array(26).fill(0); // assuming lowercase letters
        let maxFreq = 0;
        const countFreq = new Map(); // key: frequency, value: count of characters with that frequency

        for (let j = i; j < n; j++) {
            const chIdx = s.charCodeAt(j) - 97;
            const prevFreq = freq[chIdx];

            // Decrease count of previousfrequency
            if (prevFreq > 0) {
                countFreq.set(prevFreq, countFreq.get(prevFreq)! - 1);
                if (countFreq.get(prevFreq) === 0) {
                    countFreq.delete(prevFreq);
                }
            }

            // Increase frequency of current character
            freq[chIdx]++;
            const newFreq = freq[chIdx];
            countFreq.set(newFreq, (countFreq.get(newFreq) || 0) + 1);

            maxFreq = Math.max(maxFreq, newFreq);

            // Min frequency can be found by checking keys of countFreq
            const minFreq = Math.min(...countFreq.keys());

            totalSum += (maxFreq - minFreq);
        }
    }

    return totalSum;
}