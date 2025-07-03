function kthCharacter(k: number): string {
    let word = "a";
    while (word.length < k) {
        let wordToAppend = "";
        for (let i = 0; i < word.length; i++) {
            let letter = String.fromCharCode(word.charCodeAt(i) + 1);
            wordToAppend += letter;
        }
        word += wordToAppend;
    }
    return word.charAt(k - 1);
};