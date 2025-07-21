function rotateString(s: string, goal: string): boolean {
    if (s.length !== goal.length) {
        return false;
    }
    const doubledString = s + s;
    return doubledString.includes(goal);
}