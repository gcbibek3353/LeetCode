function groupAnagrams(strs: string[]): string[][] {
    let ans = new Array<string[]>();
    let mp = new Map<string,string[]>();
    
    for(let word of strs){
        let sortedWord = word.split("").sort().join("");
        if(mp.has(sortedWord)){
            mp.get(sortedWord).push(word);
        }
       else mp.set(sortedWord,[word]);
    }
    for(let [key,value] of mp){
        ans.push(value);
    }

    return ans;
};