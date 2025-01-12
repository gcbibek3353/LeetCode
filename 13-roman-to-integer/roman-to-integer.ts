function romanToInt(s: string): number {
    let result = 0;
    let prevValue = 0;
    const romanValues: { [key: string]: number } = {
        'I': 1,
        'V': 5,
        'X': 10,
        'L': 50,
        'C': 100,
        'D': 500,
        'M': 1000
    };

    for (let i = s.length - 1; i >= 0; i--) {
        const currValue = romanValues[s[i]];
        if (currValue < prevValue) {
            result -= currValue;
        } else {
            result += currValue;
        }
        prevValue = currValue;
    }
    return result;
};