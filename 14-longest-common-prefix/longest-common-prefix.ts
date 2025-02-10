function longestCommonPrefix(strs: string[]): string {
  let commonPrefix = "";
  for(let i = 0; i < strs[0].length; i ++){
    let curChar = strs[0].charAt(i);
    for(let j = 1; j < strs.length; j ++){
        if(strs[j].charAt(i) != curChar) return commonPrefix;
    }
    commonPrefix += curChar;
  }  
  return commonPrefix;
};